package queues;
import llist.*;

//import fixed.Stack;

//import singly.linkedlist.Node;

public class stack<T> {
	//private node t
	Queue<T> q1;
	Queue<T> q2;


	public stack()
	{
		q1=new Queue<>();
		q2=new Queue<>();
	}//size,pop,push,tostring
	private int size()
	{
		return this.q1.size();
	}
	public boolean isEmpty()
	{
		return this.q1.isEmpty();
	}

	public void push(T data)
	{
		q1.enqueqe(data);
	}
	public T top()
	{
		if(q1.isEmpty())
		{
			System.out.println("Stack Empty");
			return null;
		}
		return q1.front();
	}
	public T pop()
	{
		if(q1.isEmpty())
		{
			System.out.println("Stack Empty");
			return null;
		}
		int s=0;
		while(s<q1.size())
		{
			q2.enqueqe(q1.dequeue());	
		}
		T t1=q2.dequeue();
		Queue<T> temp=q1;
		q1=q2;
		q2=temp;
		return t1;
	}
	public String toString()
	{
		String retval="";
		if(q1.isEmpty())
		{
			System.out.println("Stack Empty");
			return retval;
		}
		while(!q1.isEmpty())
		{
			T t=q1.dequeue();
			q2.enqueqe(t);
			retval+=t+"->";
		}
		Queue<T> temp=q1;
		q1=q2;
		q2=temp;
		return retval;
	}
	public void display()
	{
		System.out.println(this);
	}

}
