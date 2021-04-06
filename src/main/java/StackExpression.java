//Doctora,Feivel Lixen R.
//Rosal, Anton Felipe D.R.
//ICS2605 1CSA
//Lab Exercise 06
//This Program converts Postfix expressions to infix and evaluates the Postfix expression/it can also converts infix to postfix and evaluates it
import javax.swing.JOptionPane;
public class StackExpression 
{
    public static Stack postfixStack = new Stack();
    public static void main(String args[]) 
    {
        System.out.println("Doctora, Feivel Lixen R.");
        System.out.println("Rosal, Anton Felipe D.R.");
        int t = Integer.parseInt(JOptionPane.showInputDialog("Please enter a value for t ranging from 1 to 2"));

        if(t == 1)
        {
            double answer = 0;
            String transformed = "";
            String evaluate = JOptionPane.showInputDialog("Please enter a postfix expression");
            System.out.println("Postfix: " + evaluate);
            transformed = postfixToInfix(evaluate);
            System.out.println("Infix: " + transformed);
            answer = evalPostfix(evaluate);
            System.out.println("Value: " + answer);
        }
        if(t == 2)
        {
            String transformtoPostfix = JOptionPane.showInputDialog("Please enter an Infix expression");
            System.out.println("Infix: " + transformtoPostfix);
            String trs = infixToPostfix(transformtoPostfix);
            System.out.println("Postfix: " + trs);
            double eval = evalPostfix(trs);
            System.out.println("Value: " + eval);
        }
    }
    public static String postfixToInfix(String evalthis)
    {
        String[] arrayPostfix = evalthis.split(" ");
        for (int i = 0; i < arrayPostfix.length; i++) 
        {
            if (isOperator(arrayPostfix[i])) 
            {
                String A = (String)postfixStack.pop();
                String B = (String)postfixStack.pop();
                postfixStack.push("(" + B +" "+ arrayPostfix[i] +" "+ A +")");
            }
            else
            {
                postfixStack.push(arrayPostfix[i]);
            }
        }
        return (String)postfixStack.pop();
    }
    public static double evalPostfix(String eval) 
    {
        String[] arrayPostfix = eval.split(" ");
        for (int i = 0; i < arrayPostfix.length; i++) 
        {
            if (isOperator(arrayPostfix[i])) 
            {
                double number1 = (double)postfixStack.pop();
                double number2 = (double)postfixStack.pop();
                switch(arrayPostfix[i].charAt(0)) 
                {
                    case '+' -> postfixStack.push(number2+number1);
                    case '*' -> postfixStack.push(number2*number1);
                    case '-' -> postfixStack.push(number2-number1);
                    case '^' -> postfixStack.push(Math.pow(number2, number1));
                    case '/' -> postfixStack.push(number2 / number1);
                    case '%' -> postfixStack.push(number2 % number1);  
                }
            }
            else
            {
                postfixStack.push(Double.parseDouble(arrayPostfix[i]));
            }
        }
        return (double)postfixStack.pop();
    }
    public static String infixToPostfix(String accept)
    {
        Stack<String> infixStackOps = new Stack();
        String[] apt = accept.split(" ");
        String compile = "";
        for (int i = 0; i < apt.length; i++) 
        { 
            if (isOperator(apt[i])) 
            {
                while (!infixStackOps.isEmpty() && precVal(apt[i]) <= precVal(infixStackOps.peek()))
                {
                    if(infixStackOps.peek().compareTo("(") == 0)
                    {
                        infixStackOps.pop();
                    }
                    else
                    {
                        compile += infixStackOps.pop() + " ";
                    }
                }
                if(apt[i].compareTo(")") != 0)
                {
                    infixStackOps.push(apt[i]); 
                }
            }
            else
            {
                compile += apt[i] + " "; 
            }
        } 
        while(!infixStackOps.isEmpty())
        {
            compile += infixStackOps.pop() + " ";
        }
        return compile;
    }
    public static boolean isOperator(String isitanOperator) 
    {
        switch(isitanOperator.charAt(0))
        {
            case '+': return true;
            case '*': return true;
            case '-': return true;
            case '^': return true;
            case '/': return true;
            case '(': return true;
            case ')': return true;
            case '%': return true;
        }
	return false;
    }
    public static int precVal(String evalops)
    {
        switch(evalops.charAt(0))
        {
            case '+', '-' -> {return 1;}
            case '%' -> {return 2;}
            case '*', '/' ->{return 3;}
            case '^' -> {return 6;}
            case '(' ->{return 9;}
            case ')' ->{return 0;}
        }
        return -1;
    }
}
