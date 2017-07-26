import java.util.ArrayList;


public class arrayli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a=getString("234");
		Display(a);
	}
	public static ArrayList<String> getString(String s)
	{
		ArrayList<String> firstchar=new ArrayList<String>();
		ArrayList<String> retval=new ArrayList<String>();
		switch(s.charAt(0))
		{
		case '2':
			firstchar.add("a");
			firstchar.add("b");
			firstchar.add("c");
			break;
		case '3':
			firstchar.add("d");
			firstchar.add("e");
			firstchar.add("f");
			break;
		case '4':
			firstchar.add("g");
			firstchar.add("h");
			firstchar.add("i");
			break;
		}
		if(s.length()==1)
			retval=firstchar;
		else
		{
			ArrayList<String> rest=getString(s.substring(1));
			for(int i=0;i<firstchar.size();i++)
			{
				for(int j=0;j<rest.size();j++)
				{
					retval.add(firstchar.get(i)+rest.get(j));
				}
			}
			
		}
		return retval;
	}
	public static void Display(ArrayList<String> a)
	{
		for(int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
	}
}
