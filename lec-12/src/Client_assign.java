import java.util.Random;

import llist.*;


public class Client_assign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Random rnd=new Random();
//		minstack<Integer> stack1 =new minstack<>();
//		for(int i=0;i<10;i++)
//		{
//			stack1.push(rnd.nextInt(100));
//		
//		}
//		stack1.display();
//		
//			System.out.println(stack1.top());
//			stack1.display();
//		
////		for(int i=0;i<11;i++)
////		{
////			System.out.println(stack1.pop());
////			stack1.display();
////		}
//		System.out.println(stack1.min1());
		int[] a={100,60,70,65,110,120};
		System.out.println(stockspan(a));
	}
	//push no
	//if next no is greater pop earlier
	//if next no is smaller push
	public static int stockspan(int[] a)
	{
		stack<Integer> s=new stack<>();
		int[] span=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			if(s.isEmpty())
				{
					s.push(i);
					span[i]=i+1;
				}
			else
			{
				while(!s.isEmpty() && a[s.top()]<a[i])
				{
					s.pop();
				}
				if(s.isEmpty())
				{
					span[i]=i+1;
				}
				else
					span[i]=i-s.top();
				s.push(i);
				
			}
		}
		int max=span[0];
		for(int i=0;i<a.length;i++)
		{
			System.out.print(span[i]+" ");
			if(max<span[i])
			{
				max=span[i];
			}
		}
		System.out.println(" ");
		return max;
	}
}
