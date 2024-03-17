package Producer_Consumer;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
	
	private Semaphore p;
	private Semaphore c;
	private int name;
	private Shared s;
	
	Consumer(Semaphore p,Semaphore c,int name,Shared s)
	{
		this.p = p;
		this.c = c;
		this.name = name;
		this.s = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
				try {
					c.acquire();
					System.out.println("Consumer : "+ name + " is removing item  " + s.get() + " from the queue");
					s.remove();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					p.release();
				}
			
		}
	}
	
	
 }
