//
//public class Client {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub	
//		Student s=new Student();
//		s.Name="SM";
//		
//		s.Greeting();
//		Student s1=new Student();
//		s1.Name="SM";
//		s1.Greeting();
//		System.out.println(s==s1);//false addresses of string are stored therefore addresses are compared rather actual string
//		//s=s1;
//		//s1.Name="abc";
//		//System.out.println(s.Name);//abc print bcz s and s1 are alias
//		s.Name=s1.Name;//location is stored
//		s1.Name="Ns";//its address will now change
//		System.out.println(s.Name);
//		Fun(s);
//		
//		System.out.println(s.Name);//it cntains the address therefore Changes occur by reference
//		Fun1(s.Name);
//		System.out.println(s.Name);
//		Fun2(s);
//		System.out.println(s.Name);
//		s=Fun3(s);
//		System.out.println(s.Name);
//		
//		Student sohan=new Student();
//		Student mohan=new Student();
//		
//		sohan.Name="Sohan";
//		mohan.Name="Mohan";
//		
//		System.out.println(sohan.Name+", "+mohan.Name+", "+sohan.MaxStudent+", "+mohan.MaxStudent);
//		
//		//sohan.MaxStudent=60;
//		//mohan.MaxStudent=70;//bcz it was later made final
//		
//		System.out.println(sohan.Name+", "+mohan.Name+", "+sohan.MaxStudent+", "+mohan.MaxStudent);
//	}
//	public static void Fun(Student ss)
//	{
//		ss.Name="xyz";
//	}
//	public static void Fun1(String name)
//	{
//		name="ghi";
//	}
//	public static void Fun2(Student sss)
//	{
//		sss=new Student();//address is changed,changes made are not reflected back
//		sss.Name="New Student";
//	}
//	public static Student Fun3(Student sss)
//	{
//		sss=new Student();
//		sss.Name="New Student";
//		return sss;
//	}
//}
