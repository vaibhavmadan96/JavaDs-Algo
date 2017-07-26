
public class MobileEquip extends Equipment {

	private int numberofwheels;
	public int numberofWheels()
	{
		return this.numberofwheels;
	}
	public void printDetails()
	{
		super.printDetails();//first line only
		System.out.println("Number of wheels:"+this.numberofwheels);
	}
	public MobileEquip(String name,String desc,int numberofwheels)
	{
		super(name,desc);
		this.numberofwheels=numberofwheels;
	}
	public void Move(int distance)
	{
		
	}
}
