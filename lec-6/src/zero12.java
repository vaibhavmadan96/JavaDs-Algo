
public class zero12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,0,2,0,0,1,2,1,0,2,1};
		shift(arr);
		for(int i=0;i<arr.length;i++)
		System.out.println(arr[i]);
	}
	public static void shift(int[] arr)
	{
		int low=0,mid=0;
		int high=arr.length-1;
		while(mid<=high)
		{
			if(a[mid]==2)
			{
				swap(arr,mid,hi);
				hi--;
			}
			else if(a[mid]==0)
			{
				swap(arr,mid,low)
				low++;
				mid++;
			}
			else
				mid++;
				
		}
	}
	public static swap
}
