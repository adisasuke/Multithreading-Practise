package Test;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class ReentrantLockExample {
	
	private int counter = 0;
	private Lock lock = new ReentrantLock();
	
	public void incrementCounter()
	{
		lock.lock();
		try {
			counter++;
		}
		finally {
			lock.unlock();
		}
	}
	
	public int getCounter()
	{
		return counter;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantLockExample ex = new ReentrantLockExample();
		
		
		for(int i=0;i<5;i++)
		{
			new Thread(() -> {
				for(int j=0;j<100;j++) {
					ex.incrementCounter();
				}
			}).start();
		 
		}// outer for loop
		
		int finalCounterValue = ex.getCounter();
		System.out.println(finalCounterValue);
	}

}
