package Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MergeSort  implements Callable<List<Integer>> 
{
    
	private ExecutorService ex;
	private List<Integer> arr;
	MergeSort(ExecutorService ex,List<Integer> arr)
	{
		this.ex = ex;
		this.arr = arr;
	}
	
	@Override
	public List<Integer> call() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(Thread.currentThread().getName() );
		int n = arr.size();
		
		if(n<=1)
			return arr;
		
		int mid  = n/2;
		
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		
		for(int i=0;i<mid;i++)
			left.add(arr.get(i));
		for(int i=mid;i<n;i++)
			right.add(arr.get(i));
	    
		
		MergeSort mg1 = new MergeSort(ex,left);
		MergeSort mg2 = new MergeSort(ex,right);
		
		Future<List<Integer>> leftSortedFuture = ex.submit(mg1);
		Future<List<Integer>> rightSortedFuture = ex.submit(mg2);
		
		ArrayList<Integer> leftSorted = (ArrayList<Integer>) leftSortedFuture.get();
		ArrayList<Integer> rightSorted = (ArrayList<Integer>) rightSortedFuture.get();
		ArrayList<Integer> arrSorted = new ArrayList<Integer>();
		
		int i=0;
		int j=0;
		int ln = leftSorted.size();
		int rn = rightSorted.size();
		
		
		while(i<ln && j<rn)
		{
			
			if(leftSorted.get(i).compareTo(rightSorted.get(j))<=0)
			{
				arrSorted.add(leftSorted.get(i));
		        i++;
			}
			else
			{
				arrSorted.add(rightSorted.get(j));
				j++;
			}
			
		}
		
		
		while(i<ln)
		{
			arrSorted.add(leftSorted.get(i));
	        i++;
		}
		while(j<rn)
		{
			arrSorted.add(rightSorted.get(j));
			j++;
		}
		
		
		
		return arrSorted;
	}

	
	
}