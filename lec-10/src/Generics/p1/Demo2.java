package Generics.p1;

import java.util.ArrayList;

public class Demo2<K,V> {
	ArrayList<K> keys;
	ArrayList<V> value;
	public Demo2()
	{
		this.keys=new ArrayList<>();
		this.value=new ArrayList<>();
	}
	public void add(K key,V value)
	{
		int counter=-1;
		for(int i=0;i<this.keys.size();i++)
		{
			if(this.keys.get(i).equals(key))
			{
				counter=i;
				break;
			}
			counter++;
		}
		if(counter==-1)
		{
			this.keys.add(key);
			this.value.add(value);
		}
		else
		{
			System.out.println("Key already exists");
		}
		
	}//equals func also override
	public V get(K key)
	{
		int counter=-1;
		for(int i=0;i<this.keys.size();i++)
		{
			if(this.keys.get(i).equals(key))
			{
				counter=i;
				break;
			}
			counter++;
		}
		if(counter==-1)
		{
			throw new RuntimeException("Key not found");
		}
		else
			return this.value.get(counter);
	}
}
