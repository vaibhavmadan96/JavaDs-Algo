
public class exception1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		boolean flagContinue = true;
//		
//		do
//		{
//			try{
//				Scanner scn = null;// = new Scanner(System.in);
//				
//				System.out.println("Please enter the dividend - ");
//				int dividend = scn.nextInt();
//				
//				System.out.println("Please enter the divisor - ");
//				int divisor = scn.nextInt();
//				
//				int quotient = dividend / divisor;
//				System.out.println(quotient);
//				
//				flagContinue = false;
//			}
//			catch(ArithmeticException aex){
//				System.out.println("Invalid divisor. Try again.");
//			}
//			catch(NullPointerException npEx){
//				System.out.println("Pointer not initialized. Fix your code and try again.");
//				flagContinue = false;
//			}
//			catch(Exception ex){
//				System.out.println("Some error happened!");
//			}
//
//		}while(flagContinue);
		
		try{
			System.out.println("Main => Line 1");
			Fun1();
			System.out.println("Main => Line 3");
			Fun3();
		}
		catch(Exception ex){
			//ex.printStackTrace(System.out);
			System.out.println("Fun1 reported the error " + ex);
		}
//		
//		Fun1();
//		Fun3();
	}
	
	

//	public static int TakeInputAndDivide(){
//		Scanner scn = new Scanner(System.in);
//		
//		System.out.println("Please enter the dividend - ");
//		int dividend = scn.nextInt();
//		
//		System.out.println("Please enter the divisor - ");
//		int divisor = scn.nextInt();
//		
//		return Divide(dividend, divisor);
//	}
//	
//	public static int Divide(int dividend, int divisor){
//		return dividend / divisor;
//	}
	
	public static void Fun1(){
		try{
			System.out.println("Fun1 => Line 1");
			System.out.println("Fun1 => Line 2");
			System.out.println(Fun2());
			System.out.println("Fun1 => Line 4");
			System.out.println("Fun1 => Line 5");
		}
		catch(NullPointerException nex){
			System.out.println("Fun2 reported the error " + nex);
		}
	}
	
	public static int Fun2(){
		try{
			System.out.println("Fun2 => Line 1");
			System.out.println("Fun2 => Line 2");
			int a = 2 / 0;
			System.out.println("Fun2 => Line 4");
			System.out.println("Fun2 => Line 5");
			return 1;
		}
		catch(ArithmeticException ex){
			System.out.println("A divide by zero attempted");
			//throw ex;
			throw new MyException();
			//throw new ArithmeticException("Somebody attempted a divide by zero");
			
		}
		finally{
			System.out.println("Hi there!");
//			obj.toString();

			//return 2;
		}
	}
	
	public static void Fun3() throws IllegalAccessException{
		if(1 == 1){
			throw new IllegalAccessException();
		}
	}
}

class MyException extends Exception{
	public MyException(){
		this("");
	}
	
	public MyException(String message){
		super(message);
	}
}
