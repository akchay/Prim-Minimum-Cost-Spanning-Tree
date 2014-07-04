import java.util.*;
public class PrimFibo
    {
	/* Double Type value for storing the cost of the MST */ 
	private double MSTcost = 0.0;
	/* Taking Input from the AdjacencyList Class. It may user or random input graph */
	private AdjacencyList inputchart;
	/* Constructor of PrimFibo Class. The user or random input graph is passed through it. */
	public PrimFibo(AdjacencyList cht) 
	{ inputchart = cht;}
	/* FindMSTcost returns the cost of the MST found */
	public double FindMSTcost()
	{ return MSTcost; }
	/* ConstructMST function constructs the Minimum Spanning Tree from lines and points ArrayLists. It uses functions like smallest,
	 * RemoveSmallest, CascadingCut and Meld as defined in the FibonacciHeap.java file.  
	 */
	public ArrayList<Edge> ConstructMST()
	  {
		/* We define ArrayList points for the nodes of the graph */
		ArrayList<Element> points = new ArrayList<Element>();
		/* We define ArrayList path for the edges of the graph */
		ArrayList<Edge> lines = new ArrayList<Edge>();
		/* We first add the 1st node in the graph to ArrayList vertices */
		points.add(inputchart.fectchnodes().get(0));
		FibonacciHeap<Edge> fiboheap = new FibonacciHeap<Edge>();
		for(Edge count : inputchart.fetchedges()) 
	    /* By fetching edges we add weights to edges */
		{
		/* Adding weights to the respective edges */
		fiboheap.put(count, count.takecost());
		}
		ArrayList<Edge> collectMST = new ArrayList<Edge>();
		while( points.size() < inputchart.fectchnodes().size() )
		{
		  while(true)
			{
				/* Fetches the Edge with the Minimum Weight Edge */
				Edge smallestedge = fiboheap.smallest().fetchvalue();
				/* This If condition checks for the both the vertices of the edge */
				if(points.contains(smallestedge.Takevertex1())&&points.contains(smallestedge.Takevertex2()) )
				{
			        /* If the Minimum weight Edge is fetched from the heap, but both the end points of the edge 
					* are already connected then we just need to discard the edge because if added a loop will be generated.
					* Therefore we just throw out that smallest edge which was already connected.
					*/
					fiboheap.RemoveSmallest();
				}
				else if(!points.contains(smallestedge.Takevertex1())&&!points.contains(smallestedge.Takevertex2()))
				{
					/* If both the end points of the Minimum Edge is contained in the Vertices ArrayList, then
					 * we remove the Minimum Edge Weight from the Fibonacci Heap. 
					 */
					collectMST.add(fiboheap.RemoveSmallest().fetchvalue());
				}
				else if(points.contains(smallestedge.Takevertex1())&&!points.contains(smallestedge.Takevertex2()))
				{
					/* If one of the end points is already connected with the present MST but the other end point
					 * is still not connected with the present MST then too we can add that edge with the present
					 * MST. So we add the other end point (which was not connected) in the points ArrayList. And then we
					 * add the new edge just found to the lines ArrayList */ 
					 points.add(smallestedge.Takevertex2());
					 lines.add(smallestedge);
					 /* And then we break from the while loop because we found the Minimum Edge */
					 break;
				}
				else if(!points.contains(smallestedge.Takevertex1())&&points.contains(smallestedge.Takevertex2()))
				{   
					/* If one of the end points is already connected with the present MST but the other end point
					 * is still not connected with the present MST then too we can add that edge with the present
					 * MST. So we add the other end point (which was not connected) in the points ArrayList. And then 
					 * we add the new edge just found to the lines ArrayList. */ 
					points.add(smallestedge.Takevertex1());
					lines.add(smallestedge);
					/* And then we break from the while loop because we found the Minimum Edge */
					break;}
			}
			/* We have collected all our smallest edges (which did not form a loop) from the graph. And now we need
			 * to print those edges in order to find the connected MST. So from collectMST ArrayList we take out the costs
			 * or weights of those edges and then sum it up to get Minimum Spanning Tree. 
			 */
				for(Edge iterator : collectMST)
			          { fiboheap.put(iterator, iterator.takecost()); }
			collectMST.clear();
			/* To find cost of MST we sum the costs or weights of the edges found in lines ArrayList */ 
			MSTcost = MSTcost + lines.get(lines.size()-1).takecost();
		}
		/* Returning the ArrayList of Edges */ 
          return lines;
	} }


