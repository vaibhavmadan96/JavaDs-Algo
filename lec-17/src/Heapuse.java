
public class Heapuse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={3,1,5,2,7,4,6};
		Heap<Integer> h=new Heap<>();
//		for(int i: a)
//		{
//			h.insert(i,i);
//		}
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.println(h.removeMin().value);
//		}
		
		
		//k almost sorted element
//		int k=3;
//		for(int i=0;i<k;i++)
//		{
//			h.insert(a[i],a[i]);
//		}
//		int j=0;
//		for(int i=k;i<a.length;i++)
//		{
//			a[j++]=(int)h.removeMin().value;
//			h.insert(a[i],a[i]);
//		}
//		for(int i=a.length;i<a.length+k;i++)
//		{
//			a[j]=(int)h.removeMin().value;
//			j++;
//		}
//		for(int i: a)
//		{
//			System.out.println(i+" ");
//		}
		
		
		
	//K-MAX ELEMENTS
		int k=3;
		for(int i=0;i<a.length;i++)
		{
			h.insert(a[i],a[i]);
		}
		for(int i=0;i<a.length;i++)
		{
			int temp=(int)h.removeMin().value;
			if(i>=a.length-k)
			System.out.println(temp);
		}
	}
	
	private static void addToVirtual()
	{
		
	}
	
}
