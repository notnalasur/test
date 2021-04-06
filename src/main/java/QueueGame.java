//Doctora,Feivel Lixen R.
//Rosal, Anton Felipe D.R.
//ICS2605 1CSA
//Lab Exercise 07
//A game that uses a Queue
import javax.swing.JOptionPane;
public class QueueGame
{
    public static void main(String args[]){       
        System.out.println("Doctora, Feivel Lixen R.");
        System.out.println("Rosal, Anton Felipe D.R.");
        int s = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of syllables to be played: "));
        int n = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of children playing: "));
        String[] letterArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        Queue kidsGame = new Queue(n);
        System.out.print("Children: ");
        for(int x = 0; x < n; x++){
            System.out.print(letterArray[x] + " ");
            kidsGame.enqueue(letterArray[x]);
        }
        System.out.println("");
        System.out.println("Game is starting.");
        
        int sCount = s;
        String elimOrder = "";
        while(!kidsGame.isEmpty())
        {           
           for(int x = 1; x < sCount; x++)
           {  
               String temp =(String)kidsGame.dequeue();
               kidsGame.enqueue(temp);
           }
           elimOrder +=(String)kidsGame.dequeue() + " ";           
        }
        System.out.println("The final elimination order is: " + elimOrder);
    
}
}