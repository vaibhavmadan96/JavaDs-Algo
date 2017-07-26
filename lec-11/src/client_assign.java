import java.util.Scanner;



import singly.linkedlist;
public class client_assign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
//		linkedlist<Integer> list1=new linkedlist<>();
//		for(int i=0;i<5;i++)
//		{
//			list1.addLast(scn.nextInt());
//		}
//		//list1.elimin_dup();
//		System.out.println(list1);
////		list1.reverse_recur(list1.getHead());
////		System.out.println(list1);
//		list1.print_rev(list1.getHead());
//		list1.kappend(1);
//		System.out.println(list1);
//		linkedlist<Integer> list1=new linkedlist<>();
//		for(int i=0;i<6;i++)
//		{
//			list1.addLast(scn.nextInt());
//		}
//		//list1.test();
//		System.out.println(list1.palin());
//		linkedlist list1=new linkedlist();
//		for(int i=0;i<6;i++)
//		{
//			list1.addLast(scn.nextInt());
//		}
//		//list1.test();
//		list1.even_odd();
//		System.out.println(list1);
		linkedlist<Integer> list1=new linkedlist<>();
		for(int i=6;i>0;i--)
		{
			list1.addLast(i);
		}
		linkedlist<Integer> ll=list1.merge_sort1();
		System.out.println(ll);
//		linkedlist<Integer> s;
//		s=list1.merge_sort();
//		System.out.println(s);
	}

}
