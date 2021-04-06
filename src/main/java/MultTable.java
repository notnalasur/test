/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.Scanner;
public class MultTable {
    /*Rosal, Anton Felipe D.R.
      ICS2605 1CSA
      Lab Exercise 01
      Multiplication Table
    comment
    */
    public static void main (String args []){
        Scanner input = new Scanner (System.in);
        
        int n;
        System.out.println("Rosal, Anton Felipe D.R.");
        System.out.println("Please input a positive integer.");
         n = input.nextInt();
        System.out.println("The number you have input is: " + n);
        for(int x = 1; x <= n; x++){
            System.out.print(x + " ");
            if(x%10==0)
            {
                System.out.println(" ");
            }
    }
        System.out.println(" "); 
        long start = System.nanoTime();
        for(int x = 1;x <= n;x++){
            for(int y = 1;y <=n; y++){
                System.out.print(x+" x "+y+" = "+x*y);
                System.out.print(" ");
            }
            System.out.println(" ");
            
                } 
        long end = System.nanoTime();
        System.out.print("The elapsed time is "+((end-start)/1000000)+" milliseconds.");
                       

}
}
