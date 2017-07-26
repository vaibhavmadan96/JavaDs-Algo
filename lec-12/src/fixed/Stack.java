package fixed;
//import exception.*;

public class Stack<T> {
	private T[] arr;
	private int top;
	
	public Stack()
	{
		this.arr=(T[])new Object[maxSize];
		this.top=-1;
	}
	public int size()
	{
		return 0;

	}
	
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	public T top() //throws StackEmptyException
	{
		if(this.top==-1)
		{
//			throw new StackEmptyException();
			System.out.println("Stack empty");
			return null;
		}
		return arr[top];
	}
	public void push(T data)// throws StackFullException
	{
		if(this.top==this.arr.length-1)
		{
			//throw new StackFullException();
			System.out.println("Stack is full");
		}
		this.top++;
		this.arr[this.top]=data;
	}
	public String toString()
	{
		String retval="";
		for(int i=this.top;i>=0;i--)
		{
			retval+=arr[i]+"->";
		}
		
		return retval;
	}
	public void display()
	{
		System.out.println(this);
	}
}
