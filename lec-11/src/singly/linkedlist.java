package singly;

public class linkedlist<T extends Comparable<T>> {
	private class Node
	{
		T data;
		Node next;

		Node(T data,Node next)
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
	public linkedlist(Node head,Node tail)
	{
		this.head=head;
		this.tail=tail;
		//this.size=getSize2();
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
	public int getSize2()
	{
		Node temp=this.head;
		int size=0;
		while(temp!=null)
		{

			temp=temp.next;
			size++;
		}
		return size;
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
	public int findElementRecursive(T data)
	{
		return this.findrecursiveHelper(head,data,0);
	}
	private int findrecursiveHelper(Node temp,T data,int index)
	{
		if(temp==null)
		{
			return -1;
		}
		else if(temp.data.equals(data))
		{
			return index;
		}
		else
		{
			return findrecursiveHelper(temp.next,data,index+1);
		}
	}
	public T getMidPointElement()
	{
		if(this.isEmpty())
			return null;
		Node slow=this.head,fast=this.head;
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	public Node getMidPointNode()
	{
		if(this.isEmpty())
			return null;
		Node slow=this.head,fast=this.head;
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public void bubblesort()
	{
		if(this.isEmpty())
		{
			return;
		}
		for(int i=0;i<this.size;i++)
		{
			Node first=this.head,second=first.next;
			for(int j=0;j<size-i-1;j++)
			{
				if(first.data.compareTo(second.data)>0)
				{
					T temp=first.data;
					first.data=second.data;
					second.data=temp;
				}
				first=first.next;
				second=second.next;
			}

		}
	}
	public void insertion_sort()
	{
		if(this.isEmpty())
		{
			return;
		}
		Node i=head.next;
		Node previ=head;
		while(i!=null)
		{
			Node max=i;
			Node j=head;
			Node prevj=null;
			while(j!=i)
			{
				if(j.data.compareTo(i.data)>0)
				{
					max=j;
					break;
				}
				prevj=j;
				j=j.next;
			}
			if(max!=i)
			{
				previ.next=i.next;
				if(prevj!=null)
					prevj.next=i;
				else
				{
					head=i;
				}
				i.next=j;
				i=previ;
			}
			previ=i;
			i=i.next;
		}

	}
	//	public void selection_sort()
	//	{
	//		if(this.isEmpty())
	//		{
	//			return;
	//		}
	//		Node i=head;
	//		Node previ=null;
	//		while(i!=null)
	//		{
	//			Node min=i;
	//			Node prevj=i;
	//			Node prevmin=null;
	//			Node j=i.next;
	//			while(j!=null)
	//			{
	//				if(min.data.compareTo(j.data)>0)
	//				{
	//					prevmin=prevj;
	//					min=j;
	//				}
	//				prevj=j;
	//				j=j.next;
	//			}
	//			if(min!=i)
	//			{
	//				//swap(min,i);
	//				if(previ!=null)
	//					previ.next=min;
	//				else
	//					head=min;
	//				Node temp=min.next;
	//				min.next=i.next;
	//				prevmin.next=i;
	//				i.next=temp;
	//				i=min;
	//			}
	//			previ=i;
	//			i=i.next;
	//		}
	//	}
	public void selection_sort1()
	{
		if(this.isEmpty())
		{
			return;
		}
		Node i=head;
		while(i!=null)
		{
			Node min=i;
			Node j=i.next;
			while(j!=null)
			{
				if(min.data.compareTo(j.data)>0)
				{
					min=j;
				}
				j=j.next;
			}
			if(min!=i)
			{
				//swap(min,i);
				T t=min.data;
				min.data=i.data;
				i.data=t;
			}
			i=i.next;
		}
	}
	public T getElement_end(int i)
	{
		return this.getNode(i).data;
	}
	private Node getNode_end(int i)
	{
		Node temp=head;
		Node temp1=getNode(i-1);
		while(temp1.next.data!=null)
		{
			temp=temp.next;
			temp1=temp1.next;
		}
		return temp;
	}
	public void reverse()
	{
		Node temp=head;
		Node prev=null;
		while(temp!=null)
		{
			Node next=temp.next;
			temp.next=prev;
			prev=temp;
			temp=next;
		}
		Node temp1=tail;
		tail=head;
		head=temp1;
	}
	public void Merge2ll(linkedlist<T> a,linkedlist<T> b)
	{
		//linkedlist<T> ob=new linkedlist<T>();
		Node first=a.head;
		Node first1=b.head;
		a.bubblesort();
		b.bubblesort();
		while(first!=null && first1!=null)
		{
			if(first.data.compareTo(first1.data)<=0)
			{
				addLast(first.data);

				first=first.next;
			}
			else
			{
				addLast(first1.data);

				first1=first1.next;
			}
		}
		while(first!=null)
		{
			addLast(first.data);

			first=first.next;
		}
		while(first1!=null)
		{
			addLast(first1.data);

			first1=first1.next;
		}
		//return ob;
	}
	public void elimin_dup()
	{
		this.bubblesort();
		Node temp=head;
		Node first=temp.next;
		while(first!=null)
		{

			if(first.data.compareTo(temp.data)==0)
			{
				temp.next=first.next;
				first=first.next;
			}
			temp=first;
			first=first.next;
		}
	}
	public Node getHead()
	{
		return head;
	}
	public void reverse_recur(Node temp)
	{
		if(temp.next==null)
		{
			tail=head;
			head=temp;
			return;
		}
		reverse_recur(temp.next);
		Node nxt=temp.next;
		nxt.next=temp;
		temp.next=null;
	}
	public void print_rev(Node temp)
	{
		if(temp.next==null)
		{
			System.out.print(temp.data);
		}
		else
		{
			print_rev(temp.next);
			System.out.print(temp.data+" ");
		}
	}
	public void kappend(int k)
	{
		if(k>0)
		{
			Node t1=getNode(size-k-1);
			Node t=t1.next;
			t1.next=null;
			tail.next=head;
			head=t;
		}
		//System.out.println(this.getElement_end(k));
	}
	public void kreverse(int i)
	{
		int j=i;
		while(j!=0)
		{

			j--;
		}
	}
	private void rev(Node prev1)
	{
		Node prev=prev1;
		Node temp=prev.next;
		Node nxt;
		while(temp!=null)
		{
			nxt=temp.next;
			temp.next=prev;
			prev=temp;
			temp=nxt;
		}
		temp=prev1.next;
		prev1.next=tail;
		tail=temp;
		tail.next=null;

	}
	public boolean palin()
	{
		Node mid=this.getNode((int)Math.ceil(size/2.0)-1);
		if(this.size%2==0)
		{
			//rev 2nd half
			rev(mid);
			Node temp=head,temp1=mid.next;
			while(temp1!=null)
			{
				if(temp.data.compareTo(temp1.data)!=0)
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
				//				T t=temp.data;
				//				T t1=temp1.data;
				if(temp.data.compareTo(temp1.data)!=0)
					return false;
				temp1=temp1.next;
				temp=temp.next;
			}
			return true;
		}
	}
	public linkedlist<T> merge(linkedlist<T> b)
	{
		linkedlist<T> retval=new linkedlist<>();
		Node first=this.head;
		Node first1=b.head;

		while(first!=null && first1!=null)
		{
			if(first.data.compareTo(first1.data)<=0)
			{
				retval.addLast(first.data);

				first=first.next;
			}
			else
			{
				retval.addLast(first1.data);

				first1=first1.next;
			}
		}
		while(first!=null)
		{
			retval.addLast(first.data);

			first=first.next;
		}
		while(first1!=null)
		{
			retval.addLast(first1.data);

			first1=first1.next;
		}
		return retval;
	}
	public linkedlist<T> merge_sort()
	{
		linkedlist<T> retval=new linkedlist<>();


		if(head.next==null )
		{
			retval.addLast(head.data);
			return retval;
		}
		else if(head==null)
			return null;
		else
		{
			Node mid=this.getMidPointNode();
			Node temp=mid.next;
			linkedlist<T> fh=new linkedlist<>(head,mid);
			mid.next=null;
			linkedlist<T> sh=new linkedlist<>(temp,tail);
			fh=fh.merge_sort();
			sh=sh.merge_sort();
			retval=fh.merge(sh);
			return retval;
		}
	}
	public void swap_node(Node x,Node y)
	{
		Node s1=head;
		Node prevx=null;
		while(s1!=x)//finding x and keeping track of prevx
		{
			prevx=s1;
			s1=s1.next;
		}
		Node s2=head;
		Node prevy=null;
		while(s2!=null)//same for y
		{
			prevy=s2;
			s2=s2.next;
		}
		if(x==head)//check x is head
		{
			head=y;
		}
		else
		{
			prevx.next=y;
		}
		if(y==head)//check y is head
		{
			head=x;
		}
		else
		{
			prevy.next=x;
		}
		Node temp=x.next;//swapping next ptrs of x and y
		x.next=y.next;
		y.next=temp;
	}
	public void recur_bubblesort()
	{
		recur_bubblesort_Helper(this.tail);
	}
	private void recur_bubblesort_Helper(Node i)
	{
		if(i!=head)
		{
			Node j=head;
			while(j!=i)
			{
				if(j.data.compareTo(j.next.data)>0)
				{
					T temp=j.data;
					j.data=j.next.data;
					j.next.data=temp;
				}
				j=j.next;
			}
			Node s=head;
			Node prev=null;
			while(s!=i)
			{
				prev=s;
				s=s.next;
			}
			recur_bubblesort_Helper(prev);
		}
	}
	public void recur_insertion_sort()
	{
		recur_insertion_sortHelper(head.next,head);
	}
	private void recur_insertion_sortHelper(Node i,Node previ)
	{
		if(i!=null)
		{
			Node max=i;
			Node prevj=null;
			Node j=head;
			while(j!=i)
			{
				if(j.data.compareTo(max.data)>0)
				{
					max=j;
					break;
				}
				prevj=j;
				j=j.next;
			}
			if(max!=i)
			{
				if(max==head)
				{
					head=i;
				}
				else
					prevj.next=i;
				Node temp=i.next;
				i.next=max;
				previ.next=temp;
				i=previ;
			}
			previ=i;
			i=i.next;
			recur_insertion_sortHelper(i,previ);
		}
	}
	public void recur_selection_sort()
	{
		selection_sortHelper(this.head);
	}
	private void selection_sortHelper(Node i)
	{
		if(i.next!=null)
		{
			Node min=i;
			Node j=i.next;
			while(j!=null)
			{
				if(j.data.compareTo(min.data)<0)
				{
					min=j;
				}
				j=j.next;
			}
			if(min!=i)
			{
				T temp=min.data;
				min.data=i.data;
				i.data=temp;
			}
			i=i.next;
		}
	}
	public linkedlist<T> merge_sort1()
	{
		linkedlist<T> retval=new linkedlist<>();
		if(head==null)
		{
			return null;
		}
		else if(head.next==null)
		{
			retval.addLast(head.data);
		}
		else
		{
			Node mid=this.getMidPointNode();
			linkedlist<T> fh=new linkedlist(head,mid);
			linkedlist<T> sh=new linkedlist(mid.next,tail);
			mid.next=null;
			fh=fh.merge_sort1();
			sh=sh.merge_sort1();
			retval=fh.merge1(sh);
		}
		return retval;
	}
	private linkedlist<T> merge1(linkedlist<T> sh)
	{
		linkedlist<T> retval=new linkedlist<>();
		Node start=this.head;
		Node start1=sh.head;
		while(start1!=null && start!=null)
		{
			if(start.data.compareTo(start1.data)<=0)
			{
				retval.addLast(start.data);
				start=start.next;
			}
			else
			{
				retval.addLast(start1.data);
				start1=start1.next;
			}
			
		}
		while(start!=null)
		{
			retval.addLast(start.data);
			start=start.next;
		}
		while(start1!=null)
		{
			retval.addLast(start1.data);
			start1=start1.next;
		}
		return retval;
	}

}