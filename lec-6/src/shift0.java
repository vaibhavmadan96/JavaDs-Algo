
public class shift0 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,0,2,0,0,-1};
		shift(arr);
		for(int i=0;i<arr.length;i++)
		System.out.println(arr[i]);
	}
	public static void shift(int[] arr)
	{
		int i=0,j=0;
		while(j<arr.length)
		{
			if(arr[j]!=0)
			{
				swap(arr,i,j);
				i++;
			}
			j++;
		}
	}
	public static void swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
