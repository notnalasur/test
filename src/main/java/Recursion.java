/*
Rosal, Anton Felipe D.R.
ICS 2605 1CSA
Lab Exercise 02
This program reverses the input
This program also checks if the input is a palindrome or not
 */

import java.util.*;
public class Recursion {
    public static void main (String args[]) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Rosal, Anton Felipe D.R.");
        System.out.println("Please enter a value for t from 1 to 2: ");
        int t = input.nextInt();
        input.nextLine();
        System.out.println("Please enter a sequence of strings for s: "); 
        String s = input.nextLine();
        String [] stringArray = s.split(" ");
        
        if(t == 1){
            for(int x = 0; x < stringArray.length; x++){
                System.out.println(stringArray[x]);
            }
            System.out.println("The reversal is: ");
            int start = 0;
            int end = stringArray.length - 1;
            reverse(stringArray, start, end);
            for(int x = 0; x < stringArray.length; x++){
                System.out.println(stringArray[x]);
            }
        }
        
        else if(t == 2){
          for(int x = 0; x < stringArray.length; x++){
                System.out.println(stringArray[x]);
            }
          int start = 0;
          int end = stringArray.length - 1;
          if (isPalindrome(stringArray, start, end) == true){
              System.out.println("is a palindrome");
          }
          else{
              System.out.println("is not a palindrome");
          }
          
          
        }
                
    }
    
     static void reverse(String stringArray[], int start, int end)
    {
        if (start < end){
            String temp = stringArray[start];
            stringArray[start] = stringArray[end];
            stringArray[end] = temp;
            reverse(stringArray, start+1, end-1);
        }      
    }
     static boolean isPalindrome(String array[], int start, int end){
         if(start >= end){
             return true;
         }
         else if (array[start].compareTo(array[end]) == 0){
             return isPalindrome(array, start + 1, end - 1);
         }
         else{
             return false;
         }
     }
}
