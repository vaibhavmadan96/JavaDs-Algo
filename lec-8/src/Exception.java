import java.util.Scanner;


public class Exception {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flagcont=true;
		do{
		try{
		Scanner scn=null;//new Scanner(System.in);
		System.out.println("Plz Enter dividend\n");
		int dividend=scn.nextInt();
		System.out.println("Plz Enter divisor\n");
		int divisor=scn.nextInt();
		int quotient=dividend/divisor;
		System.out.println(quotient);
		flagcont=false;
		//scn.next();
		}
		catch(ArithmeticException ex)
		{
			System.out.println("Invalid divisor.Try again\n");
		}
		catch(NullPointerException npex)
		{
			System.out.println("ptr not initialised\n");
		}
		catch(Exception e)//handle all 
		{
			System.out.println("Some error happened");
		}

		}while(flagcont);
		try
		{
			fun3()
		}
		catch()
			
	}
	public static void Fun1()
	{
		System.out.println("1");
		System.out.println("2");
		fun2();
		System.out.println(fun2());
	}
	public static void fun3() throws IllegalAccessException
	{
		throw new IllegalAccessException();
	}
	class MyException extends Exception
	{
		public MyException()
		{
			super();
		}
		public MyException(String Message)
		{
			super(Message);
		}
	}
}
