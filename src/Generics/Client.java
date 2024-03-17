package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class Client
{
	
	public static void main(String args[]) throws InterruptedException, ExecutionException
	{
		
		ExecutorService ex = Executors.newCachedThreadPool();
		Double temparr[] = {12.0,2.5,6.8,9.4,3.4,2.8,7.5};
		List<Double> arr = new ArrayList<Double>(Arrays.asList(temparr));
		
		MergeSort<Double> mg = new MergeSort<Double>(ex,arr);
		Future<List<Double>> futureSortedArr = ex.submit(mg);
		List<Double> sortedArray = futureSortedArr.get();
		
		System.out.println("Sorted array : " + sortedArray);
		
	}
	
	
}