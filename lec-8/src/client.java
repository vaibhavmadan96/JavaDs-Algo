import java.util.Scanner;


public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Equipment e=new Equipment("E1","This is E1");
//		e.printDetails();
		MobileEquip me=new MobileEquip("me1","This is me1",4);
		me.printDetails();
		System.out.println("Enter 1 to create mobile, 2to create immobile");
		Scanner scn=new Scanner(System.in);
		int type=scn.nextInt();
		Equipment temp;
		if(type==1)
		{
			temp=new MobileEquip("Abcd","This is abcd",4);
		}
		else
		{
			temp=new ImmobileEquip("Dfe", "This is Dfe", 30);
		}
		temp.printDetails();
	}
	public static void printDetails(Equipment eq)
	{
		eq.printDetails();
	}
	CheckDefaultInherit obj=new CheckDefaultInherit();
	System.out.println(obj);//returns tostring func ie class name+address of obj if tostring is not overriden
}

class CheckDefaultInherit
{
	
}