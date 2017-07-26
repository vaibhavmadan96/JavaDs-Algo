
public class Newclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s=new Student("SM");
		Student s1=new Student(s);//new means another memory area is captured
		Student s2=s;
		System.out.println(s==s1);
		System.out.println(s==s2);
	}

}
