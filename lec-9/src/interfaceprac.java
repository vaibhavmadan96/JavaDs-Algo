
public class interfaceprac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	interface IEngine
	{
		void Start();
	}
	class HyundaiEngine implements IEngine
	{
		public void Start()
		{
			System.out.println("Started with Hyund");
		}
	}
	class MarutiEngine implements IEngine
	{
		public void Start()
		{
			System.out.println("Started with Maruti");
		}
	}
	class Car
	{
		private IEngine engine;
		public void replaceEngine(IEngine engine)
		{
			this.engine=engine;
		}
		Car(IEngine engine)
		{
			this.engine=engine;
		}
		public void StartCar()
		{
			this.engine.Start();
		}
	}
}
