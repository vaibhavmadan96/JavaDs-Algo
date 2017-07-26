package Generics;

import java.util.ArrayList;

import Generics.p1.T;

public class Stack<T extends Comparable<T> /* &IFun*/> {//only those T which extends Comparable
	ArrayList<T> a1;						//IFun is another interface which must be implemented by T
	private int top=-1;
	public Stack()
	{
		a1=new ArrayList<T>();
	}
	public void push(T a)
	{
//		if(top==arr.length-1)
//		{
//			int[] temp=arr;
//			arr=new int[2*arr.length];
//			for(int i=0;i<temp.length;i++)
//			{
//				arr[i]=temp[i];
//			}
//			top++;
//			arr[top]=a;
//			//System.out.println("Element pushed\n");
//		}
//		else
//		{
//			top++;
//			arr[top]=a;
//			//System.out.println("Element pushed\n");
//		}
		top++;
		a1.add(a);
	}
	public T pop()
	{
		T temp;
		if(top==-1)
			{
			throw new RuntimeException("Underflow");
			
			}
		
		else
		{
			temp=a1.get(top);
			//System.out.println(arr[top]+"deleted\n");
			a1.remove(top);//add
			top--;
			return temp;
		}
		
	}
	public void display()
	{
		if(top==-1)
			System.out.println("Stack empty\n");
		else
		{
			for(int i=top;i>=0;i--)
			System.out.println(a1.get(i));
		}
	}
	public T max()
	{
		T retval=this.a1.get(0);
		 for(int i=0;i<=this.top;i++)
		 {
			 T current=this.a1.get(i);
			 if(retval.compareTo(current)<0)
				 retval=current;
		 }
		 return retval;
	}
}
