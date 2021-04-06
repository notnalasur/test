//Doctora,Feivel Lixen R.
//Rosal, Anton Felipe D.R.
//ICS2605 1CSA
//Lab Exercise 07
//Queue Implementation
public class Queue<T> 
{
   private static int front = -1, rear = -1;
   private static int qSize = 100;
   private Object queue[];
   
   public Queue(){
       queue = new Object[qSize];
   }
   
  public Queue(int size){
       front = rear = -1;
       qSize = size;
       queue = new Object[qSize];
   }
  
 public void clear(){
     this.front = -1;
     this.rear = -1;
 }
 
 public boolean isEmpty(){
     return this.front == -1;
 }
 
 public boolean isFull(){
     return((this.rear+1)%this.qSize) == this.front;
 }
 
 public int enqueue(T element){
     if(isFull()){
         return -999;
     }
     if(isEmpty()){
         this.front = 0;
     }
     this.rear = (this.rear + 1)%this.qSize;
     this.queue[rear] = element;
     return 1;
 }
 
 public T dequeue(){
    if(isEmpty()){
        return null;
    }
    T element = (T)queue[this.front];
    if(this.front == this.rear){
        clear();
    }
    else{
        this.front = (this.front + 1)% qSize;
    }
    return element;
}
 
 public T peek(){
     if(isEmpty()){
         return null;
     }
    T element = (T)queue[this.front];
     return element;
 }
 
}

