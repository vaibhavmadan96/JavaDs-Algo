
public class median_heap<V> {
	private Heap<V> minheap;
	private Heap1<V> maxheap;
	median_heap()
	{
		minheap=new Heap<>();
		maxheap=new Heap1<>();
	}
	public void insert(int priority,V value)
	{
		if(minheap.isEmpty() && maxheap.isEmpty())
		{
			minheap.insert(priority, value);
		}
		//keep sizes balanced ie difference of sizes 1/0
		else if(priority>(Integer)this.median())
		{
			minheap.insert(priority, value);
		}
		else
		{
			maxheap.insert(priority, value);
		}
		int diff=maxheap.size()-minheap.size();
		if(diff>1)
		{
			while(diff>1)
			{
				PQPair<Integer,V> pair=maxheap.removeMax();
				minheap.insert(pair.priority, pair.value);
				diff--;
			}
		}
		else if(diff<-1)
		{
			while(diff<-1)
			{
				PQPair<Integer,V> pair=minheap.removeMin();
				maxheap.insert(pair.priority, pair.value);
				diff++;
			}
		}
	}
	public V median()
	{
		if(minheap.isEmpty() && maxheap.isEmpty())
		{
			return null;
		}
		else if(maxheap.isEmpty())//put 1st elmnt minheap
		{
			return minheap.min();
		}
		else if(minheap.size()==maxheap.size())
		{
			return minheap.min();//by default
		}
		else if(minheap.size()>maxheap.size())
		{
			return minheap.min();
		}
		else 
		{
			return maxheap.max();
		}
		
	}
	public void remove_median()
	{
		if(minheap.isEmpty() && maxheap.isEmpty())
		{
			return;
		}
		else if(maxheap.isEmpty())//put 1st elmnt minheap
		{
			minheap.removeMin();
		}
		else if(minheap.size()==maxheap.size())
		{
			 minheap.removeMin();//by default
		}
		else if(minheap.size()>maxheap.size())
		{
			 minheap.removeMin();
		}
		else 
		{
			 maxheap.removeMax();
		}
	}
}
 