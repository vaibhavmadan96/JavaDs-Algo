
public class quicksort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,9,2,8,3,7,4,6,5,10};
		Quicksort(arr,0,arr.length-1);
		Display(arr);
	}
//	public static void Quicksort(int[] arr,int sI,int lI)
//	{
//		if(arr.length==0)
//		{
//			return;
//		}
//		int low=sI,high=lI;
//		int pI=(sI+lI)/2;
//		int pivot=arr[pI];
//		int i=sI,j=lI;
//		while(sI<=lI)
//		{
//			while(arr[i]<pivot)
//			{
//				sI++;
//			}
//			while(arr[j]>pivot)
//			{
//				lI--;
//			}
//			if(sI<=lI)
//			{Swap(arr,sI,lI);
//			sI++;
//			lI--;}
//			
//		}
//		if(lI>low)
//		{
//			Quicksort(arr,low,lI);
//		}
//		if(sI<high)
//		{
//			Quicksort(arr,sI,high);
//		}
//	}
	public static void Quicksort(int[] arr,int lo,int hi)
	{
		int p=(lo+hi)/2,i=lo,j=hi;
		int pivot=arr[p];
		while(i<=j)
		{
			while(arr[i]<pivot)
				i++;
		while(arr[j]>pivot)
				j--;
		if(i<=j)//do not swap if i has exceeded j
		{
			Swap(arr,i,j);
			i++;
			j--;
		}
		}
		if(i<hi)
			Quicksort(arr,i,hi);
		if(j>lo)
			Quicksort(arr,lo,j);
			
		
	}
	public static void Swap(int[] arr,int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void Display(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
				
	}
}
