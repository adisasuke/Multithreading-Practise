package callables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<List<Integer>> {
	
	private int n;
	public ArrayCreator(int n)
	{
		this.n = n;
	}
	@Override
	public List<Integer> call()  {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
		{
			arr.add(i);
		}
		return arr;
	}
	
	

}
