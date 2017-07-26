
public class ImmobileEquip extends Equipment{

	private int weight;
	public int numberofWheels()
	{
		return this.weight;
	}
	public void printDetails()
	{
		super.printDetails();
		System.out.println("Number of wheels:"+this.weight);
	}
	public ImmobileEquip(String name,String desc,int weight)
	{
		super(name,desc);
		this.weight=weight;
	}
}
