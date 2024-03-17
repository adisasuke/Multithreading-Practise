package Iterator;

import java.util.Iterator;

public class Node implements Iterable<Node>{
	
    public int data;
    public Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    public Node(int data,Node node)
    {
        this.data = data;
        this.next = node;
    }

	@Override
	public Iterator<Node> iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator(this);
	}

    private class  CustomIterator implements Iterator<Node> {

    	
    	private Node root;
    	public CustomIterator(Node root)
    	{
    		this.root = root;
    	}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(root.next!=null)
				return true;
			return false;
		}

		@Override
		public Node next() {
			// TODO Auto-generated method stub
			Node x = root;
			root = root.next;
			return x;
		}
    	
    }

}