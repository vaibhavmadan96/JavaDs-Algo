package llist;

public class minstack<T extends Comparable<T>> {
	stack<T> s;
	stack<T> min;
	
	public minstack()
	{
		s=new stack<>();
		min=new stack<>();
	}
	private int size()
	{
		return this.s.size();
	}
	public boolean isEmpty()
	{
		return this.s.isEmpty();
	}

	public void push(T data)
	{
		s.push(data);
		if(min.isEmpty())
			min.push(data);
		if(data.compareTo(min.top())<0)
		{
			min.push(data);
		}
	}
	public T top()
	{
		if(s.isEmpty())
		{
			System.out.println("Stack Empty");
			return null;
		}
		return s.top();
	}
	public T pop()
	{
		if(s.isEmpty())
		{
			System.out.println("Stack Empty");
			return null;
		}
		if(s.top().compareTo(min.top())==0)
		{
			min.pop();
		}
		return s.pop();
	}
	public T min1()
	{
		if(min.isEmpty())
		{
			System.out.println("Stack Empty");
			return null;
		}
		return min.top();
	}
	public String toString()
	{
		return s.toString();
	}
	public void display()
	{
		System.out.println(s);
	}
}
