
public class clientpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s1="abcd";
//		String s2="abcd";
//		System.out.println(EditDP(s1,s2));
		int dimensions[] = {10,15,20,25};
		System.out.println(minCostDP(dimensions,1,dimensions.length-1));
	}
	public static int minCostDP(int[] dimensions, int start, int end) {
		// TODO Auto-generated method stub
		int m=end+1;
		int[][] storage=new int[m][m];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<m;j++)
			{
				storage[i][j]=-1;
			}
		}
		//matrix chain length =1
		for(int i=0;i<m;i++)
		{
			storage[i][i]=0;
		}
		//matrix chain length l
		for(int l=2;l<m;l++)
		{
			for(int i=1;i<m-l+1;i++)
			{
				int j=i+l-1;//taking the cummulative effect of i and l
				storage[i][j]=Integer.MAX_VALUE;
				int q=0;
				for(int k=i;k<j;k++)
				{
					q=storage[i][k]+storage[k+1][j]+dimensions[i-1]*dimensions[k]*dimensions[j];
					if(q<storage[i][j])
					{
						storage[i][j]=q;
					}
				}
			}
		}
		return storage[start][end];
	}
	public static int minCoststore(int[] dimensions, int start, int end) {
		// TODO Auto-generated method stub
		int m=end+1;
		int[][] storage=new int[m][m];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<m;j++)
			{
				storage[i][j]=-1;
			}
		}
		return minCoststore(dimensions,start,end,storage);
	}
	private static int minCoststore(int[] dimensions, int start, int end,int[][] storage) {
		// TODO Auto-generated method stub
		if(start>=end)
		{
			return 0;
		}
		if(storage[start][end]!=-1)
		{
			return storage[start][end];
		}
		int mincost=Integer.MAX_VALUE;
		for(int k=start;k<end;k++)
		{
			int cost=minCoststore(dimensions,start,k,storage)+minCoststore(dimensions,k+1,end,storage)+
					dimensions[start-1]*dimensions[k]*dimensions[end];
			if(cost<mincost)
			{
				mincost=cost;
			}
		}
		storage[start][end]=mincost;
		return mincost;
	}
	public static int mcm(int[] dimensions, int start, int end) {
		// TODO Auto-generated method stub
		if(start>=end)
		{
			return 0;
		}
		int mincost=Integer.MAX_VALUE;
		for(int k=start;k<end;k++)
		{
			int cost=mcm(dimensions,start,k)+mcm(dimensions,k+1,end)+
					dimensions[start-1]*dimensions[k]*dimensions[end];
			//other multiplications would compress down to yield dimension[k]
			if(cost<mincost)
			{
				mincost=cost;
			}
		}
		return mincost;
	}
	public static int Editr(String s,String t)
	{
		if(s.length()==0)
		{
			return t.length();
		}
		if(t.length()==0)
		{
			return s.length();
		}
		if(s.charAt(0)==t.charAt(0))
		{
			return Editr(s.substring(1),t.substring(1));
		}
		else
		{
			return 1+Math.min(Editr(s,t.substring(1)), Math.min(Editr(s.substring(1),t), Editr(s.substring(1),t.substring(1))));
		}
	}
	public static int EditStorage(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int[][] storage=new int[m+1][n+1];
		for(int i=0;i<m+1;i++)
		{
			for(int j=0;j<n+1;j++)
			{
				storage[i][j]=-1;
			}
		}
		return EditStorageHelper(s1,s2,storage);
	}
	private static int EditStorageHelper(String s1,String s2,int[][] storage)
	{
		int m=s1.length();
		int n=s2.length();
		if(s1.length()==0)
		{
			//storage[m][n]=s2.length();
			return s2.length();
		}
		if(s2.length()==0)
		{
			//storage[m][n]=s1.length();
			return s1.length();
		}
		int ans=0;
		if(storage[m][n]!=-1)
		{
			ans= storage[m][n];
		}
		if(s1.charAt(0)==s2.charAt(0))
		{
			ans= EditStorageHelper(s1.substring(1),s2.substring(1),storage);
		}
		else
		{
			ans= 1+Math.min(EditStorageHelper(s1,s2.substring(1),storage), Math.min(EditStorageHelper(s1.substring(1),s2,storage), EditStorageHelper(s1.substring(1),s2.substring(1),storage)));
		}
		storage[m][n]=ans;
		return ans;
	}
	public static int EditDP(String s1,String s2)
	{
		int m=s1.length();
		int n=s2.length();
		int[][] storage=new int[m+1][n+1];
		for(int i=0;i<m+1;i++)
		{
			for(int j=0;j<n+1;j++)
			{
				storage[i][j]=-1;
			}
		}
		for(int i=0;i<m+1;i++)
		{
			storage[i][0]=i;
		}
		for(int j=1;j<n+1;j++)
		{
			storage[0][j]=j;
		}
		for(int i=1;i<m+1;i++)
		{
			for(int j=1;j<n+1;j++)
			{
//				if(i==0)
//				{
//					storage[i][j]=j;
//				}
//				if(j==0)
//				{
//					storage[i][j]=i;
//				}
				if(s1.charAt(m-i)==s2.charAt(n-j))
				{
					storage[i][j]=storage[i-1][j-1];
				}
				else
				{
					storage[i][j]=1+Math.min(storage[i][j-1], Math.min(storage[i-1][j], storage[i-1][j-1]));
				}
			}
		}
		return storage[m][n];
	}
	
}

























