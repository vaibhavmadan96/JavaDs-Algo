
public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//				String s1="abcd";
//				String s2="abcd";
//				System.out.println(Edit(s1,s2));

		//		int[] a={10,15,20,25};//last work
		//		System.out.println(minCostDP(a));

//		int[] a={2,3,4,6,8,15};
//		int[] b={1,3,5,7,8,10};
//		System.out.println(largestSegmentSum(a,b));
		
		LaxographicalOrder(100,1);
	}
	public static int largestSegmentSum(int[] a,int[] b)
	{
		//merge func
		int i=0,j=0,seg1=0,seg2=0,sum=0;
		while(i<a.length && j<b.length)
		{
			seg1=seg2=0;
			while(i<a.length && j<b.length && a[i]!=b[j])
			{
				seg1+=a[i];
				seg2+=b[j];
				i++;
				j++;
			}
			if(i>=a.length || j>=b.length)
			{
				if(seg1>seg2)
				{
					sum+=seg1;
				}
				else
				{
					sum+=seg2;
				}
				return sum;
			}
			if(seg1>seg2)
			{
				sum+=seg1+a[i];
			}
			else
			{
				sum+=seg2+a[i];
			}
			i++;
			j++;
		}
		return sum;
	}
	public static void LaxographicalOrder(int n,int k)
	{
		if(k>n)
			return;
		int upper=(k==1?9:10);
		for(int i=0;i<upper && k<=n;i++)
		{
			System.out.print(k+",");
			LaxographicalOrder(n,k*10);
			k++;
		}

	}
	public static int LCS(String s1,String s2)
	{
		if(s1.length()==0 || s2.length()==0)
		{
			return 0;
		}
		else if(s1.charAt(0)==s2.charAt(0))
		{
			return 1+LCS(s1.substring(1),s2.substring(1));
		}
		else
		{
			return Math.max(LCS(s1, s2.substring(1)),LCS(s1.substring(1), s2));
		}
	} 
	public static int LCSR(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int[][] storage=new int[m+1][n+1];
		return lcsr(s1,s2,storage);
	}
	private static int lcsr(String s1, String s2, int[][] storage) {
		int m=s1.length();
		int n=s2.length();
		int ans=0;
		if(s1.length()==0 || s2.length()==0)
		{
			return 0;
		}

		else if(s1.charAt(0)==s2.charAt(0))
		{
			ans= 1+lcsr(s1.substring(1),s2.substring(1),storage);
		}
		else
		{
			ans= Math.max(lcsr(s1, s2.substring(1),storage),lcsr(s1.substring(1), s2,storage));
		}
		storage[m][n]=ans;
		return ans;
	}

	public static int fib(int n)
	{
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else
		{
			return fib(n-1)+fib(n-2);
		}
	}
	public static int fib2(int n)
	{
		int[] storage=new int[n+1];
		return fibR(n,storage);
	}
	private static int fibR(int n, int[] storage) {
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else if(storage[n]!=0)
		{
			return storage[n];
		}
		int ans=fibR(n-1,storage)+fibR(n-2,storage);
		storage[n]=ans;
		return ans;
	}

	public static int Edit(String s1,String s2)
	{

		if(s1.length()==0 )
		{
			return s2.length();
		}
		else if(s2.length()==0)
		{
			return s1.length();
		}
		else if(s1.charAt(0)==s2.charAt(0))
		{
			return Edit(s1.substring(1),s2.substring(1));
		}
		else
		{
			return Math.min(1+Edit(s1.substring(1),s2), Math.min(1+Edit(s1,s2.substring(1)), 1+Edit(s1.substring(1),s2.substring(1))));
		}
	}
	public static int Editstorage(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int[][] storage=new int[m+1][n+1];
		return EditStore( s1, s2,storage);
	}
	private static int EditStore(String s1,String s2,int[][] storage)
	{
		for(int i=0;i<storage.length;i++)//0 is a valid value here
		{
			for(int j=0;j<storage[0].length;j++)
			{
				storage[i][j]=-1;
			}
		}
		int ans=0;
		int m=s1.length();
		int n=s2.length();
		if(m==0)
		{
			ans= s2.length();
		}
		if(n==0)
		{
			ans= s1.length();
		}
		if(storage[m][n]!=-1)
		{
			return storage[m][n];
		}
		if(s1.charAt(0)==s2.charAt(0))
		{
			ans= Edit(s1.substring(1),s2.substring(1));
		}
		else
		{
			ans= Math.min(1+Edit(s1.substring(1),s2), Math.min(1+Edit(s1,s2.substring(1)), 1+Edit(s1.substring(1),s2.substring(1))));
		}
		storage[m][n]=ans;
		return ans;
	}

	public static int lcsDP(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int[][] storage=new int[m+1][n+1];

		for(int i=1;i<m+1;i++)
		{
			for(int j=1;j<n+1;j++)
			{
				if(s1.charAt(m-i)==s2.charAt(n-j))
				{
					storage[i][j]=1+storage[i-1][j-1];
				}
				else
				{
					storage[i][j]=Math.max(storage[i-1][j], storage[i][j-1]);
				}
			}
		}
		return storage[m][n];
	}

	public static int minEdit(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int[][] storage=new int[m+1][n+1];
		for(int i=1;i<storage.length;i++)
		{
			storage[i][0]=i;
		}
		for(int i=1;i<storage[0].length;i++)
		{
			storage[0][i]=i;
		}
		for(int i=1;i<m+1;i++)
		{
			for(int j=1;j<n+1;j++)
			{
				if(s1.charAt(m-i)==s2.charAt(n-j))
				{
					storage[i][j]=storage[i-1][j-1];
				}
				else
				{
					storage[i][j]=Math.min(1+storage[i-1][j], Math.min(1+storage[i][j-1], 1+storage[i-1][j-1]));
				}
			}
		}
		return storage[m][n];
	}
	//	
	//	public static int minCost(int[] a)
	//	{
	//		int[][] matrix=new int[a.length-1][2];
	//		for(int i=0;i<matrix.length;i++)
	//		{
	//			matrix[i][0]=a[i];
	//			matrix[i][1]=a[i+1];
	//		}
	//		return minCostr(matrix,0);
	//	}
	public static int minCostr(int[] dimensions,int start,int end) {
		if(start>=end)
		{
			return 0;
		}
		int minCost=Integer.MAX_VALUE;
		for(int k=start;k<end;k++)
		{
			int cost=minCostr(dimensions,start,k)+minCostr(dimensions,k+1,end)+
					dimensions[start-1]*dimensions[k]*dimensions[end];
			if(cost<minCost)
			{
				minCost=cost;
			}

		}
		return minCost;
	}
	public static int minCostStore(int[] dimensions,int start,int end)
	{
		int[][] storage=new int[dimensions.length+1][dimensions.length+1];
		for(int i=0;i<storage.length;i++)
		{
			for(int j=0;j<storage[0].length;j++)
			{
				storage[i][j]=-1;
			}
		}
		return minCostStore(dimensions,start,end,storage);
	}
	private static int minCostStore(int[] dimensions, int start, int end,
			int[][] storage) {

		int m=start;
		int n=end;
		if(start>=end)
		{
			storage[m][n]=0;
			return 0;
		}
		int minCost=Integer.MAX_VALUE;
		int first=0,second=0;
		for(int k=start;k<end;k++)
		{
			if(storage[start][k]!=-1)
			{
				first=storage[start][k];
			}
			else
			{
				first=minCostr(dimensions,start,k);//put in store or not
			}
			if(storage[k+1][end]!=-1)
			{
				second=storage[k+1][end];
			}
			else
			{
				second=minCostr(dimensions,k+1,end);//put in store or not
			}

			int cost=first+second+
					dimensions[start-1]*dimensions[k]*dimensions[end];
			if(cost<minCost)
			{
				minCost=cost;
			}

		}
		storage[m][n]=minCost;
		return minCost;
	}
	public static int minCostDP(int[] dimensions)//complete
	{
		int[][] storage=new int[dimensions.length+1][dimensions.length+1];
		int len=dimensions.length+1;
		for(int i=1;i<len;i++)
		{
			storage[i][i]=0;
		}
		for(int i=1;i<len;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(storage[i][j]!=0)
				{
					int start=i,end=j;
					int minCost=Integer.MAX_VALUE;
					for(int k=start;k<end;k++)
					{
						int cost=storage[start][k]+storage[k+1][end]+
								dimensions[start-1]*dimensions[k]*dimensions[end];
						if(cost<minCost)
						{
							minCost=cost;
						}

					}
					storage[i][j]=minCost;
				}
			}
		}
		return storage[1][storage[0].length];
	}

}
