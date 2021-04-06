//Doctora,Feivel Lixen R.
//Rosal, Anton Felipe D.R.
//ICS2605 1CSA
//Lab Exercise 03
//This program is meant to find the highest N given maxTime
import java.util.Scanner;
public class BigO 
{
	public static void main(String args[]) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Doctora, Feivel Lixen R.");
                System.out.println("Rosal, Anton Felipe D.R.");
		System.out.println("Enter a Positive Integer");
		long maxTime = input.nextLong();
		
		long current_Time;
		long start_Time;
		long timeCheck = 0;
		
		start_Time = System.nanoTime();
		for(long i = 1;; i++) 
		{
			System.out.println("n: " + i);
			MultiTable(i);
			current_Time = System.nanoTime();
			timeCheck = (current_Time - start_Time);
			if((timeCheck/1000000000) > maxTime) 
			{
				System.out.println("Final n: " + i);
				current_Time = 0;
				start_Time = 0;
				timeCheck = 0;
				break;
			}
		}
		
		start_Time = System.nanoTime();
		for(long i = 1;; i++) 
		{
			System.out.println("n: " + i);
			long Result = FibonacciIterative(i);
			current_Time = System.nanoTime();
			timeCheck = (current_Time - start_Time);
			System.out.println("Elapsed Time: " + timeCheck/1000000000);
			if((timeCheck/1000000000) > maxTime) 
			{
				System.out.println("Result: " + Result);
				System.out.println("Final n: " + i);
				current_Time = 0;
				start_Time = 0;
				timeCheck = 0;
				break;
			}
			else 
			{
				System.out.println("Result: " + Result);
			}
		}
		
		start_Time = System.nanoTime();
		for(long i = 1;; i++) 
		{
			System.out.println("n: " + i);
			long Result = FibonacciRecursion(i);
			current_Time = System.nanoTime();
			timeCheck = (current_Time - start_Time);
			if((timeCheck/1000000000) > maxTime) 
			{
				System.out.println("Result: " + Result);
				System.out.println("Final n: " + i);
				current_Time = 0;
				start_Time = 0;
				timeCheck = 0;
				break;
			}
			System.out.println("Result: " + Result);
		}
		
	}
	static void MultiTable(long i)
	{
		char space = ' ';
                int p = (int)i;
		int number =(int)i;
		
		long numberArray[] = new long[p];
		System.out.print("Integers: ");
		for(int x = 0; x < number; x++) 
		{
			numberArray[x] += (x+1);			
			System.out.print(numberArray[x] + " ");
		}
		System.out.println("");
		int everyNumber = 1;
		for (int multiple = 0; multiple < number; multiple++) 
		{
			for(int n = 0; n < number; n++) 
			{
				if (everyNumber % number == 0) 
				{
					System.out.println(numberArray[multiple]*numberArray[n] +" ");
					everyNumber = 0;
					everyNumber++;
				}
				else 
				{
					System.out.print(numberArray[multiple]*numberArray[n]+" ");
					everyNumber++;
				}
			}
			
		}
	}
	static long FibonacciIterative(long n) 
	{

		if(n == 0) 
		{
			return 0;
		}
		else 
		{
			long q = 0;
			long y = 1;
			long z;
			for(int t = 1; t < n; t++) 
			{
				z = q;
                q = y;
                y = z + q;
			}
			return y;
		}
	}
	static int FibonacciRecursion(long n) 
	{
		if(n <=0) 
		{
			return 1;
		}
		return FibonacciRecursion(n-1) + FibonacciRecursion(n-2);
	}
}