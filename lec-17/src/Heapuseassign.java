
public class Heapuseassign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr={ {1, 3, 5, 7},
				{2, 4, 6, 8},
				{0, 9, 10, 11}};
		mergeKarray(arr);
	}
	public static void mergeKarray(int[][] arr)
	{
		int size=arr[0].length*arr.length;
		int b[]=new int[size];
		Heap<Integer> heap=new Heap<>();

		for(int i=0;i<arr.length;i++)
		{
			heap.insert(arr[i][0], i);
		}
		int k=0;
		while(k<size)
		{
			int val=heap.min();
			b[k]=heap.removeMin().priority;
			int j;
			for(j=0;j<arr[0].length;j++)
			{
				if(b[k]==arr[val][j])
				{
					break;
				}
			}
			if(j<arr[0].length-1)
			{
				heap.insert(arr[val][j+1], val);
			}
			else
			{
				heap.insert(Integer.MAX_VALUE, val);
			}
			k++;
		}
		for(int i:b)
		{
			System.out.print(i+",");
		}
	}
}
