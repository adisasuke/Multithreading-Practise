package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MergeSort<T extends Number>  implements Callable<List<T>> 
{
    
	private ExecutorService ex;
	private List<T> arr;
	MergeSort(ExecutorService ex,List<T> arr2)
	{
		this.ex = ex;
		this.arr = arr2;
	}
	
	@Override
	public List<T> call() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(Thread.currentThread().getName() );
		int n = arr.size();
		
		if(n<=1)
			return arr;
		
		int mid  = n/2;
		
		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();
		
		for(int i=0;i<mid;i++)
			left.add(arr.get(i));
		for(int i=mid;i<n;i++)
			right.add(arr.get(i));
	    
		
		MergeSort mg1 = new MergeSort(ex,left);
		MergeSort mg2 = new MergeSort(ex,right);
		
		Future<List<T>> leftSortedFuture = ex.submit(mg1);
		Future<List<T>> rightSortedFuture = ex.submit(mg2);
		
		ArrayList<T> leftSorted = (ArrayList<T>) leftSortedFuture.get();
		ArrayList<T> rightSorted = (ArrayList<T>) rightSortedFuture.get();
		ArrayList<T> arrSorted = new ArrayList<T>();
		
		int i=0;
		int j=0;
		int ln = leftSorted.size();
		int rn = rightSorted.size();
		
		
		while(i<ln && j<rn)
		{
			
			if( (leftSorted.get(i).doubleValue() <= rightSorted.get(j).doubleValue() ))
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