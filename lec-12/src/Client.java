import java.util.Random;
import java.util.Scanner;

import stacks.*;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Random rnd=new Random();
				queue<Integer> queue1 =new queue<>();
				for(int i=0;i<10;i++)
				{
					queue1.enqueue(rnd.nextInt(100));
					queue1.display();
				}
				
//				reverse(stack1);
//				stack1.display();
//				for(int i=0;i<10;i++)
//				{
//					System.out.println(queue1.front());
//					queue1.display();
//				}
				for(int i=0;i<11;i++)
				{
					System.out.println(queue1.dequeue());
					queue1.display();
				}
		//	}
		//		catch(StackFullException fEx)
		//		{
		//			System.out.println("Stack is full");
		//		}
		//		catch(StackEmptyException Ex)
		//		{
		//			System.out.println("Stack is empty");
		//		}
//		Scanner scn=new Scanner(System.in);
//		String s=scn.next();
//		boolean res = parenthes(s);
//		System.out.println(res);
		
	}
	public static boolean parenthes(String s)
	{
		stack<Character> stack1=new stack<>();		
		int i=0;
		while(i!=s.length())
		{
			if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(') {
				stack1.push(s.charAt(i));
				i++;
			}
			else if(s.charAt(i)=='}' || s.charAt(i)==']' || s.charAt(i)==')')	
			{
				char ch=stack1.pop();
				if((s.charAt(i)=='}' && ch=='{') ||(s.charAt(i)==']' && ch=='[') ||(s.charAt(i)==')' && ch=='(') )
				{
					i++;
				}
				else
					return false;

			}
			else
			{
				i++;
			}
		}
		if(!stack1.isEmpty())
			return false;
		else
			return true;

	}
//	public static void reverse(Queue<Integer> queue)
//	{
//		if(queue.isEmpty())
//			return;
//		int data=queue.dequeue();
//		reverse(queue);
//		queue.enqueqe(data);
//	}
	
}
