import java.util.ArrayList;


public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,3};
		int[] b={2,4};
		System.out.println(adjdiff1(a,b));
		
		
//		String s="ababcde";
//		System.out.println(longestSubstring(s));
		
	}//next q return arrayli of arrayli
	public static ArrayList<ArrayList<Integer>> adjdiff1(int[] a,int[] b)
	{
		ArrayList<ArrayList<Integer>> al=new ArrayList<>();
		ArrayList<ArrayList<Integer>> al1=new ArrayList<>();
		ArrayList<ArrayList<Integer>> al2=new ArrayList<>();
		int i=0,j=0;
		while(i!=a.length && j!=b.length)
		{
			ArrayList<Integer> l=new ArrayList<Integer>();
			if(a[i]<b[j])
			{
				l.add(a[i]);
				al1.add(l);
				for (ArrayList<Integer> list : al2)
				{
					l=new ArrayList<Integer>();
				    for (Integer num : list)
				    {
				    	l.add(num);
				    }
				    l.add(a[i]);
				    al1.add(l);
				}
				
				i++;
			}
			else
			{
				l.add(b[j]);
				al2.add(l);
				for (ArrayList<Integer> list : al1)
				{
					l=new ArrayList<Integer>();
				    for (Integer num : list)
				    {
				    	l.add(num);
				    }
				    l.add(b[j]);
				    al2.add(l);
				}
				j++;
			}
		}
		while(i!=a.length)
		{
			ArrayList<Integer> l=new ArrayList<Integer>();
			l.add(a[i]);
			al2.add(l);
			for (ArrayList<Integer> list : al2)
			{
				l=new ArrayList<Integer>();
			    for (Integer num : list)
			    {
			    	l.add(num);
			    }
			    l.add(a[i]);
			    al1.add(l);
			}
			
			i++;
		}
		while(j!=a.length)
		{
			ArrayList<Integer> l=new ArrayList<Integer>();
			l.add(b[j]);
			al2.add(l);
			for (ArrayList<Integer> list : al1)
			{
				l=new ArrayList<Integer>();
			    for (Integer num : list)
			    {
			    	l.add(num);
			    }
			    l.add(b[j]);
			    al2.add(l);
			}
			j++;
		}
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(null);
		al.add(l);
		al.addAll(al1);
		al.addAll(al2);
		return al;
	}
	public static int adjdiff(int[] a,int[] b)
	{
		int i=0,j=0,endingwithfirst=0,endingwithsecond=0;
		while(i!=a.length && j!=b.length)
		{
			if(a[i]<b[j])
			{
				endingwithfirst+=1+endingwithsecond;
				i++;
			}
			else
			{
				endingwithsecond+=1+endingwithfirst;
				j++;
			}
		}
		while(i!=a.length)
		{
			endingwithfirst+=1+endingwithsecond;
			i++;
		}
		while(j!=a.length)
		{
			endingwithsecond+=1+endingwithfirst;
			j++;
		}
		
		return endingwithfirst+endingwithsecond+1;
	}
	public static String longestSubstring(String s)//with all unique alphabets
	{
		int[] lastind=new int[256];
		for(int i=0;i<lastind.length;i++)
		{
			lastind[i]=-1;
		}
		int MSS=0,MSE=0,CSS=0;//maxsubstring start,end; current substring start
		for(int i=0;i<s.length();i++)
		{
			int lastindexofchar=lastind[s.charAt(i)];
			if(lastindexofchar>=CSS)
			{
				int sizeofMS=MSE-MSS+1;
				int sizeofCS=i-CSS;
				if(sizeofMS<sizeofCS)
				{
					MSS=CSS;
					MSE=i-1;
				}
				CSS=lastindexofchar+1;
			}
			lastind[s.charAt(i)]=i;
		}
			int sizeofMS=MSE-MSS+1;
			int sizeofCS=s.length()-1-CSS;
			if(sizeofMS<sizeofCS)
			{
				MSS=CSS;
				MSE=s.length()-1;
			}
			return s.substring(MSS, MSE+1);
	}

	
	
}
