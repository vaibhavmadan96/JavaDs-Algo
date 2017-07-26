package llist;

//import fixed.Stack;

//import singly.linkedlist.Node;

public class stack<T> {
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
	private Node head;
	private Node tail;
	private int size;

	public stack()
	{
		head=tail=null;
		size=0;
	}//size,pop,push,tostring
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return this.size==0;
	}
	public void addFirst(T data)
	{
		Node temp=new Node(data,head);
		if(this.isEmpty())
		{
			this.head=this.tail=temp;
		}
		else
		{
			//			this.tail.next=temp;
			//			tail=temp;
			//		temp.next=head;
			this.head=temp;
		}
		this.size++;
	}
	public void push(T data)
	{
		this.addFirst(data);
	}
	public T top()
	{
		if(head==null)
		{
			System.out.println("Stack Underflow");
			return null;
		}
		return head.data;
	}
	public T pop()
	{
		if(head==null)
		{
			System.out.println("Stack Underflow");
			return null;
		}
		T t1=head.data;
		if(size==1)
		{
			head=tail=null;
		}
		else
		{
			head=head.next;
		}
		

		size--;
		return t1;
	}
	public String toString()
	{
		String retval="";
		Node temp=head;
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
	public  void reverse()
	{
		stack<T> nstack=new stack<>();
		while(!this.isEmpty())
		{
			nstack.push(this.pop());
		}
		this.reverse_helper(nstack);
		
	}
	private void reverse_helper(stack<T> nstack)
	{
		if(nstack.isEmpty())
			return;
		
		T data=nstack.pop();
		reverse_helper(nstack);
		push(data);
	}
}
