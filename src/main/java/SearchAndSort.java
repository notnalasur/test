//Doctora,Feivel Lixen R.
//Rosal, Anton Felipe D.R.
//ICS2605 1CSA
//Lab Exercise 04
//This program is meant to compare the different search and sorting methods(Assume that the input from the user is valid)
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class SearchAndSort 
{
	public static void main(String args[]) throws IOException
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Doctora, Feivel Lixen R.");
                System.out.println("Rosal, Anton Felipe D.R.");  
      
		System.out.println("Enter the maximum number of items to be processed:");
		int scanItems = input.nextInt();
                
                String list1[] = new String[scanItems];
                String list2[] = new String[scanItems];
                input.nextLine();
                try
                {
                   BufferedReader textFile = new BufferedReader(new FileReader("ioc2020.txt"));
                   int x = 0;
                   while (x < list1.length)
                   {
                    list1[x] = textFile.readLine();
                    list2[x] = list1[x];
                    x++;
                   }
                }   
                catch(Exception error)
                {
                    error.printStackTrace();
                }
                
                for(int x = 0;x < list1.length;x++)
                {
                    System.out.println(x+1 + ". "+ list1[x]);
                }
                System.out.println("Please enter a search key:");
                String searchKey = input.nextLine();                  
                int indexLinear = linearSearch(list1, searchKey);
                System.out.println("Linear Search Index: " + indexLinear);
                System.out.println("The value of the linear search counter variable is " +linearSearchCounter);
                mergeSortMethod(list1, 0, list1.length-1);
                for(int x = 0; x < list1.length; x++){
                    System.out.println(x+1 + ". "+ list1[x]);
                }
                System.out.println("The value of the merge sort counter variable is " +mergeSortCounter);
                int indexSearched = binarySearchRecursion(list1, 0, list1.length-1, searchKey);
                System.out.println("Returned index of binary search: " + indexSearched);
                System.out.println("The value of the binary search counter variable is " +binarySearchCounter);
                iterativeInsertionSort(list2, 0, list2.length - 1);
                for(int x = 0; x < list2.length; x++){
                    System.out.println(x+1 + ". "+ list2[x]);
                }
                System.out.println("The value of the insertion sort counter variable is " +insertionSortCounter);
                
	}
        public static int linearSearchCounter = 0;
        public static int mergeSortCounter = 0;
        public static int binarySearchCounter = 0;
        public static int insertionSortCounter = 0;

	public static int linearSearch(String search[], String key) 
	{
		for (int i = search.length-1; i >= 0; i--) 
		{
                        linearSearchCounter++;
			if(key.compareTo(search[i]) == 0) 
			{
                            return i+1;
                        }            
		}
		return -1;
	}
	public static void mergeSortMethod(String mustbeSorted[], int startIndex, int endIndex) 
	{               
		if(startIndex < endIndex) 
		{
			int middle = (startIndex+endIndex)/2;
			mergeSortMethod(mustbeSorted, startIndex, middle);
			mergeSortMethod(mustbeSorted, middle+1, endIndex);
			merge(mustbeSorted, startIndex, middle, endIndex);
		}
	}
	public static void merge(String Sortit[], int startIndex, int middleIndex, int endIndex) 
	{
	    String[] leftStringArray = new String[middleIndex - startIndex + 1];
	    String[] rightStringArray = new String[endIndex - middleIndex];

	    for (int i = 0; i < leftStringArray.length; i++)
	        leftStringArray[i] = Sortit[startIndex + i];
	    for (int i = 0; i < rightStringArray.length; i++)
	        rightStringArray[i] = Sortit[middleIndex + i + 1];

	    int leftIndex = 0;
	    int rightIndex = 0;

	    for (int i = startIndex; i < endIndex + 1; i++) 
            {
	        if (leftIndex < leftStringArray.length && rightIndex < rightStringArray.length)
                {
                     mergeSortCounter++;
	            if (leftStringArray[leftIndex].compareTo(rightStringArray[rightIndex]) < 0)
                    {
	               Sortit[i] = leftStringArray[leftIndex];
	               leftIndex++;
	            }
                    else 
                    {
	                Sortit[i] = rightStringArray[rightIndex];
	                rightIndex++;
	            }
	        } 
                else if (leftIndex < leftStringArray.length) 
                {                    
	            Sortit[i] = leftStringArray[leftIndex];
	            leftIndex++;
	        }
                else if (rightIndex < rightStringArray.length) 
                {                   
	            Sortit[i] = rightStringArray[rightIndex];
	            rightIndex++;
	        }
	    }
		
	}
	public static int binarySearchRecursion(String search[], int startIndex, int endIndex, String key) 
	{		
		if (startIndex > endIndex) 
		{
			return -1;
		}
		else 
		{
			int middle = (startIndex + endIndex)/2;
			binarySearchCounter++;
			if (key.compareTo(search[middle]) == 0) 
			{
                                return middle+1;
			}
                        binarySearchCounter++;
			if (key.compareTo(search[middle]) < 0) 
			{
                               
				return binarySearchRecursion(search, startIndex, middle-1, key);
			}
			else 
			{                               
				return binarySearchRecursion(search, middle+1, endIndex, key);
			}
		}
		
	}
	public static void iterativeInsertionSort(String sort[],int startIndex, int endIndex) 
	{
		for (int s = startIndex; s <= endIndex; s++) 
		{
			String element = sort[s];
			int i = s - 1;
                        insertionSortCounter++;
			while (i >= 0 && sort[i].compareTo(element) < 0) 
			{
				sort[i + 1] = sort[i];
				i = i - 1;
                                insertionSortCounter++;
			}
			sort[i+1] = element;
                        
		}
		
	}
}