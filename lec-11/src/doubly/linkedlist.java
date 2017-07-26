package doubly;


public class linkedlist<T extends Comparable<T>> {
	private class Node
	{
		T data;
		Node next;
		Node prev;
		
		Node(T data,Node next,Node prev)
		{
			this.data=data;
			this.next=next;
			this.prev=prev;
		}
		
	}
	private Node head;
	private Node tail;
	private int size;
	public linkedlist()
	{
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	public String toString()
	{
		String retval="{";
		Node temp=this.head;
		while(temp!=null)
		{
			retval+=temp.data.toString()+"=>";
			temp=temp.next;
		}
		retval+="}";
		return retval;
	}
	public boolean isEmpty()
	{
		return this.head==null;
	}
	public int getSize()
	{
		return this.size;
	}
	public T getElement(int i)
	{
		Node temp=this.getNode(i);
		return temp!=null?temp.data:null;
	}
	private Node getNode(int i)
	{
		if(i<0 || i>=size)
			{System.out.println("Invalid pos");
			return null;}
		else
		{
			Node temp=this.head;
			int j=0;
			while(temp!=null)
			{
				
				
				if(j==i)
					break;
				j++;
				temp=temp.next;
				
			}
			return temp;
		}
	}
	private Node getNode_recur(int i,Node temp)
	{
		if(i<0 || i>=size)
		{System.out.println("Invalid pos");
		return null;}
		else if(i==0)
		{
			return temp;
		}
		else
		{
			return getNode_recur(i-1,temp.next);
		}
	}
	public void addLast(T data)
	{
		Node temp=new Node(data,null);
		if(this.isEmpty())
		{
			this.head=this.tail=temp;
		}
		else
		{
			this.tail.next=temp;
			tail=temp;
		}
		this.size++;
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
//			temp.next=head;
			this.head=temp;
		}
		this.size++;
	}
	public void insert(T data,int i)
	{
		//i>size or -ve
		if(i<0 || i>size)
		{
			System.out.println("Invalid insertion pos");//thro excep
		}
		else if(i==0)
		{
			this.addFirst(data);
		}
		else if(i==size)
		{
			this.addLast(data);
		}
		else
		{
			Node temp=getNode_recur(i-1,head);
			//Node temp1=getNode(i);
			Node temp2=new Node(data,temp.next);
			temp.next=temp2;
			size++;
		}
	}
	public void removeFirst()
	{
		if(!this.isEmpty()){
		if(this.size==1)
		{
			head=null;
			tail=null;
		}
		else
		{
			Node temp=this.head;
			this.head=this.head.next;
			temp.next=null;
		}
		size--;
	}	
	}
	public void removeLast()
	{
		if(!this.isEmpty()){
		if(this.size==1)
		{
			head=null;
			tail=null;
		}
		else
		{
			Node temp=getNode(size-1);
			
			temp.next=null;
		}
		size--;
	}	
	}
	public void remove(int i)
	{
		if(i<0 || i>=size)
		{
			System.out.println("Invalid insertion pos");//thro excep
		}
		else if(i==0)
		{
			this.removeFirst();
		}
		else if(i==size)
		{
			this.removeLast();
		}
		else
		{
		Node temp=getNode_recur(i-1,head);
		Node temp1=getNode_recur(i,head);
		temp.next=temp1.next;
		temp1.next=null;
		size--;
	}
}
