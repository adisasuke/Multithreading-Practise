package Executors;

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
		Integer temparr[] = {12,34,78,2,23,423,5,21,344,5,5,61,6,82,345,2,235,6,622,78};
		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(temparr));
		MergeSort mg = new MergeSort(ex,arr);
		Future<List<Integer>> futureSortedArr = ex.submit(mg);
		List<Integer> sortedArray = futureSortedArr.get();
		
		System.out.println("Sorted array : " + sortedArray);
		
	}
	
	
}