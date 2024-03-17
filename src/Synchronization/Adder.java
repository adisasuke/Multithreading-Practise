package Synchronization;

import java.util.concurrent.Semaphore;

public class Adder implements Runnable {

	private Shared sh;
	private Semaphore mutex;
	
	Adder(Shared sh,Semaphore mutex)
	{
		this.sh = sh;
		this.mutex = mutex;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<1000000;i++)
		{
			try {
				mutex.acquire();
				sh.data += 1;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				mutex.release();
			}
			
			
		}
	}
	

}
