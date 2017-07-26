import p1.*;//imports only classes
import p1.p2.*;
//import Generics.p1.*;
//import p2.C1;
//import Generics.*;
import Generics.Stack;
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p1.C1 obj=new p1.C1();
		C1 obj1=new C1();
		C2 obj3=new C2();
		C3 obj4=new C3();
//		Demo1<String> genString=new Demo1("Hi there");
//		Demo1<String> genString1=new Demo1("Hi there");
//		Demo1<Integer> genInt=new Demo1(1);
		//genString=genInt;
//		Demo2<String,Integer> pops=new Demo2<>();
//		pops.add("India",100);
//		pops.add("China",200);
//		System.out.println(pops.get("India"));
//		System.out.println(pops.get("xyz"));
		Stack<Employee> stack=new Stack();
		for(int i=0;i<10;i++)
		{
			stack.push(new Employee(i,"i"));
		}
		stack.display();
	}

}
class Employee implements Comparable<Employee>
{
	int Id;
	String Name;
	public Employee(int id,String Name)
	{
		this.Id=id;
		this.Name=Name;
	}
	public int compareTo(Employee po)
	{
		return this.Id-po.Id;
	}
	public String toString()
	{
		return "Id-"+this.Id;
	}
}