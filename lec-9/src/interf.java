
public class interf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C obj=new C();
		I2 objI2=new C();
		I1 objI1=new C();
		I3 bj=new C();
		objI2.F1();
	}

}
interface I1
{
	void F1();
	void F2();
}
interface I2 extends I1
{
	void F3();
}
interface I3
{
	void F3();
}
class C implements I2,I3
{
	public void F1()
	{
		
	}
	public void F2()
	{
		
	}
	public void F3()
	{
		
	}
}