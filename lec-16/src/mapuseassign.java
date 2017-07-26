import java.util.HashMap;


public class mapuseassign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Largest substring with k unique char
		
		//		HashMap<Character,Integer> map=new HashMap<>();//unique characters
		//		String n="Missisippi";
		//		for(int i=0;i<n.length();i++)
		//		{
		//			map.put(n.charAt(i), 1);
		//		}
		//		System.out.println(map.keySet());
		//		HashMap<Integer,Integer> map=new HashMap<>();
		//		int a[]={5,1,9,3,8,20,4,10,2,11,3};
		//		for(int i:a)
		//		{
		//			if(map.containsKey(i-1) || map.containsKey(i+1))
		//			{
		//				if(map.containsKey(i-1) && map.get(i-1)<i)
		//				{
		//					map.put(i-1, i);
		//				}
		//				else 
		//				{
		//					map.put(i, map.get(i+1));
		//					map.remove(i+1);
		//				}
		//			}
		//			else
		//			{
		//				map.put(i, i);
		//			}
		//		}
		//		for(int i: map.keySet())
		//		{
		//			int valinc=map.get(i)+1;
		//			if(map.containsKey(valinc))
		//			{
		//				map.put(i, map.get(valinc));
		//				map.remove(i);
		//				map.remove(valinc);
		//			}
		//		}
		//		int max=Integer.MIN_VALUE;
		//		int index=-1;
		//		for(int i:map.keySet())
		//		{
		//			int max1=i-map.get(i);
		//			if(max<max1)
		//			{
		//				max=max1;
		//				index=i;
		//			}
		//		}
		//		System.out.println(index+","+map.get(index));
//
//		int a[]={5,1,9,3,8,20,4,10,2,11,3};
//		contiguous_rangesinarray(a);
		int[] a={1,1,1,2,3,3,5,5,6,7,9,9,9,9};
		maxfreq_sorted(a);
	}

public static void maxfreq_sorted(int[] a)
{
	int i=0;
	int index=a[0];
	int maxfreq=Integer.MIN_VALUE;
	while(i<=a.length-1)
	{
		int j=i+1;
		int cnt=1;
		while(j<=a.length-1 && a[j]==a[i])
		{
			cnt++;
			j++;
		}
		if(maxfreq<cnt)
		{
			maxfreq=cnt;
			index=a[i];
		}
		if(cnt>1)
		{
			i=j;
		}
		else
			i++;
	}
	System.out.println(index+","+maxfreq);
}
public static void maxfreq_unsorted(int[] a)
{
	int maxfreq=Integer.MIN_VALUE;
	int index=a[0];
	HashMap<Integer,Integer> map=new HashMap<>();
	for(int i:a)
	{
		if(!map.containsKey(i))
		{
			map.put(i, 1);
		}
		else
		{
			int value=map.get(i)+1;
			map.put(i, value);
			if(value>maxfreq)
			{
				maxfreq=value;
				index=i;
			}
		}
	}
	System.out.println(index+","+maxfreq);
}
public static void contiguous_rangesinarray(int[] a)
{
	HashMap<Integer,Integer> map=new HashMap<>();
	HashMap<Integer,Integer> visited=new HashMap<>();
	for(int i:a)
	{
		map.put(i, 1);
	}
	int range=Integer.MIN_VALUE;
	int index=Integer.MIN_VALUE;
	int u=0,l=0;
	for(int i:map.keySet())
	{
		if(!visited.containsKey(i))
		{
			int cnt=0;
			int up=0,down=0;
			visited.put(i, 1);
			int j=i;
			while(map.containsKey(++j) && !visited.containsKey(j))
			{
				visited.put(j, 1);
				cnt++;
				up++;
			}
			j=i;
			while(map.containsKey(--j) && !visited.containsKey(j))
			{
				visited.put(j, 1);
				cnt++;
				down++;
			}
			if(range<cnt)
			{
				range=cnt;
				index=i;
				u=up;
				l=down;
			}
		}
		
	}
	System.out.println((index-l)+","+(index+u));
}


}










