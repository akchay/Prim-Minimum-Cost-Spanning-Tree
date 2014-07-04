import java.util.*;

public class FibonacciHeap<T> {
    
    public class Elements<T> {
    	
    	/* In the implementation of the Fibonacci Heap, we are just looking at those functions which are
    	 * required for Prim's Algorithm. The other functions like RemoveArbitraryNode and Decrease/Increase
    	 * key are not required. Therefore they are not made use of and in the first place they are not implemented.
    	 * The "NODE" in this code would mean that node on which operation is being done. 
    	 */
    	
    	/* Parent of the NODE */ private Elements<T> parent; /* Child of the NODE */ private Elements<T> child;
    	/* Right Sibling of the NODE*/ private Elements<T> rightkin; 
        /* Left Sibling of the NODE*/ private Elements<T> leftkin;
        /* Degree of the NODE */ private int   numbchild = 0;
        /* Data in the NODE*/ private T  info;    
        /* Cost or weight of the NODE*/ private double weight; 
		/* Cascading Cut if the NODE has already lost one child */ private boolean marked = false; 
        public double FetchCost() { return weight; }
        public void fixvalue(T value) { info = value;}
        public T fetchvalue() { return info; }
        
        /* Constructor for Class Elements */ 
        private Elements(T elem, double edgeweight) {
            rightkin = leftkin = this; info = elem; weight = edgeweight;
        }
        }
	    
        /* The Heap Size */ private int capacity = 0; /* Minimum Heap Pointer */ private Elements<T> smallest = null;
        /* The function put allows to insert the NODE in the Fibonacci Heap */
	    public void put(T value, double priority) {
	        Elements<T> iterator = new Elements<T>(value, priority);
	        smallest = join(smallest, iterator);
	        capacity = capacity + 1;
	    }
	    
	    public Elements<T> smallest()   {return smallest;}
	    public boolean isEmpty()        { return smallest == null; }
	    public int size()               { return capacity;}
	
	    /* The RemoveSmallest function removes or deletes the smallest or minimum node from the Fibonacci Heap. 
	     * This function removes the NODE from its doubly linked sibling list. Then after doing that it sets the 
	     * parent fields of all the children of the NODE to NULL. Then the children are merged or joined with the
	     * top level list. If necessary the heap pointer is updated if a new minimum is found. This is how the RemoveSmallest
	     * function works.   
	     */
	      public Elements<T> RemoveSmallest() {
          --capacity;
          Elements<T> small = smallest;
          if (smallest.rightkin == smallest) { smallest = null; }
          else { 
        	/* delete smallest from top level list */
            smallest.leftkin.rightkin = smallest.rightkin; smallest.rightkin.leftkin = smallest.leftkin;
            smallest = smallest.rightkin; }
          /* Remove the parent field of smallest children's node */ 
          if (small.child != null) {
          Elements<?> present = small.child;
          /* Setting the parent field of all children to NULL */ 
           
          do {
                present.parent = null;
                present = present.rightkin;}    while (present != small.child); }
        
          /* The children are joined with the top level list */
          smallest = join(smallest, small.child);
          if (smallest == null) return small;
          
          List<Elements<T>> heaptree = new ArrayList<Elements<T>>();
          List<Elements<T>> traverse = new ArrayList<Elements<T>>();
          
          for (Elements<T> present = smallest; traverse.isEmpty() 
		  || traverse.get(0) != present; present = present.rightkin)
          traverse.add(present);

          for (Elements<T> present: traverse) {
            
            while (true) {
               while (present.numbchild >= heaptree.size())
                    heaptree.add(null);
                if (heaptree.get(present.numbchild) == null) {
                    heaptree.set(present.numbchild, present);
                    break; }

                Elements<T> other = heaptree.get(present.numbchild);
                heaptree.set(present.numbchild, null);
                Elements<T> min = (other.weight < present.weight)? other : present;
                Elements<T> max = (other.weight < present.weight)? present  : other;
                max.rightkin.leftkin = max.leftkin; max.leftkin.rightkin = max.rightkin;  
                max.rightkin = max.leftkin = max; min.child = join(min.child, max);              
                max.parent = min; max.marked = false;
                ++min.numbchild;
				present = min;
            }
            if (present.weight <= smallest.weight) smallest = present;
        }
        return small;
    }
	      /* The join function melds two Minimum Heaps into one. The Join function is required after RemoveMin and CascadingCut.
	         * It basically combines the two top level lists of both the heaps into one. We also need to update the heap pointer
	         * if necessary. 
	        */
	        private <T> Elements<T> join (Elements<T> min, Elements<T> inserted) {
	        if (min == null && inserted == null) { return null;}
	        else if (min != null && inserted == null) { return min; }
	        else if (min == null && inserted != null) { return inserted; }
	        else { Elements<T> minNext = min.rightkin; min.rightkin = inserted.rightkin;
	            min.rightkin.leftkin = min; inserted.rightkin = minNext;
	            inserted.rightkin.leftkin = inserted;
	            return min.weight < inserted.weight? min : inserted;
	        } }
    
            /* CascadingCut function is used to check that if a node has lost more than one child after remove minimum 
	         * and after it became child of its parent, then it needs to be thrown out from the heap along with its subtree.
	         * Afterwards the thrown outs are merged with top level list. Also CascadingCut propagates upto the root till
	         * it finds a node with marked value false.
	         */
	        private void CascadingCut(Elements<T> element) {
	        /* In the Starting we set cascading cut as false for the node */
	        element.marked = false;
	        /* If the marked node has no parent, then we are done */
	        if (element.parent == null) return;
	        /* If the marked element has siblings */
	        if (element.rightkin != element) { 
	            element.rightkin.leftkin = element.leftkin;
	            element.leftkin.rightkin = element.rightkin; }
	        /* If the marked node has children */
	        if (element.parent.child == element) {
	            if (element.rightkin != element) { element.parent.child = element.rightkin;}
	            else { element.parent.child = null; }
	        }
	         /* Now we decrease the degree since one child is lost */
	          --element.parent.numbchild;
	          element.leftkin = element.rightkin = element;
	          smallest = join(smallest, element);
	          /* This cascading check is propagated up the entire Tree until false is found */
	          if (element.parent.marked)  CascadingCut(element.parent);
	          else element.parent.marked = true;
	          element.parent = null;
	    } } 

