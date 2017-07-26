
public abstract class Equipment {//object can't be made
	private String name;
	private String desc;
	private int maintenanceCost=0;
	//private int Distance
	public String getName()
	{
		return this.name;
	}
	private void setname(String name)
	{
		if(name.length()>0)
		{
			this.name=name;
		}
		else
		{
			//except
		}
	}
	public String getDescrip()
	{
		return this.desc;
	}
	private void setDescrip(String desc)
	{
		this.desc=desc;
	}
	public int getMaint()
	{
		return this.maintenanceCost;
	}
	public Equipment(String name,String desc)
	{
		this.setname(name);
		this.setDescrip(desc);
	}
		public void printDetails()
	{
		System.out.println("Name :"+this.name);
		System.out.println("Description :"+this.desc);
		System.out.println("Maintenance Cost Til Date :"+this.maintenanceCost);
	}
		public abstract void Move(int d);
		public boolean 
}
