import java.util.ArrayList;
import java.util.HashMap;

//adjdiff adjacent elements of the array should belong to different arrays and array so formed
//shud be sorted
public class clientpractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={1,3};
		int[] b={2,4};
		System.out.println(adjdiff1(a,b));
//		String s="abcbcde";
//		System.out.println(longestSubstring(s));
	}

	private static String longestSubstring(String s) {
		// TODO Auto-generated method stub
		HashMap<Character,Integer> map=new HashMap<>();//store last occurrence while traversing
		//visited is invalid condition adjust fwdend
		//maintain window
		int curr_start=0,curr_end=0;
		int maxwindow_start=0,maxwindow_size=1;
		map.put(s.charAt(0), 0);
		for(int i=1;i<s.length();i++)
		{
			if(!map.containsKey(s.charAt(i)) || map.get(s.charAt(i))<curr_start)//imp condition
			{
				map.put(s.charAt(i), i);
				
			}
			else
			{
				curr_start=map.get(s.charAt(i))+1;
				map.put(s.charAt(i), i);
			}
			curr_end++;
			int curr_size=curr_end-curr_start+1;
			if(curr_size>maxwindow_size)
			{
				maxwindow_size=curr_size;
				maxwindow_start=curr_start;
			}
		}
		return s.substring(maxwindow_start, maxwindow_start+maxwindow_size);
	}

	private static ArrayList<ArrayList<Integer>> adjdiff1(int[] a, int[] b) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> al=new ArrayList<>();
		ArrayList<ArrayList<Integer>> al1=new ArrayList<>();
		ArrayList<ArrayList<Integer>> al2=new ArrayList<>();
		int i=0,j=0;
		while(i<a.length && j<b.length)
		{
			if(a[i]<b[j])
			{
				ArrayList<Integer> fa=new ArrayList<>();
				fa.add(a[i]);
				al1.add(fa);
				for(ArrayList<Integer> append:al2)
				{
					fa=new ArrayList<>();
					fa.addAll(append);
					fa.add(a[i]);
					al1.add(fa);
				}
				i++;
			}
			else
			{
				ArrayList<Integer> sa=new ArrayList<>();
				sa.add(b[j]);
				al2.add(sa);
				//System.out.println(al2);
				for(ArrayList<Integer> append:al1)
				{
					sa=new ArrayList<>();
					sa.addAll(append);
					sa.add(b[j]);
					al2.add(sa);
					//System.out.println(al2);
				}
				j++;
			}
		}
		while(i<a.length)
		{
			ArrayList<Integer> fa=new ArrayList<>();
			fa.add(a[i]);
			al1.add(fa);
			for(ArrayList<Integer> append:al2)
			{
				fa=new ArrayList<>();
				fa.addAll(append);
				fa.add(a[i]);
				al1.add(fa);
			}
			i++;
		}
		while(j<b.length)
		{
			ArrayList<Integer> sa=new ArrayList<>();
			sa.add(b[j]);
			al2.add(sa);
			//System.out.println(al2);
			for(ArrayList<Integer> append:al1)
			{
				sa=new ArrayList<>();
				sa.addAll(append);
				sa.add(b[j]);
				al2.add(sa);
				//System.out.println(al2);
			}
			j++;
		}
		al.add(null);
		al.addAll(al1);
		al.addAll(al2);
		return al;
	}
	
}
