package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part3 {
	
	@SuppressWarnings({ "null", "unused", "resource" })
	public static void main(String[] args) 
	{

		Scanner sc=new Scanner(System.in);
		String input;
		List<String> ST = new ArrayList<String>();
		String[] mnemonic = {"STOP", "ADD", "SUB", "MULT", "MOVER", "MOVEM", "COMP", "BC", "DIV", "READ", "PRINT", "START",
				"END", "ORIGIN", "EQU", "LTORG", "DS", "DC", "AREG", "BREG", "CREG", "EQ", "LT", "GT", "NE", "ANY"};
		boolean end=true;
		
		int st=0, temp=0;
		
		while(end)
		{
			input=sc.nextLine();
			
			String a=input.replace(", ", " ");
			String [] arr = a.split(" ");
			temp=st;
			
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
			}
			
			if(input.equals("END"))
			{
				end=false;
			}
		}
		
		System.out.println("Symbol");
		for(int i=0; i<ST.size(); i++)
		{
		System.out.println(ST.get(i));
		}

	}
}