package assignment1;

import java.util.Scanner;

public class Part1 {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		String input;
		boolean end=true;
		
		while(end)
		{
			input=sc.nextLine();
			
			if(input.equals("END"))
			{
				end=false;
			}
			
			String a=input.replace(", ", " ");
			String [] arr = a.split(" "); 
			
			System.out.println("Number of words in " + input + " are " + arr.length);
		}
	}

}
