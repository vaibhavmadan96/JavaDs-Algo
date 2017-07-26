import java.util.ArrayList;
import java.util.Scanner;


public class GenericTree<T extends Comparable> {
	private class TreeNode 
	{
		T data;
		ArrayList<TreeNode> children;
		TreeNode(T data)
		{
			this.data=data;
			this.children=new ArrayList<>();
		}
	}
	private TreeNode root;
	public GenericTree()
	{
		root=this.takeInput(new Scanner(System.in));
	}
	public GenericTree(String[] args)
	{
		Queue<Integer> queue=new Queue();
		for(int i=0;i<args.length;i++)
		{
			queue.enqueqe(Integer.parseInt(args[i]));
		}
		this.root=this.takeInputArgs(queue);
	}
	private TreeNode takeInputArgs(Queue<Integer> queue)
	{
		TreeNode node=new TreeNode((T)queue.dequeue());
		int numChild=queue.dequeue();
		for(int i=0;i<numChild;i++)
		{
			TreeNode child=this.takeInputArgs(queue);
			node.children.add(child);
		}
		return node;
	}
	private TreeNode takeInput(Scanner scn)
	{
		System.out.println("Enter the data");
		T data=(T)(Integer)scn.nextInt();
		TreeNode node=new TreeNode(data);

		System.out.println("Enter no. of children for "+data+"-");
		int numChild=scn.nextInt();
		for(int i=0;i<numChild;i++)
		{
			TreeNode child=this.takeInput(scn);
			node.children.add(child);
		}
		return node;
	}

	private TreeNode takeInputLevelWise(Scanner scn)
	{
		System.out.println("Enter the data");
		T data=(T)(Integer)scn.nextInt();
		TreeNode node=new TreeNode(data);

		
		Queue<TreeNode> queue=new Queue<>();
		queue.enqueqe(node);
		while(!queue.isEmpty())
		{
			TreeNode temp=queue.dequeue();

			System.out.println("Enter no. of children for "+temp.data+"-");
			int numChild=scn.nextInt();
			for(int i=0;i<numChild;i++)
			{
				System.out.println("Enter the data");
				T cdata=(T)(Integer)scn.nextInt();
				TreeNode childnode=new TreeNode(cdata);
				
				queue.enqueqe(childnode);
				temp.children.add(childnode);
			}
			
		}
		
		
		return node;
	}
	public int countNodesGreaterThan(T data){
		return this.countNodesGreaterThanhelper(this.root, data);
	}
	
