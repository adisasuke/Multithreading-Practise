package Producer_Consumer;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
	
	private Semaphore p;
	private Semaphore c;
	private int name;
	private Shared s;
	
	Producer(Semaphore p,Semaphore c,int name,Shared s)
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
			for(int i=1;i<=5;i++)
			{
				try {
					p.acquire();
					System.out.println("Producer : "+ name + " is adding item  " + i + " in the queue");
					s.set(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					c.release();
				}
			}
			
		}
	}
	
	
 }
