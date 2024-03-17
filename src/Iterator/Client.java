package Iterator;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<String>();
		arr.add("Adi");
		arr.add("AdA");
		arr.add("IRI");
		arr.add("Ad");
		arr.add("Ai");
		PalindromIterator pt = new PalindromIterator(arr);
		
		
		while(pt.hasNext())
		{
			System.out.println(pt.next());
		}
		
	}

}
