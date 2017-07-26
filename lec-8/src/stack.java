
public class stack {
	private int[] arr;
	private int top=-1;
	stack(int l)
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
	public void pop()
	{
		if(top==-1)
			System.out.println("Underflow\n");
		else
		{
			System.out.println(arr[top]+"deleted\n");
			top--;
		}
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
