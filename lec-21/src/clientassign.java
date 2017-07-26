
public class clientassign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.out.println(minstepsDP(7));
		//		String s="forgeeksskeegfor";
		//		System.out.println(longestPalin(s));
//		int a[]={3,5};
//		System.out.println(minselectionDp(a,7));
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;
	    System.out.println(knapsackDP(wt,val,W,wt.length));
	}
	public static int knapsackDP(int[] wt, int[] val, int w,int n) {
		// TODO Auto-generated method stub
		int[][] storage=new int[n+1][w+1];
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<w+1;j++)
			{
				storage[i][j]=-1;
			}
		}
		//we need to obtain the maximum profit value for a given n and wt<=w
		for(int i=0;i<n+1;i++)
		{
			for(int j=0;j<w+1;j++)
			{
				if(i==0 || j==0)
				{
					storage[i][j]=0;
				}
				else if(wt[i-1]>=j)
				{
					storage[i][j]=storage[i-1][j];
				}
				else
				{
					storage[i][j]=Math.max(val[i-1]+storage[i-1][j-wt[i-1]], storage[i-1][j]);
				}
				
			}
		}
		return storage[n][w];
	}
	public static int knapsackstorage(int[] wt, int[] val, int w,int n) {
		// TODO Auto-generated method stub
		int[][] storage=new int[w+1][n+1];
		for(int i=0;i<w+1;i++)
		{
			for(int j=0;j<n+1;j++)
			{
				storage[i][j]=-1;
			}
		}
		return knapsackstorageHelper(wt,val,w,n,storage);
	}
	private static int knapsackstorageHelper(int[] wt, int[] val, int w, int n,
			int[][] storage) {
		// TODO Auto-generated method stub
		if(w==0 || n==0)
		{
			return 0;
		}
		if(storage[w][n]!=-1)
		{
			return storage[w][n];
		}
		int ans=0;
		if(wt[n-1]>w)
		{
			ans= knapsack(wt,val,w,n-1);
		}
		else
		{
			ans=Math.max(val[n-1]+knapsack(wt,val,w-wt[n-1],n-1), knapsack(wt,val,w,n-1));
			
		}
		storage[w][n]=ans;
		return ans;
	}
	public static int knapsack(int[] wt, int[] val, int w,int n) {
		// TODO Auto-generated method stub
		if(w==0 || n==0)
		{
			return 0;
		}
		if(wt[n-1]>w)
		{
			return knapsack(wt,val,w,n-1);
		}
		else
		{
			int ans=Math.max(val[n-1]+knapsack(wt,val,w-wt[n-1],n-1), knapsack(wt,val,w,n-1));
			return ans;
		}
	}
	public static int minselectionDp(int[] a, int sum) {
		// TODO Auto-generated method stub
		int[] storage=new int[sum+1];
		
		for(int l=1;l<sum+1;l++)
		{
			int ans=Integer.MAX_VALUE;
			int q=0;
			for(int i=0;i<a.length;i++)
			{
				if(l-a[i]>=0)
				{
					q=storage[l-a[i]];
					if(q<ans)
					{
						ans=q;
					}
				}		
			}
			if(ans!=Integer.MAX_VALUE)
			{
				storage[l]=1+ans;

			}	
			else
			{
				storage[l]=ans;//not possible to acheive the sum
			}
		}
		return storage[sum];
	}
	public static int minselectionstorage(int[] a, int sum) {
		// TODO Auto-generated method stub
		int[] storage=new int[sum+1];
		return minselectionstorageHelper(a,sum,storage);
	}
	private static int minselectionstorageHelper(int[] a, int sum, int[] storage) {
		// TODO Auto-generated method stub
		if(sum==0)
		{
			return 0;
		}
		if(storage[sum]!=0)
		{
			return storage[sum];
		}
		int ans=Integer.MAX_VALUE;
		int q=0;
		for(int i=0;i<a.length;i++)
		{
			if(sum-a[i]>=0)
			{
				q=minselection(a,sum-a[i]);
				if(q<ans)
				{
					ans=q;
				}
			}		
		}
		if(ans!=Integer.MAX_VALUE)
		{
			storage[sum]=1+ans;
			return 1+ans;

		}	
		else
		{
			storage[sum]=ans;
			return ans;
		}

	}
	public static int minselection(int[] a, int sum) {
		// TODO Auto-generated method stub
		if(sum==0)
		{
			return 0;
		}
		int ans=Integer.MAX_VALUE;
		int q=0;
		for(int i=0;i<a.length;i++)
		{
			if(sum-a[i]>=0)
			{
				q=minselection(a,sum-a[i]);
				if(q<ans)
				{
					ans=q;
				}
			}		
		}
		if(ans!=Integer.MAX_VALUE)
			return 1+ans;
		else
			return ans;
	}
	public static String longestPalin(String s) //longest substring palindrome
	{
		// TODO Auto-generated method stub
		int n=s.length();
		boolean[][] storage=new boolean[n-1][n-1];
		int maxlength=0;
		int start=0;
		for(int i=0;i<n-1;i++)
		{
			storage[i][i]=true;
			maxlength=1;
		}
		for(int i=1;i<n-1;i++)
		{
			if(s.charAt(i-1)==s.charAt(i))
			{
				storage[i-1][i]=true;
				start=i-1;
			}
		}
		for(int k=3;k<n;k++)
		{
			for(int i=0;i<n-k+1;i++)//see filling diag
			{
				int j=i+k-1;//take effect of both i and k
				if(s.charAt(i)==s.charAt(j) && storage[i+1][j-1])
				{
					storage[i][j]=true;
					if(k>maxlength)
					{
						start=i;
						maxlength=k;
					}

				}
			}
		}
		return s.substring(start, start+maxlength);
	}
	public static int minstepsDP(int num) {
		// TODO Auto-generated method stub
		int[] storage=new int[num+1];
		for(int i=2;i<num+1;i++)
		{
			int x=i,y=i,z=i;
			if(i%2==0)
			{
				x=storage[i/2];
			}
			if(i%3==0)
			{
				y=storage[i/3];
			}
			z=storage[i-1];
			int ans=1+Math.min(x, Math.min(y, z));
			storage[i]=ans;
		}
		return storage[num];
	}
	public static int minsteps(int num)
	{
		if(num<=1)
		{
			return 0;
		}
		int x=num,y=num,z=num;
		if(num%2==0)
		{
			x=minsteps(num/2);
		}
		if(num%3==0)
		{
			y=minsteps(num/3);
		}
		z=minsteps(num-1);
		int ans=1+Math.min(x,Math.min(y, z));
		return ans;
	}
	public static int minsteps_storage(int num)
	{
		int[] storage=new int[num+1];

		return minsteps_storage(num,storage);
	}
	private static int minsteps_storage(int num, int[] storage) {
		// TODO Auto-generated method stub
		if(num<=1)
		{
			return 0;
		}
		if(storage[num]!=0)
		{
			return storage[num];
		}
		int x=num,y=num,z=num;
		if(num%2==0)
		{
			x=minsteps(num/2);
		}
		if(num%3==0)
		{
			y=minsteps(num/3);
		}
		z=minsteps(num-1);
		int ans=1+Math.min(x,Math.min(y, z));
		storage[num]=ans;
		return ans;

	}
}
