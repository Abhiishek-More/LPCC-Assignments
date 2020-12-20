package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		List<String> LT = new ArrayList<String>();
		List<Integer> LTA = new ArrayList<Integer>();
		List<Integer> PT = new ArrayList<Integer>();
		List<String> ST = new ArrayList<String>();
		List<Integer> STA = new ArrayList<Integer>();
		
		String[] mnemonic = {"STOP", "ADD", "SUB", "MULT", "MOVER", "MOVEM", "COMP", "BC", "DIV", "READ", "PRINT", "START",
				"END", "ORIGIN", "EQU", "LTORG", "DS", "DC", "AREG", "BREG", "CREG", "EQ", "LT", "GT", "NE", "ANY"};
		
		int st=0, temp=0;
		
		String input;
		boolean end=true;
		int lc=0;
		int lcount=0;
		int index=0;
		
		while(end)
		{
			input=sc.nextLine();
			
			String a=input.replace(",", " ");
			String [] arr = a.split(" "); 
			
			if(arr[0].equals("START"))
			{
				lc=Integer.valueOf(arr[1]);
				lc=lc-2;
			}
			

			temp=st;
			lc=lc+1;
			
			int size=arr.length;
			
			Pattern p = Pattern.compile("=");   // the pattern to search for
		    Matcher m = p.matcher(arr[size-1]);

		    if(m.find())
		    {
		    	lcount++;
		    	index++;
		    	LT.add(arr[size-1]);
		    }
		    
		    if(input.equals("LTORG") || input.equals("END"))
		    {
		    	int tlc=lc;
		    	int tindex=index-lcount;
		    	if(input.equals("LTORG"))
		    	{
		    		PT.add(tindex);
		    	}
		    
		    	for(int i=0; i<lcount; i++)
		    	{
		    		LTA.add(tindex, tlc);
		    		tlc+=1;
		    		tindex++;
		    	}
		    	lc=tlc-1;
		    	lcount=0;
		    }
		    
		    A:
				for(int i=0; i<mnemonic.length; i++)
				{
				if(arr[0].equals(mnemonic[i]))
				{
					st++;
					break A;
				}
				}
				
				if(st==temp)
				{
					ST.add(arr[0]);
					STA.add(lc);
				}
		    
			if(input.equals("END"))
			{
				end=false;
			}	
		}
		
		System.out.println();
		System.out.println("SYMBOL TABLE(ST)");
		System.out.println("|SYMBOL" + "|" + "ADDRESS|");
		for(int i=0; i<ST.size(); i++)
		{
		System.out.println(" " +ST.get(i) + "	" + STA.get(i));
		}
		
		System.out.println();
		System.out.println("LITERAL TABLE(LT)");
		System.out.println("|LITERAL" + "|" +"ADDRESS|");
		for(int i=0; i<LT.size(); i++)
		{
			System.out.println(" " + LT.get(i) + "	" + LTA.get(i));
		}
		
		System.out.println();
		System.out.println(" POOL TABLE(PT)");
		System.out.println("|LITERAL NUMBER|");
		for(int i=0; i<PT.size(); i++)
		{
			System.out.println("      " + PT.get(i));
		}
		
	}

}
