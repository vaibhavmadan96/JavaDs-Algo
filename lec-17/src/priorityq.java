
public class priorityq<V> {
	Heap<V> heap;
	priorityq()
	{
		heap=new Heap<>();
	}
	public int size()
	{
		return heap.size();
	}
	public boolean isEmpty()
	{
		return heap.size()==0;
	}
	public V front()
	{
		return heap.min();
	}
	public void enqueue(int priority,V value)
	{
		heap.insert(priority, value);
	}
	public PQPair dequeue()
	{
		return heap.removeMin();
	}
}
