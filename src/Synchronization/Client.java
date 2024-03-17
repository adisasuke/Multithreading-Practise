package Synchronization;

import java.util.concurrent.Semaphore;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Shared sh = new Shared();
		Semaphore mutex = new Semaphore(1);
		
		Adder ad = new Adder(sh,mutex);
		Substractor st = new Substractor(sh,mutex);
		
		Thread t1 = new Thread(ad);
		Thread t2 = new Thread(st);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Value of shared data is : " + sh.data);

	}

}
