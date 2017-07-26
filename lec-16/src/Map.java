import java.util.ArrayList;


public class Map<K,V> {
	private ArrayList<Node<MapPair<K,V>>> buckets;
	private int size;
	Map()
	{
		buckets=new ArrayList<>();
		for(int i=0;i<3;i++)
		{
			buckets.add(null);
		}
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public V get(K key)
	{
		if(this.isEmpty())
		{
			return null;
		}
		int t=this.getBucketIndex(key);
		Node<MapPair<K, V>> head=this.buckets.get(t);
		//Node<MapPair<K, V>> prev;
		while(head!=null)
		{
			if(head.data.key.equals(key))
			{
				return head.data.value;
			}
			head=head.next;
		}
		return null;
	}
	public void put(K key,V value)
	{
		Node<MapPair<K, V>> node=new Node<>();
		MapPair<K, V> newmpair=new MapPair<>(key,value);
		node.data=newmpair;
		
//		node.data.key=key;
//		node.data.value=value;
		int t=this.getBucketIndex(key);
		Node<MapPair<K, V>> head=this.buckets.get(t);
		
		if(head==null)
		{
			this.buckets.set(t,node);
			this.size++;
		}
		else{
			while(head.next!=null)
			{
				if(head.data.key.equals(key))
				{
					head.data.value=value;
					return;
				}
				
				head=head.next;
			}
			head.next=node;
			size++;
		}
		
		float lf=(float) (1.0*this.size/this.buckets.size());
		if(lf>0.75)
		{
			rehash();
		}
	}
	public void remove(K key)
	{
		if(this.isEmpty())
		{
			return;
		}
		int t=this.getBucketIndex(key);
		Node<MapPair<K, V>> head=this.buckets.get(t);
	
		Node<MapPair<K, V>> prev=null;
		if(head==null)
			return;
		if(head.data.key.equals(key))
		{
			head=head.next;
			this.buckets.set(t, head);
			size--;
			return;
		}
		while(head!=null)
		{
			if(head.data.key.equals(key))
			{
				prev.next=head.next;
				size--;
			}
			prev=head;
			head=head.next;
		}
	}
	public void rehash()
	{
		ArrayList<Node<MapPair<K,V>>> temp=this.buckets;
		buckets=new ArrayList<Node<MapPair<K,V>>>();
		this.size=0;
		for(int i=0;i<2*temp.size();i++)
		{
			buckets.add(null);
		}
		for(int i=0;i<temp.size();i++)
		{
			Node<MapPair<K, V>> head=temp.get(i);
			while(head!=null)
			{
				this.put(head.data.key, head.data.value);
				head=head.next;
			}
			
		}
	}
	public int getBucketIndex(K key)
	{
		int hashcode=key.hashCode();
		return hashcode%buckets.size();
	}
}
