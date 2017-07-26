import java.util.HashMap;


public class Mapuse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Map<String,Integer> m=new Map<>();
//		m.put("abc", 1);
//		m.put("def", 2);
//		m.put("ghi", 3);
//		m.put("ijk", 3);
//		System.out.println(m.get("abc"));
//		System.out.println(m.get("def"));
//		m.remove("abc");
//		System.out.println(m.get("abc"));
		HashMap<Integer,Integer> map=new HashMap<>();
		int arr1[]={3,3,-3};
		int arr2[]={3,-3};//every element of arr2 utilises every element of arr1 whiech is equivalent
		//to its absolute value
		
		for(int i: arr1)
		{
			if(!map.containsKey(i))
				map.put(i, 1);
			else
			{
				map.put(i, map.get(i)+1);
			}
		}
		HashMap<Integer,Integer> map1=new HashMap<>();
		for(int i:map.keySet())
		{
			map1.put(i, map.get(i));
		}
		for(int i: arr2)
		{
			if(i>=0)
			{
				while(map.get(i)>0)
				{
					System.out.println(i+","+i);
					map.put(i, map.get(i)-1);
				}
				while(map.get(-i)>0)
				{
					System.out.println(i+","+(-i));
					map.put(-i, map.get(-i)-1);
				}
			}
			else
			{
				while(map1.get(i)>0)
				{
					System.out.println(i+","+i);
					map1.put(i, map1.get(i)-1);
				}
				while(map1.get(-i)>0)
				{
					System.out.println(i+","+(-i));
					map1.put(-i, map1.get(-i)-1);
				}
			}
			
		}
//		for(int i: arr2)
//		{
//			if(i>0)
//			{
//				if(map.containsKey(-i))
//				{
//					
//					System.out.println(i+","+-i);
//				}
//			}
//			
//		}
	}
//		for(int i: arr1)//print distinct values
//		{
//			map.put(i, 1);
//		}
//		System.out.println(map.keySet());
			
		
//		for(int i: arr1)//print intersection
//		{
//			if(!map.containsKey(i))
//			{
//				map.put(i, 1);
//			}
//			else
//			{
//				map.put(i, map.get(i)+1);
//			}
//		}
//		for(int i: arr2)
//		{
//			if(map.containsKey(i))
//			{
//				if(map.get(i)>0)
//				{
//					System.out.println(i);
//					map.put(i, map.get(i)-1);
//				}
//				
//			}
//		}
//	}
//	public void intersection(int[] a,int[] b)
//	{
//		Map<Integer,boolean> m1=new Map<>();
//		if(a.length<b.length)
//		{
//			for(int i=0;i<a.length;i++)
//			{
//				m1.put(a[i], true);
//			}
//		}
//	}
}
