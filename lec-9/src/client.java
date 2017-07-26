
public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Istack s=new newstack(5);
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println("");
		s.display();
	}

}
