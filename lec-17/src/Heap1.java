import java.util.ArrayList;


public class Heap1<V> {
	ArrayList<PQPair<Integer,V>> data;
	Heap1()
	{
		data=new ArrayList<>();
	}
	public boolean isEmpty()
	{
		return data.size()==0;
	}
	public int size()
	{
		return data.size();
	}
	public V max()
	{
		return data.get(0).value;
	}
	public void insert(Integer priority,V value)
	{
		PQPair<Integer,V> pq=new PQPair<>();
		pq.priority=priority;
		pq.value=value;
		data.add(pq);
		if(data.size()==1)
		{
			return;
		}
		
		int childindex=data.size()-1;
		int parindex=(childindex-1)/2;
		
		while(childindex>0)
		{
			PQPair<Integer,V> pqchild=data.get(childindex);
			PQPair<Integer,V> pqpar=data.get(parindex);
			if(pqpar.priority<pqchild.priority)
			{
				//swap
				PQPair<Integer,V> temp=pqchild;
				data.set(childindex,data.get(parindex));
				data.set(parindex, temp);
				
				childindex=parindex;
				parindex=(childindex-1)/2;
			}
			else
			{
				break;
			}
		}
	}
	public PQPair<Integer,V> removeMax()
	{
		if(isEmpty()){
			return null;
		}
		PQPair<Integer,V> temp=data.get(0);
		data.set(0, data.get(data.size()-1));
		data.remove(data.size()-1);
		
		if(this.data.size() > 1){
			downheapify(0);
		}
		return temp;
	}
	private void downheapify(int index)
	{
		int lindex=2*index+1;
		int rindex=2*index+2;
		if(lindex>data.size()-1)
		{
			return;
		}
		int minindex=index;
		if(data.get(minindex).priority<data.get(lindex).priority)
		{
			minindex=lindex;
		}
		if(rindex<=data.size()-1 && data.get(minindex).priority<data.get(rindex).priority)
		{
			minindex=rindex;
		}
		if(minindex!=index)
		{
			PQPair<Integer,V> temp=data.get(minindex);
			data.set(minindex, data.get(index));
			data.set(index, temp);
			this.downheapify(minindex);
		}
	}
}