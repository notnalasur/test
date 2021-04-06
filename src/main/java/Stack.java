//Doctora,Feivel Lixen R.
//Rosal, Anton Felipe D.R.
//ICS2605 1CSA
//Lab Exercise 05
//Stack Implementation
public class Stack <T>
{
	private int Stackize = 100;
	private int topStack = -1;
	private Object[] Stack;
	public Stack() 
	{
            this.Stack = new Object[this.Stackize];
	}
	public Stack(int sizeN) 
	{
            if (sizeN > 0) {this.Stackize = sizeN;}
            this.Stack = new Object[Stackize];
	}
        public void clear()
        {
            this.topStack = -1;            
        }
	public boolean isEmpty() 
	{
            return (this.topStack == -1);
	}
	public boolean isFull() 
	{
            return (this.topStack == this.Stackize-1);
	}
	public int push(T element) 
	{
            if (isFull()) {return -999;}
            this.Stack[++this.topStack] = element;
            return 1;
	}
	public T pop() 
	{
            if(isEmpty()) {return null;}
            T element = (T) Stack[topStack--];
            return element;
	}
	public T peek() 
	{
            if(isEmpty()) {return null;};
            return (T)Stack[topStack];
        }
}
