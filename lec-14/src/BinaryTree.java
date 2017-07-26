import java.util.ArrayList;
import java.util.Scanner;

//import Bst.Node;

//import GenericTree.TreeNode;


public class BinaryTree<T extends Comparable<T>> {

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
	private class tri
	{
		boolean isbst;
		Integer min;
		Integer max;
	}
	private Node root;
	public BinaryTree(boolean isLevel)
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
	public BinaryTree(String[] args)
	{
		if(args==null || args.length==0)
			return;
		Integer[] first=new Integer[args.length/2];
		Integer[] second=new Integer[args.length/2];
		for(int i=1;i<=args.length/2;i++)
		{

			first[i-1]=Integer.parseInt(args[i]);
			second[i-1]=Integer.parseInt(args[i+args.length/2]);

		}
		switch(args[0].charAt(0))
		{
		case '0'://pre&in

			this.root=this.bulidTreeFromPreIn((T[])first, 0, first.length-1,(T[])second, 0, second.length-1);
			break;
		case '1'://post&in
			this.root=this.bulidTreeFromPostIn((T[])first, 0, first.length-1, (T[])second, 0, second.length-1);
			break;
		case '2'://pre&post
			this.root=this.bulidTreeFromPrePost((T[])first, 0, first.length-1, (T[])second, 0, second.length-1);
			break;
		case '3'://generic tree style
			Integer[] arr=new Integer[args.length-1];
			for(int i=1;i<args.length;i++)
			{
				arr[i-1]=Integer.parseInt(args[i]);
			}
			this.root=this.buildTreegenericTreeStyle((T[])arr);
			break;
		default://ideally throw an error

			break;

		}
	}
	private Node takeInput()
	{
		System.out.println("Please enter the rot node");
		this.root=this.takeInputHelper(new Scanner(System.in));
		return root;
	}
	private Node takeInputHelper(Scanner scn)
	{
		Integer data=scn.nextInt();
		if(data==-1)
			return null;

		Node node= new Node((T)data);
		System.out.println("Please enter the left child for:"+data);
		node.left=this.takeInputHelper(scn);
		System.out.println("Please enter the right child for:"+data);
		node.right=this.takeInputHelper(scn);
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
				Node cnodel=numChildl!=-1?new Node((T)(Integer)numChildl):null;
				queue.enqueqe(cnodel);
				temp.left=cnodel;

				System.out.println("Enter rightchild for "+temp.data+"-");
				int numChildr=scn.nextInt();
				Node cnoder=numChildr!=-1?new Node((T)(Integer)numChildr):null;
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
		traverseLevelOrderHelp5();

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
	private void traverseLevelOrderHelp2()
	{
		Queue<Node> q=new Queue<>();
		if(root==null)
			return;
		q.enqueqe(root);
		int i=0;
		int j=0;
		while(!q.isEmpty())
		{
			i++;
			if(i==2+j)
				j+=q.size();
			Node temp=q.dequeue();

			System.out.print(temp.data+" ");
			if(i==1+j)
			{
				System.out.println("");
			}

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
	private void traverseLevelOrderHelp4()
	{
		Queue<Node> q1=new Queue<>();
		Queue<Node> q2=new Queue<>();
		if(root==null)
		{
			return;
		}
		q1.enqueqe(root);
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			while(!q1.isEmpty())
			{
				Node temp=q1.dequeue();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
				{
					q2.enqueqe(temp.left);
				}
				if(temp.right!=null)
				{
					q2.enqueqe(temp.right);
				}
			}
			System.out.println("");
			while(!q2.isEmpty())
			{
				Node temp=q2.dequeue();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
				{
					q1.enqueqe(temp.left);
				}
				if(temp.right!=null)
				{
					q1.enqueqe(temp.right);
				}
			}
			System.out.println("");
		}
	}
	private void traverseLevelOrderHelp5()
	{
		Queue<Node> q=new Queue<>();
		if(root==null)
		{
			return;
		}
		q.enqueqe(root);
		int levelcnt=0,currcnt=1;
		while(!q.isEmpty())
		{
			Node temp=q.dequeue();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
			{
				q.enqueqe(temp.left);
				levelcnt++;
			}
			if(temp.right!=null)
			{
				q.enqueqe(temp.right);
				levelcnt++;
			}
			currcnt--;
			if(currcnt==0)
			{
				System.out.println("");
				currcnt=levelcnt;
				levelcnt=0;
			}
		}
	}
	public void tree2ll()
	{
		linkedlist<T>[] lls=this.tree2llHelper();
		for(int i=0;i<lls.length;i++)
		{
			System.out.println(lls[i]);
		}
	}
	private linkedlist<T>[] tree2llHelper()
	{
		int ht=this.height();
		linkedlist<T>[] lls=new linkedlist[ht];
		Queue<Node> q=new Queue<>();
		if(root==null)
		{
			return null;
		}
		q.enqueqe(root);
		int levelcnt=0,currcnt=1;
		int i=-1;
		i++;
		lls[i]=new linkedlist<>();
		while(!q.isEmpty())
		{
			Node temp=q.dequeue();
			//System.out.print(temp.data+" ");
			lls[i].addLast(temp.data);
			if(temp.left!=null)
			{
				q.enqueqe(temp.left);
				levelcnt++;
			}
			if(temp.right!=null)
			{
				q.enqueqe(temp.right);
				levelcnt++;
			}
			currcnt--;
			if(currcnt==0 && !q.isEmpty())
			{
				i++;
				lls[i]=new linkedlist<>();
				currcnt=levelcnt;
				levelcnt=0;
			}
		}
		return lls;
	}
	public void displaySibling()
	{
		Queue<Node> q=new Queue<>();
		if(root==null)
			return;
		q.enqueqe(root);
		int i=0;
		int j=0,k=0;
		while(!q.isEmpty())
		{
			i++;
			if(i==2+j)//check size of q before next level starts filling
			{j+=q.size();
			k=q.size();
			}
			Node temp=q.dequeue();

			if(i==1+j && (k==1 ||i==1))
			{
				System.out.print(temp.data+" ");
				System.out.println("");
			}

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
	private void traverseLevelOrderHelp3()
	{
		stack<Node> s1=new stack<>();
		stack<Node> s2=new stack<>();
		if(root==null)
			return;
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			while(!s1.isEmpty())
			{
				Node temp=s1.pop();
				System.out.print(temp.data+" ");
				if(temp.right!=null)
				{
					s2.push(temp.right);
				}
				if(temp.left!=null)
				{
					s2.push(temp.left);
				}
			}
			System.out.println("");
			while(!s2.isEmpty())
			{
				Node temp=s2.pop();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
				{
					s1.push(temp.left);
				}
				if(temp.right!=null)
				{
					s1.push(temp.right);
				}

			}
			System.out.println("");
		}
	}
	public void DisplayTree()
	{
		Queue<Node> q=new Queue<>();
		if(root==null)
			return;
		q.enqueqe(root);
		int i=0;
		int j=0;
		while(!q.isEmpty())
		{
			i++;
			if(i==2+j)
				j+=q.size();
			Node temp=q.dequeue();
			int h=this.height_helper(temp);
			for(int l=0;l<h-1;l++)
			{
				System.out.print("\t");
			}
			System.out.print(temp.data+"\t");
			for(int l=0;l<h-1;l++)
			{
				System.out.print("\t");
			}
			if(i==1+j)
			{
				System.out.println("");
			}

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


	public void mirror()
	{
		mirror_helper(root);
	}
	private void mirror_helper(Node node)
	{
		if(node==null)
			return;
		else
		{
			Node temp=node.left;
			node.left=node.right;
			node.right=temp;
			mirror_helper(node.left);
			mirror_helper(node.right);
		}
	}

	public boolean find(T data)//debug
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

		Node l=this.findHelp(node.left, data);
		if(l != null)
		{
			return l;
		}
		Node r=this.findHelp(node.right, data);
		return r;		
	}

	private Node bulidTreeFromPreIn(T[] preOrder,int preSI,int preEI,T[] inOrder,int inSI,int inEI)
	{
		int SearchI=-1;
		if(preSI>preEI || inSI>inEI)
			return null;

		Node node=new Node(preOrder[preSI]);
		for(int i=inSI;i<=inEI;i++)
		{
			if(inOrder[i].equals(preOrder[preSI]))
			{
				SearchI=i;
				break;
			}
		}
		int numLeftst= SearchI-inSI;
		node.left=this.bulidTreeFromPreIn(preOrder, preSI+1,numLeftst+preSI, inOrder, inSI, SearchI-1);
		node.right=this.bulidTreeFromPreIn(preOrder, numLeftst+preSI+1, preEI, inOrder, SearchI+1, inEI);
		return node;
	}
	private Node bulidTreeFromPostIn(T[] postOrder,int postSI,int postEI,T[] inOrder,int inSI,int inEI)
	{
		int SearchI=-1;
		if(postSI>postEI || inSI>inEI)
			return null;
		Node node=new Node(postOrder[postEI]);
		for(int i=inSI;i<=inEI;i++)
		{
			if(inOrder[i].equals(postOrder[postEI]))
			{
				SearchI=i;
				break;
			}
		}
		int numLeftst= SearchI-inSI;
		node.left=this.bulidTreeFromPostIn(postOrder, postSI,numLeftst+postSI-1, inOrder, inSI, SearchI-1);
		node.right=this.bulidTreeFromPostIn(postOrder, numLeftst+postSI, postEI-1, inOrder, SearchI+1, inEI);
		return node;
	}
	private Node bulidTreeFromPrePost(T[] preOrder,int preSI,int preEI,T[] postOrder,int postSI,int postEI)
	{
		int SearchI=-1;
		if(postSI>postEI || preSI>preEI)
			return null;
		Node node=new Node(postOrder[postEI]);
		if(preSI==preEI)
		{
			node.left=null;
			node.right=null;
			return node;
		}
		for(int i=postSI;i<=postEI;i++)
		{
			if(preOrder[preSI+1].equals(postOrder[i]))
			{
				SearchI=i;
				break;
			}
		}
		int numLeftst= SearchI-postSI+1;
		node.left=this.bulidTreeFromPrePost(preOrder, preSI+1, preSI+numLeftst, postOrder,postSI, postSI+numLeftst-1);
		node.right=this.bulidTreeFromPrePost(preOrder, preSI+numLeftst+1, preEI, postOrder, postSI+numLeftst, postEI-1);
		return node;//assume 0 or 2 children
	}
	public boolean isBst()
	{
		return this.isBstHelp(root);
	}
	private boolean isBstHelp(Node node)
	{
		if(node==null)
			return true;
		Node leftMax=this.maxElementHelper(node.left);
		Node rightMin=this.minElementHelper(node.right);
		if(leftMax!=null && node.data.compareTo(leftMax.data)<0)
			return false;
		if(rightMin!=null && node.data.compareTo(rightMin.data)>0)
			return false;
		return this.isBstHelp(node.left) && this.isBstHelp(node.right);
		//		if(node.data.compareTo(node.left.data)>0 && node.data.compareTo(node.right.data)<0)
		//		{
		//			return isBstHelp(node.left) && isBstHelp(node.right);
		//		}
		//		else
		//			return false;
	}
	private tri isBstHelp2(Node node)
	{
		tri retval=new tri();
		if(node==null)
		{
			retval.isbst=true;
			retval.max=Integer.MIN_VALUE;
			retval.min=Integer.MAX_VALUE;
			return retval;
		}

		tri l=isBstHelp2(node.left);
		if(!l.isbst)
		{
			return l;	
		}
		else
		{
			if(l.max>(Integer)node.data)
			{
				retval.isbst=false;
				return retval;
			}
		}
		tri r=isBstHelp2(node.right);
		if(!r.isbst)
		{
			return r;
		}
		else
		{
			if(r.min<(Integer)node.data)
			{
				retval.isbst=false;
				return retval;
			}
		}

		retval.isbst=true;
		retval.min=Math.min((Integer)node.data, l.min);//check for leaf
		retval.max=Math.max((Integer)node.data, r.max);
		return retval;
		//set l& r
	}
	public boolean isBst3()
	{
		return isBstHelp3(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	public boolean isBstHelp3(Node node,Integer lo,Integer up)
	{
		if(node==null)
			return true;

		if((Integer)node.data<lo || (Integer)node.data>up)
		{
			return false;
		}
		return this.isBstHelp3(node.left, lo, (Integer)node.data) &&
				this.isBstHelp3(node.right, (Integer)node.data+1, up);
		//should not touch (Integer)node.data as lower bound
	}
	public int largestBst()
	{
		return this.largestBstHelper(root);
	}
	private int largestBstHelper(Node node)
	{
		if(node==null)
			return 1;
		if(isBstHelp3(node,Integer.MIN_VALUE,Integer.MAX_VALUE))
			return this.size_helper(node);
		return Math.max(this.largestBstHelper(node.left), this.largestBstHelper(node.right));
	}
	public boolean Isidentical(BinaryTree<T> bt)
	{
		return IsidenticalHelper(this.root,bt.root);
	}
	private boolean IsidenticalHelper(Node n1,Node n2)
	{
		if(n1==null && n2==null)
			return true;
		if((n1==null && n2!=null) || (n1!=null && n2==null))
			return false;
		else if(n1.data.equals(n2.data))
		{			
			return IsidenticalHelper(n1.left,n2.left) && IsidenticalHelper(n1.right,n2.right);
		}
		else
			return false;		
	}

	public boolean checkBalanced()
	{
		return checkBalancedHelper(root);
	}
	private boolean checkBalancedHelper(Node node)
	{
		if(node==null)
			return true;
		else if(node.left==null || node.right==null)//wrong
			return true;
		else
		{
			if(Math.abs(this.height_helper(node.left)-this.height_helper(node.right))>1)
				return false;
			else
			{
				return this.checkBalancedHelper(node.left) && this.checkBalancedHelper(node.right);
			}
		}

	}
	public void remove_leaves()
	{
		remove_leavesHelper(root);
	}
	private void remove_leavesHelper(Node node)
	{
		if(node!=null)
		{
			//			if(node.left==null && node.right==null)
			//			{
			//				node.data=null;
			//				node=null;
			//				return;
			//			}
			if(node.left!=null && node.left.left==null && node.left.right==null)
			{
				node.left=null;
			}
			if(node.right!=null && node.right.left==null && node.right.right==null)
			{
				node.right=null;
			}
			remove_leavesHelper(node.left);
			remove_leavesHelper(node.right);
		}
	}
	//	public void DisplayLevelwiselist()
	//	{
	//		linkedlist<Node>[] a=LevelwiselistHelper();
	//		for(int i=0;i<a.length;i++)
	//		{
	//			System.out.println(a[i]);
	//		}
	//	}
	//	private linkedlist<Node>[] LevelwiselistHelper()
	//	{
	//		int h=1;
	//		//linkedlist<Node>[] arr=new linkedlist[h]<>;
	//		Queue<Node> q=new Queue<>();
	//		if(root==null)
	//			return null;
	//		q.enqueqe(root);
	//		int i=0;
	//		int j=0;
	//		while(!q.isEmpty())
	//		{
	//			//arr[0]=new linkedlist<>();
	//			i++;
	//			if(i==2+j)
	//				j+=q.size();
	//			Node temp=q.dequeue();
	//			
	//			System.out.print(temp.data+" ");
	//			if(i==1+j)
	//			{
	//				System.out.println("");
	//			}
	//			
	//			if(temp.left!=null)
	//			{
	//				q.enqueqe(temp.left);
	//			}
	//			if(temp.right!=null)
	//			{
	//				q.enqueqe(temp.right);
	//			}
	//		}
	//	}
	public T LCA(T d1,T d2)
	{
		return this.LCAHelper(d1, d2, root).data;
	}
	private Node LCAHelper(T d1,T d2,Node node)
	{
		if(node==null)
			return null;
		if(node.data.equals(d1) || node.data.equals(d2))
		{
			return node;
		}
		Node leftLCA=this.LCAHelper(d1, d2, node.right);
		Node rightLCA=this.LCAHelper(d1, d2, node.left);
		if(leftLCA!=null && rightLCA!=null)
			return node;
		if(leftLCA!=null)
			return leftLCA;
		else
			return rightLCA;
	}
	public boolean pairsum(T data)
	{
		ArrayList<T> a=new ArrayList<T>();
		this.pairsumHelper(root, a);
		int i=0;
		Integer sum=0;
		for(;i<a.size()-1;i++)
		{
			for(int j=i+1;j<a.size();j++)
			{
				sum=(Integer)a.get(i)+(Integer)a.get(j);
				if(sum==data)
					return true;
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

	//practice1
	public void nodeatkdist(int k)
	{
		node_at_k_helper(this.root,k);
	}
	private void node_at_k_helper(Node node, int k) {
		// TODO Auto-generated method stub

		if(node==null)
		{
			return;
		}
		if(k==0)
		{
			System.out.println(node.data);
			return;
		}
		node_at_k_helper(node.left,k-1);
		node_at_k_helper(node.right,k-1);
	}
	public boolean isBstp1()
	{
		return isBstp1_helper(this.root);
	}
	private boolean isBstp1_helper(Node node) {
		// TODO Auto-generated method stub
		if(node!=null)
		{
			boolean t1=true,t2=true,t;
			if(node.left!=null)
			{
				if(node.left.data.compareTo(node.data)<0)
				{
					t1=true;
				}
				else
					t1=false;
			}
			if(node.right!=null)
			{
				if(node.right.data.compareTo(node.data)>0)
				{
					t2=true;
				}
				else
					t2=false;
			}
			t=t1 && t2;
			if(!t)
			{
				return t;
			}

			boolean t3=isBstp1_helper(node.left);
			boolean t4=isBstp1_helper(node.left);
			return t3 && t4;
		}
		else
			return true;
	}







}
