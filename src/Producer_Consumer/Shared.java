package Producer_Consumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Shared {
	private Queue<Integer> q;
	
	Shared()
	{
		this.q = new ConcurrentLinkedQueue<Integer>();
	}
	
	
	public void remove()
	{
		q.remove();
	}
	
	public void set(Integer i)
	{
		q.add(i);
	}
	
	public int get()
	{
		return q.element();
	}
	
}
