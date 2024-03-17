package Test;

import java.util.Iterator;

class Node implements Iterable<Integer> {
    private int data;
    private Node next;

    public Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    @Override
    public Iterator<Integer> iterator() {
        // TODO Auto-generated method stub
        return new customIterator(this);
    }
    
    class customIterator implements Iterator<Integer>
    {
        private Node root;
        public customIterator(Node root)
        {
            this.root = root;
        }
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return root!=null;
        }

        @Override
        public Integer next() {
            // TODO Auto-generated method stub
            Node temp = root;
            root = root.next;
            return temp.data;
        }
        
        
        
    }
}