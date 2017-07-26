package stacks;//pop effic
import llist.*;

public class queue<T> {//size,isempty,enq,deq,front,toString,display
	stack<T> s1;
	stack<T> s2;
	public queue()
	{
		s1=new stack<>();
		s2=new stack<>();
	}
	private int size()
	{
		return s1.size();
	}
	public boolean isEmpty()
	{
		return s1.isEmpty();
	}
	public void enqueue(T data)
	{
		if(s1.isEmpty())
		{
			s1.push(data);
		}
		else
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
			s2.push(data);
			while(!s2.isEmpty())
			{
				s1.push(s2.pop());
			}
		}
	}
	public T dequeue()
	{
		if(s1.isEmpty())
		{
			System.out.println("Q empty");
			return null;
		}
		return s1.pop();
	}
	public String toString()
	{
		return s1.toString();
	}
	public void display()
	{
		System.out.println(this);
	}
}
