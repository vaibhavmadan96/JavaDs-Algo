import java.util.Date;


public class Student {//java gives adefaut constr
	
	private String Name;
	public static final int MaxStudent=50;//final->const
	public static int greetingcounter=0;
	public static int getgreetingcunter()
	{
		return greetingcounter;
	}
	public int GetMaxStudent()
	{
		return 
	}
	public String getName()
	{
		return this.Name;
	}
	public final Date Doj;
	private void setName(String Name)
	{
		if(Name.length()!=0)
		{
			this.Name=Name;
		}
		else
		{
			//exception
		}
	}
	public Student(Student another)
	{
		this.setName(another.Name);
		this.Doj=another.Doj;
	}
	public Student(String Name)
	{
		this.setName(Name);
		this.Doj=new Date();
	}
	/*public int get_Age()
	{
		return this.Age;
	}*/
	public void Greeting()
	{
		System.out.println("Hi there "+Name);
	}
}
