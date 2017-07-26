
public class oldstack implements Istack {


	private int[] arr;
	private int top=-1;
	oldstack(int l)
	{
		arr=new int[l];
	}
	public void push(int a)
	{
		if(top==arr.length-1)
		{
			System.out.println("Overflow\n");
		}
		else
		{
			top++;
			arr[top]=a;
			System.out.println("Element pushed\n");
		}
		
	}
	public int pop()
	{
		int temp=-1;
		if(top==-1)
			{
			System.out.println("Underflow\n");
			
			}
		
		else
		{
			temp=arr[top];
			//System.out.println(arr[top]+"deleted\n");
			top--;
		}
		return temp;
	}
	public void display()
	{
		if(top==-1)
			System.out.println("Stack empty\n");
		else
		{
			for(int i=top;i>=0;i--)
			System.out.println(arr[i]);
		}
	}
}

interface  Istack
{
	void push(int item);
	int pop();
	void display();
}
