package assign;




public class linkedlist {
	private class Node
	{
		int data;
		Node next;
		
		Node(int data,Node next)
		{
			this.data=data;
			this.next=next;
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
			retval+=temp.data+"=>";
			temp=temp.next;
		}
		retval+="}";
		return retval;
	}
	public boolean isEmpty()
	{
		return this.head==null;
	}
	public void addLast(int data)
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
//	public void even_odd()
//	{
//		Node temp=head;
//		Node i = null,j;
//		while(temp!=null)
//		{
//			if((temp.data)%2==0 && i==null)
//			{
//				i=temp;
//			}
//			else if(temp.data%2!=0)
//			{
//				j=temp;
//				if(i!=null)
//				{
//				Node temp2=i;
//				Node prev;
//				int t1=j.data;
//				while(temp2!=j)
//				{
//					prev=temp2;
//					temp2=temp2.next;
//					temp2.data=prev.data;
//				}
//				}
//			}
//			temp=temp.next;
//		}
//	}
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
	private void rev(Node prev1)
	{
		Node prev=prev1;
		Node temp=prev.next;
		Node temp1=temp;
		Node nxt;
		while(temp!=null)
		{
			nxt=temp.next;
			temp.next=prev;
			prev=temp;
			temp=nxt;
		}
		
		prev1.next=tail;
		tail=temp1;
		tail.next=null;
		
	}
	public void test()
	{
		Node mid=this.getNode((int)Math.ceil(size/2.0)-1);
		
			rev(mid);
	}
	public boolean palin()
	{
		Node mid=this.getNode((int)Math.ceil(size/2.0));
		if(this.size%2==0)
		{
			//rev 2nd half
			rev(mid);
			Node temp=head,temp1=mid.next;
			while(temp1!=null)
			{
				int t=temp.data;
				int t1=temp1.data;
				if(temp.data!=temp1.data)
					return false;
				temp1=temp1.next;
				temp=temp.next;
			}
			return true;
		}
		else
		{
			rev(mid);
			Node temp=head,temp1=mid.next;
			while(temp1!=null)
			{
				int t=temp.data;
				int t1=temp1.data;
				if(temp.data!=temp1.data)
					return false;
				temp1=temp1.next;
				temp=temp.next;
			}
			return true;
		}
	}
	public void even_odd()
	{
		Node temp=head;
		Node odd=null,even=null,odd_head=null,even_head=null;
		while(temp!=null)
		{
			if((temp.data)%2==0)
			{
				if(even==null)
				{
					even_head=temp;
					even=temp;
				}
				else
				{
					even.next=temp;
					even=temp;
				}
			}
			else
			{
				if(odd==null)
				{
					odd_head=temp;
					odd=temp;
				}
				else
				{
					odd.next=temp;
					odd=temp;
				}
			}
			temp=temp.next;
		}
		if(odd==null)
		{
			head=even_head;
			even.next=null;
			tail=even;
		}
		if(even==null)
		{
			head=odd_head;
			odd.next=null;
			tail=odd;
		}
		if(odd!=null && even!=null)
		{
			head=odd_head;
			odd.next=even_head;
			tail=even;
			even.next=null;
		}
	}
	
}
