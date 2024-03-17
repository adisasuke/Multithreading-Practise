package Iterator;

import java.util.Iterator;
import java.util.List;

public class PalindromIterator implements Iterator<String> {

	
	private List<String> l;
	private int currentcounter = 0;
	
	public PalindromIterator(List<String> l) {
		// TODO Auto-generated constructor stub
		this.l = l;
	}
	
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		for(int i=currentcounter;i<l.size();i++)
		{
			if(isPalindrom(l.get(i)) )
				return true;
		}
		return false;
	}

	@Override
	public String next() {
		// TODO Auto-generated method stub
		for(int i=currentcounter;i<l.size();i++)
		{
			if(isPalindrom(l.get(i)) )
			{
				String s = l.get(i);
				currentcounter++;
				return s;
			}
		}
		return null;
	}
	
	
	
	private static boolean isPalindrom(String s)
	{
		int n = s.length();
		int i = 0;int j = n-1;
		
		while(i < j)
		{
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		
		return true;
	}
	
	

}
