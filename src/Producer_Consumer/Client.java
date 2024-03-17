package Producer_Consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaphore producer = new Semaphore(5);
		Semaphore consumer = new Semaphore(0);
		
		ExecutorService ex = Executors.newCachedThreadPool();
		Shared s = new Shared();
		for(int i=0;i<3;i++)
		{
			Producer p = new Producer(producer,consumer,i,s);
			ex.submit(p);
		}
		
		for(int i=0;i<100;i++)
		{
			Consumer c = new Consumer(producer,consumer,i,s);
			ex.submit(c);
		}

	}

}
