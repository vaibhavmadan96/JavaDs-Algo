 import java.util.ArrayList;
import java.util.Scanner;



public class Bst<T extends Comparable<T>> {

	private class Node
	{
		T data;
		Node left;
		Node right;
		Node(T data)
		{
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	private class pair
	{
		int height;
		int diameter;
	}
	
	private Node root;
	public Bst(boolean isLevel)
	{
		if(isLevel)
		{
			this.root=this.takeInputLevelwise();
		}
		else
		{
			this.root=this.takeInput();
		}
	}

	private Node takeInput()
	{
		System.out.println("Please enter the rot node");
		this.root=this.takeInputHelper(new Scanner(System.in),Integer.MIN_VALUE,Integer.MAX_VALUE);
		return root;
	}
	private Node takeInputHelper(Scanner scn,Integer lo,Integer up)
	{
		
		Integer data=scn.nextInt();
		if(data==-1)
			return null;
		Node node=null;
		if(data>=lo && data<up)
		{
			node= new Node((T)data);
			System.out.println("Please enter the left child for:"+data);
			node.left=this.takeInputHelper(scn,lo,(Integer)node.data);
			System.out.println("Please enter the right child for:"+data);
			node.right=this.takeInputHelper(scn,(Integer)node.data+1,up);
		}
		
		return node;
	}
	private Node takeInputLevelwise()
	{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter the data");
		Integer data=scn.nextInt();

		Node node=new Node((T)data);

		this.root=data!=-1?node:null;
		Queue<Node> queue=new Queue<>();
		queue.enqueqe(node);
		while(!queue.isEmpty())
		{
			Node temp=queue.dequeue();
			if(temp!=null)
			{
				System.out.println("Enter leftchild for "+temp.data+"-");
				int numChildl=scn.nextInt();
				Node cnodel=(numChildl!=-1 )?new Node((T)(Integer)numChildl):null;
				queue.enqueqe(cnodel);
				temp.left=cnodel;

				System.out.println("Enter rightchild for "+temp.data+"-");
				int numChildr=scn.nextInt();
				Node cnoder=(numChildr!=-1)?new Node((T)(Integer)numChildr):null;
				queue.enqueqe(cnoder);
				temp.right=cnoder;
			}
		}
		return this.root;
	}
	private Node buildTreegenericTreeStyle(T[] arr)
	{
		Queue<Node> queue=new Queue<>();

		this.root=(Integer)arr[0]!=-1?new Node(arr[0]):null;
		int counter=0;
		queue.enqueqe(root);
		while(!queue.isEmpty())
		{
			Node temp=queue.dequeue();
			if(temp!=null)
			{
				Integer leftdata=(Integer)arr[++counter];
				Node cnodel=leftdata!=-1?new Node((T)leftdata):null;
				queue.enqueqe(cnodel);
				temp.left=cnodel;

				Integer rightdata=(Integer)arr[++counter];
				Node cnoder=rightdata!=-1?new Node((T)rightdata):null;
				queue.enqueqe(cnoder);
				temp.right=cnoder;
			}
		}
		return root;
	}


	public int size()
	{
		return this.size_helper(root);
	}
	private int size_helper(Node node)
	{
		if(node==null)
			return 0;
		else
			return size_helper(node.left)+size_helper(node.right)+1;
	}
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	public void display()
	{
		this.displayhelper(root);
	}
	private void displayhelper(Node node)
	{
		if(node==null)
		{
			return;
		}
		else
		{
			System.out.println((node.left!=null?node.left.data:"End") +"<="+node.data+"=>"+(node.right!=null?node.right.data:"End"));
			displayhelper(node.left);
			displayhelper(node.right);
		}
	}
	public void traversePreOrderIter()
	{
		traversePreOrderHelp(root);
	}
	private void traversePreOrderHelp(Node node)
	{
		stack<Node> s =new stack<>();
		if(root==null)
			return ;
		s.push(root);
		while(!s.isEmpty())
		{
			Node temp=s.pop();
			System.out.println(temp.data);
			if(temp.right!=null)
			{
				s.push(temp.right);
			}
			if(temp.left!=null)
			{
				s.push(temp.left);
			}
		}
	}
	public void traversePreOrderRecur()
	{
		traversePreOrderRecurHelp(root);
	}
	private void traversePreOrderRecurHelp(Node node)
	{
		if(node!=null)
		{
			System.out.println(node.data);
			traversePreOrderRecurHelp(node.left);
			traversePreOrderRecurHelp(node.right);
		}
	}
	public void traverseInOrder()
	{
		traverseInOrderHelp(root);
	}
	private void traverseInOrderHelp(Node node)
	{
		if(node!=null)
		{

			traverseInOrderHelp(node.left);
			System.out.println(node.data);
			traverseInOrderHelp(node.right);
		}
	}
	public void traverseLevelOrder()
	{
		traverseLevelOrderHelp();

	}
	private void traverseLevelOrderHelp()
	{
		Queue<Node> q=new Queue<>();
		if(root==null)
			return;
		q.enqueqe(root);
		while(!q.isEmpty())
		{
			Node temp=q.dequeue();
			System.out.println(temp.data);
			if(temp.left!=null)
			{
				q.enqueqe(temp.left);
			}
			if(temp.right!=null)
			{
				q.enqueqe(temp.right);
			}
		}
	}
	public void PostOrder()
	{
		PostOrderHelper(root);
	}
	private void PostOrderHelper(Node node)
	{
		if(node!=null)
		{

			PostOrderHelper(node.left);
			PostOrderHelper(node.right);
			System.out.println(node.data);
		}
	}
	public int height()
	{
		return this.height_helper(root);
	}
	private int height_helper(Node node)
	{
		if(node==null)
			return 0;
		int retval=0,retval1=0,retval2=0;

		retval1+=height_helper(node.left);
		retval2+=height_helper(node.right);

		retval=Math.max(retval1,retval2)+1;
		return retval;
	}
	public int diameter()
	{
		return diameterHelp(root);
	}
	private int diameterHelp(Node node)
	{
		if(node==null)
			return 0;
		int v1=this.height_helper(node.left)+this.height_helper(node.right)+1;
		int v2=this.diameterHelp(node.left);
		int v3=this.diameterHelp(node.right);

		return Math.max(v1,Math.max(v2,v3));
	}
	public int diameter2()
	{

		return this.diameter2Help(root).diameter;
	}
	private pair diameter2Help(Node node)
	{
		pair retval=new pair();
		if(node==null)
		{
			retval.height=0;
			retval.diameter=0;
			return retval;
		}

		pair leftpair=this.diameter2Help(node.left);
		pair rightpair=this.diameter2Help(node.right);
		retval.height=Math.max(leftpair.height, rightpair.height)+1;
		int option=leftpair.height+rightpair.height+1;
		retval.diameter=Math.max(option, Math.max(leftpair.diameter, rightpair.diameter));
		return retval;
	}
	public T maxElement()
	{

		return this.maxElementHelper(root).data;
	}
	private Node maxElementHelper(Node node)
	{
		if(node==null)
			return null;
		Node maxnode=node;
		Node temp1,temp2;

		temp1=maxElementHelper(node.left);
		if(temp1!=null && temp1.data.compareTo(maxnode.data)>0)
		{
			maxnode=temp1;
		}
		temp2=maxElementHelper(node.right);
		if(temp2!=null && temp2.data.compareTo(maxnode.data)>0)
		{
			maxnode=temp2;
		}
		return maxnode;
	}
	public T minElement()
	{
		return this.minElementHelper(root).data;
	}
	private Node minElementHelper(Node node)
	{
		if(node==null)
			return null;
		Node minnode=node;
		Node temp1,temp2;
		temp1=minElementHelper(node.left);
		if(temp1!=null && temp1.data.compareTo(minnode.data)<0)
		{
			minnode=temp1;
		}
		temp2=minElementHelper(node.right);
		if(temp2!=null && temp2.data.compareTo(minnode.data)<0)
		{
			minnode=temp2;
		}
		return minnode;
	}
	


		//todo
	public boolean find(T data)
	{
		if(findHelp(root,data)==null)
			return false;
		else
			return true;
	}
	private Node findHelp(Node node,T data)
	{
		if(node==null || data.equals(node.data))
		{
			return node;
		}
		if(data.compareTo(node.data)<0)
		{
			Node l=this.findHelp(node.left, data);
			return l;
		}
		else
		{
			Node r=this.findHelp(node.right, data);
			return r;
		}
			
	}
	public T LCA(T d1,T d2)
	{
		return LCAHelper(d1,d2,root).data;
	}
	private Node LCAHelper(T d1,T d2,Node node)
	{
		if(node==null)
			return null;
		if(node.data.compareTo(d1)<0 && node.data.compareTo(d2)<0)
		{
			return LCAHelper(d1,d2,node.right);
		}
		if(node.data.compareTo(d1)>0 && node.data.compareTo(d2)>0)
		{
			return LCAHelper(d1,d2,node.left);
		}
		return node;
	}
	public void createDupl()
	{
		this.createDupHelp(root);
	}
	private void createDupHelp(Node node)
	{
		if(node!=null)
		{
			createDupHelp(node.left);
			Node temp=new Node(node.data);
			temp.left=node.left;
			node.left=temp;
			
			this.createDupHelp(node.right);
		}
	}
	public boolean pairsum(T data)
	{
		ArrayList<T> a=new ArrayList<T>();
		this.pairsumHelper(root, a);
		int i=0,j=a.size()-1;
		Integer sum=0;
		while(i<j)
		{
			sum=(Integer)a.get(i)+(Integer)a.get(j);
			if(sum.equals(data))
				return true;
			else if(sum.compareTo((Integer)data)<0)
			{
				i++;
			}
			else
			{
				j--;
			}
		}
		return false;
	}
	private void pairsumHelper(Node node,ArrayList<T> a)
	{
		if(node!=null)
		{

			pairsumHelper(node.left,a);
			a.add(node.data);
			pairsumHelper(node.right,a);
		}
	}
	public void IterInorder()
	{
		stack<Node> s=new stack<>();
		boolean done=false;
		Node curr=root;
		while(!done)
		{
			if(curr!=null)
			{
				s.push(curr);
				curr=curr.left;
			}
			else
			{
				if(!s.isEmpty())
				{
					Node temp=s.pop();
					System.out.print(temp.data+" ");
					curr=temp.right;
				}
				else
				{
					done=true;
				}
			}
		}
	}
	public boolean pairsum2(T target)//logn extra space only
	{
		stack<Node> s1=new stack<>();
		boolean done1=false;
		Node curr1=root;
		stack<Node> s2=new stack<>();
		boolean done2=false;
		Node curr2=root;
		T val1=null,val2=null;
		while(true)
		{
			while(!done1)
			{
				if(curr1!=null)
				{
					s1.push(curr1);
					curr1=curr1.left;
				}
				else
				{
					if(!s1.isEmpty())
					{
						Node temp=s1.pop();
						val1=temp.data;
						curr1=temp.right;
						done1=true;
					}
					else
					{
						done1=true;
					}
				}
			}
			while(!done2)
			{
				if(curr2!=null)
				{
					s2.push(curr2);
					curr2=curr2.right;
				}
				else
				{
					if(!s2.isEmpty())
					{
						Node temp=s2.pop();
						val2=temp.data;
						curr2=temp.left;
						done2=true;
					}
					else
					{
						done2=true;
					}
				}
			}
			Integer sum=(Integer)val1+(Integer)val2;
			
			if(val1.compareTo(val2)>=0)
				return false;
			if(sum.compareTo((Integer)target)<0)
			{
				done1=false;
			}
			else if(sum.equals(target))
				return true;
			else
			{
				done2=false;
			}
			
		}
	}
	public void replaceWithSum()
	{
		stack<Node> s=new stack<>();
		boolean done=false;
		Node curr=root;
		Integer sum=0;
		while(!done)
		{
			if(curr!=null)
			{
				s.push(curr);
				curr=curr.right;
			}
			else
			{
				if(!s.isEmpty())
				{
					Node temp=s.pop();
					T e=temp.data;
					temp.data=(T)sum;
					sum+=(Integer)e;
					curr=temp.left;
				}
				else 
				{
					done=true;
				}
			}
		}
	}
	
	//Print all nodes at distance k from a given node
	public void NodekDist(T data,int k)
	{
		int depth=this.NodekDistHelper(root, data, k);
		System.out.println("depth:"+depth);
	}
	public int NodekDistHelper(Node node,T data,int k)
	{
		if(node==null && k<0)
			return -1;
		if(node.data.equals(data))
		{
			this.NodekDistsameSTree(k, node);
			return 0;
		}
		int l=this.NodekDistHelper(node.left, data, k);
		if(l!=-1)
		{
			if(l+1==k)//check every ancestor
			{
				System.out.print(node.data+" ");
			}
			else if((l+1)<k)
			{
				this.NodekDistsameSTree(k-l-2, node.right);
			}
			return l+1;
		}
		int r=this.NodekDistHelper(node.right, data, k);
		if(r!=-1)
		{
			if(r+1==k)
			{
				System.out.print(node.data+" ");
			}
			else if((r+1)<k)
			{
				this.NodekDistsameSTree(k-r-2, node.left);
			}
			return r+1;
		}
		return -1;
	}
	private void NodekDistsameSTree(int k,Node tgt)
	{
		if(tgt!=null && k>=0)
		{
			if(k==0)
				System.out.print(tgt.data+" ");
			this.NodekDistsameSTree(k-1, tgt.left);
			this.NodekDistsameSTree(k-1, tgt.right);
		}
	}
	public void printPath(int s)
	{
		ArrayList<T> a=new ArrayList<>();
		this.printPathHelper(s, root, a);
	}
	private void printPathHelper(int s,Node node,ArrayList<T> a)
	{
		if(node!=null)
		{
			ArrayList<T> al=new ArrayList<>();
			ArrayList<T> ar=new ArrayList<>();
			
			s-=(Integer)node.data;
			a.add(node.data);
			for(int i=0;i<a.size();i++)
			{
				al.add(a.get(i));
				ar.add(a.get(i));
			}
			//add to arrayli
			if(s==0 && node.left==null && node.right==null)
			{
				for(int i=0;i<a.size();i++)
				{
					System.out.println(a.get(i)+"-> ");
				}
				//print
			}
			this.printPathHelper(s, node.left,al);
			this.printPathHelper(s, node.right,ar);
		}
	}

	public void sortedLlist() {
		// TODO Auto-generated method stub
		linkedlist<Node> ll=new linkedlist<>();
		sortedLlistHelp(root,ll);
		System.out.println(ll);
	}
	private void sortedLlistHelp(Node node,linkedlist<Node> ll)
	{
		if(node!=null)
		{

			traverseInOrderHelp(node.left);
			ll.addLast(node);
			traverseInOrderHelp(node.right);
		}
	}
}
