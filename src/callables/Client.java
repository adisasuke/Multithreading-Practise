package callables;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        ExecutorService ex = Executors.newFixedThreadPool(1);
        ArrayCreator ac = new ArrayCreator(n);
        Future<List<Integer>> arrfuture = ex.submit(ac);
        List<Integer> arr = arrfuture.get();
        
        	System.out.println(arr);
        
        
	}

}