	private int countNodesGreaterThanhelper(TreeNode node, T data){
		int retVal = 0;
		
		for(int i = 0; i < node.children.size(); i++){
			retVal += this.countNodesGreaterThanhelper(node.children.get(i), data);
		}
		
		if(node.data.compareTo(data) > 0){
			retVal++;
		}
		
		return retVal;
	}
	public int size()
	{
		return this.root!=null?this.size_helper(root):0;
	//	return this.size_helper(root);
	}
	private int size_helper(TreeNode node)
	{
		int retval=0;
		for(int i=0;i<node.children.size();i++)
		{
			retval+=this.size_helper(node.children.get(i));
		}
		retval++;
		return retval;
	}
	public boolean isEmpty()
	{
		return this.size()==0;
	}
	public void display()
	{
		this.displayHelper(this.root);
	}
	private void displayHelper(TreeNode node)
	{
		String nodeDisplay=node.data+"->";
		for(int i=0;i<node.children.size();i++)
		{
			nodeDisplay+=node.children.get(i).data+",";
		}
		nodeDisplay+="End";
		System.out.println(nodeDisplay);
		for(int i=0;i<node.children.size();i++)
		{
			this.displayHelper(node.children.get(i));
		}
	}
	public void displayatDepth(int k)
	{
		this.displayAtDepthHelper(root,k);
	}
	private void displayAtDepthHelper(TreeNode node,int k)
	{
		if(k==0)
		{
			System.out.println(node.data);
			return;
		}
		for(int i=0;i<node.children.size();i++)
		{
			displayAtDepthHelper(node.children.get(i),k-1);
		}
	}
	public int height()
	{
		return this.height_helper(root);
	}
	private int height_helper(TreeNode node)
	{
		int maxheight=0;
		for(int i=0;i<node.children.size();i++)
		{
			int childHeight=this.height_helper(node.children.get(i));
			if(childHeight>maxheight)
			{
				maxheight=childHeight;
			}
		}
		maxheight++;
		return maxheight;
	}
	public T elementWithMaxVal()
	{
		return this.nodeWithMaxVal(this.root).data;
	}
	private TreeNode nodeWithMaxVal(TreeNode node)
	{
		TreeNode maxnode=node;
		TreeNode temp;
		for(int i=0;i<node.children.size();i++)
		{
			temp=nodeWithMaxVal(maxnode.children.get(i));
			if(temp.data.compareTo(maxnode.data)>0)
			{
				maxnode=temp;
			}
		}
		
		return maxnode;
	}
	public int elementWithMaxSum()
	{
		return this.getSum(NodewithMaxSum(root));
	}
	private TreeNode NodewithMaxSum(TreeNode node)
	{
		TreeNode maxnode=node;
		TreeNode temp;
		for(int i=0;i<node.children.size();i++)
		{
			temp=NodewithMaxSum(maxnode.children.get(i));
			if(this.getSum(temp)>this.getSum(maxnode))
			{
				maxnode=temp;
			}
		}
		
		return maxnode;
	}
	private int getSum(TreeNode node)
	{
		int sum=0;
		sum+=(Integer)node.data;
		for(int i=0;i<node.children.size();i++)
		{
			sum+=(Integer)node.children.get(i).data;
		}
		return sum;
	}
	public void PreorderRecur()
	{
		PreorderRecur_help(root);
	}
	private void PreorderRecur_help(TreeNode node)//plr
	{
		
			System.out.print(node.data+" ");
			for(int i=0;i<node.children.size();i++)
			this.PreorderRecur_help(node.children.get(i));
			
		
	}
	public void PreorderIter()
	{
		//stack
		stack<TreeNode> s=new stack<>();
		s.push(root);
		while(!s.isEmpty())
		{
			TreeNode node=s.pop();
			for(int i=node.children.size()-1;i>=0;i--)
			{
				s.push(node.children.get(i));
			}
			System.out.println(node.data+",");
		}
	}
	public void Postorder()
	{
		Postorder_help(root);
	}
	private void Postorder_help(TreeNode node){
		
			for(int i=0;i<node.children.size();i++)
			this.Postorder_help(node.children.get(i));
			System.out.print(node.data+" ");
		
	}
	public int leaf_node()
	{
		return (leaf_nodes_help(root));
	}
	private static int sum=0;
	private int leaf_nodes_help(TreeNode node){
		
		if(node.children.size()==0)
		{
			sum++;
		}
		for(int i=0;i<node.children.size();i++)
		this.leaf_nodes_help(node.children.get(i));
		
	return sum;
}
	public void levelOrder()
	{	
		//q
		Queue<TreeNode> q=new Queue<>();
		q.enqueqe(root);
		while(!q.isEmpty())
		{
			TreeNode node=q.dequeue();
			System.out.println(node.data+",");
		for(int i=0;i<node.children.size();i++)
		{
			q.enqueqe(node.children.get(i));
		}
		}
	}
	public boolean match2trees(GenericTree<T> tree)
	{
		return this.match2trees_helper(root,tree.root);
	}
	private boolean match2trees_helper(TreeNode node,TreeNode node1)
	{
		if(node==null && node1==null)
			return true;
		else
		{
			boolean t=node.data.compareTo(node1.data)==0 ;
			boolean t1=true;
			if(node.children.size()==node1.children.size())
			{
				boolean[] arr=new boolean[node.children.size()];
				for(int i=0;i<node.children.size();i++)
				{
					arr[i]=this.match2trees_helper(node.children.get(i), node1.children.get(i));
				}
				for(int i=0;i<node.children.size();i++)
				{
					t1=t1 && arr[i];
				}
				return t1 && t;
			}
			else
				return false;

		}
	}
	public void replaceByDepth()
	{
		replaceByDepth_helper(root,0);
	}
	private void replaceByDepth_helper(TreeNode node,int i)
	{

		node.data=(T)(Integer)i++;
		for(int j=0;j<node.children.size();j++)
		this.replaceByDepth_helper(node.children.get(j),i);

	}
	
	public int Allsum()
	{
		return sumAll_helper(root);
	}
	private int sumAll_helper(TreeNode node)
	{
		int sum=0;
		sum+=(Integer)node.data;
		for(int i=0;i<node.children.size();i++)
		{
			sum+=sumAll_helper(node.children.get(i));
			
		}
		return sum;
	}
	public int second_largest()
	{
		int max=Integer.MIN_VALUE,submax=Integer.MIN_VALUE;
		Queue<TreeNode> q=new Queue<>();
		q.enqueqe(root);
		while(!q.isEmpty())
		{
			TreeNode node=q.dequeue();
			if(max<(Integer)node.data)
			{
				submax=max;
				max=(Integer)node.data;
			}
		for(int i=0;i<node.children.size();i++)
		{
			q.enqueqe(node.children.get(i));
		}
		}
		return submax;
	}
	
	public int next_larger(int val)
	{
	
		Queue<TreeNode> q=new Queue<>();
		int diff=Integer.MAX_VALUE;
		q.enqueqe(root);
		while(!q.isEmpty())
		{
			TreeNode node=q.dequeue();
			int temp=(Integer)node.data-val;
			if(temp<diff && temp>0)
			{
				diff=temp;
			}
		for(int i=0;i<node.children.size();i++)
		{
			q.enqueqe(node.children.get(i));
		}
		}
		
			return diff+val;
	}

	
}
