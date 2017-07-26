


public class Queue<T> {
	//private node t
	private class Node {
		T data;
		Node next;
		
		Node (T data,Node next)
		{
			this.data=data;
			this.next=next;
		}


	}
	private Node rear,front;
	
	

	public Queue()
	{
		this.front=rear=null;
	}
	public int size()
	{
		int s=0;
		Node temp=front;
		while(temp!=null)
		{
			s++;
			temp=temp.next;
		}
		return s;
	}
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	
	public T front() //throws StackEmptyException
	{
		if(this.front==null)
		{
//			throw new StackEmptyException();
			System.out.println("queue empty");
			return null;
		}
		return front.data;
	}
	private void addLast(T data)
	{
		Node temp=new Node(data,null);
		if(this.isEmpty())
		{
			this.front=this.rear=temp;
		}
		else
		{
			this.rear.next=temp;
			rear=temp;
		}
		
	}
	public void enqueqe(T data)// throws StackFullException
	{
		addLast(data);
		
	}
	public T dequeue()
	{
		T t1;
		if(front==null)
		{
			System.out.println("Queue empty");
			return null;
		}
		else if(front==rear)
		{
			t1=front.data;
			front=rear=null;
		}
		else
		{
			t1=front.data;
			front=front.next;
		}
		return t1;
	}
	public String toString()
	{
		String retval="";
		Node temp=front;
		while(temp!=null)
		{
			retval+=temp.data+"->";
			temp=temp.next;
		}
		
		return retval;
	}
	public void display()
	{
		System.out.println(this);
	}
	
}
