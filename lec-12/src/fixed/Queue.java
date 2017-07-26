package fixed;
//import exception.*;

public class Queue<T> {
	private T[] arr;
	private int front;
	private int rear;

	public Queue()
	{
		this.arr=(T[])new Object[maxSize];
		this.front=rear=-1;
	}
	public int size()
	{
		int retval=0;
		if(this.front<this.rear)
		{
			retval=this.rear-this.front;
			
		}
		else if(front==rear)
		{
			if(front==-1)
			{
				retval=0;
			}
			else
				retval=this.arr.length;
		}
		else
		{
			retval=this.arr.length+this.rear-this.front;
		}
		return retval;
	}
	
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	private boolean isFull()
	{
		return this.size()==this.arr.length-1;
	}
	public T front() //throws StackEmptyException
	{
		if(this.front==-1)
		{
//			throw new StackEmptyException();
			System.out.println("Stack empty");
			return null;
		}
		return arr[front];
	}
	public void enqueqe(T data)// throws StackFullException
	{
		if(this.front==this.arr.length-1)
		{
			//throw new StackFullException();
			System.out.println("Stack is full");
		}
		this.rear=(rear+1)%arr.length;
		this.arr[this.rear]=data;
	}
	public T dequeue()
	{
		T t1;
		if(front==-1)
		{
			System.out.println("Queue empty");
			return null;
		}
		else if(front==rear)
		{
			t1=arr[front];
			front=rear=-1;
		}
		else
		{
			t1=arr[front];
			this.front=(front+1)%arr.length;
		}
		return t1;
	}
	public String toString()
	{
		String retval="";
		if(front<rear)
		{
			for(int i=this.front+1;i<=rear;i++)
			{
				retval+=arr[i]+"->";
			}
		}
		else if(front==rear)
		{
			if(this.front==-1)
				retval+="";
			else
				{for(int i=this.front+1;i<=arr.length;i++)
				{
					retval+=arr[i]+"->";
				}
				for(int i=0;i<=rear;i++)
				{
					retval+=arr[i]+"->";
				}}
		}
		else
		{
			for(int i=this.front+1;i<=arr.length;i++)
			{
				retval+=arr[i]+"->";
			}
			for(int i=0;i<=rear;i++)
			{
				retval+=arr[i]+"->";
			}
		}
			
		for(int i=this.front;i>=0;i--)
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
