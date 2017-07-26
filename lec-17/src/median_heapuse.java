
public class median_heapuse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		median_heap<Integer> heap=new median_heap<>();
		int[] a={1,2,3,4,5};
		for(int i:a)
		{
			heap.insert(i, i);
			System.out.println(heap.median());
		}
		System.out.println("");
		for(int i=0;i<a.length;i++)
		{
			heap.remove_median();
			System.out.println(heap.median());
		}
	}

}
