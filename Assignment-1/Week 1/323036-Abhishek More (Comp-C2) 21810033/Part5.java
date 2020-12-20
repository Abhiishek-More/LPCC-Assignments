package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		
		List<String> LT = new ArrayList<String>();
		List<Integer> LTA = new ArrayList<Integer>();
		
		String input;
		boolean end=true;
		int lc=0;
		
		while(end)
		{
			input=sc.nextLine();
			
			String a=input.replace(",", " ");
			String [] arr = a.split(" "); 
			
			if(arr[0].equals("START"))
			{
				lc=Integer.valueOf(arr[1]);
				lc=lc-1;
			}
			lc=lc+1;
			
			int size=arr.length;
			
			Pattern p = Pattern.compile("=");   // the pattern to search for
		    Matcher m = p.matcher(arr[size-1]);

		    if(m.find())
		    {
		    	LT.add(arr[size-1]);
		    	LTA.add(lc-1);
		    }
		    

			if(input.equals("END"))
			{
				end=false;
			}
			
		}
		
		System.out.println();
		System.out.println("LITERAL TABLE(LT)");
		System.out.println("\nLITERAL " + "ADDRESS");
		for(int i=0; i<LT.size(); i++)
		{
			System.out.println(LT.get(i) + "	" + LTA.get(i));
		}
	}

}
