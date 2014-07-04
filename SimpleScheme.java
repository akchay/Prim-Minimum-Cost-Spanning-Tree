import java.util.*;
 
    public class SimpleScheme
    {
    /* graph is of type AdjacencyList */
	private AdjacencyList input;
	private double TotalCost = 0;
	
	/* Constructor of Class 
	 * Passing input graph through it 
	 */
	public SimpleScheme(AdjacencyList var) { input = var;}
	/* This function returns the total cost or weight of the MST */
	public double getTotalCost(){ return TotalCost; }
	/* This function creates or constrcuts the MST */
	public ArrayList<Edge> getMST(){
		/* ArrayList vertices to store the nodes */
		ArrayList<Element> vertices = new ArrayList<Element>();
		/* ArrayList path to store the edges */
        ArrayList<Edge> path = new ArrayList<Edge>();
        ArrayList<Edge> leftoveredges = input.fetchedges();
		vertices.add(input.fectchnodes().get(0));
		/* ArrayList store to keep the minimum selected edges but forming a loop into garbage */
		ArrayList<Edge> store  = new ArrayList<Edge>();
	    while( vertices.size() < input.fectchnodes().size() )
		{
		  Collections.sort(leftoveredges,new comparetwoedges());
			while(true)
			{
				Edge lowestedge = leftoveredges.get(0);
				if(vertices.contains(lowestedge.Takevertex1())&&vertices.contains(lowestedge.Takevertex2()) )
				{
					/* If both the nodes of the Minimum Edge selected are already connected
					 * in the graph then we simply remove the selected edge because it would form a loop
					 */
					leftoveredges.remove(0);
				 }
				else if(!vertices.contains(lowestedge.Takevertex1())&&!vertices.contains(lowestedge.Takevertex2()))
				{
			        /* If both the vertices of the selected Minimum Edge are not connected in the graph 
			         * then we add the Minimum Edge  
			         */
					store.add(leftoveredges.remove(0));
					
				}
				else if(vertices.contains(lowestedge.Takevertex1())&&!vertices.contains(lowestedge.Takevertex2()))
				{
					/* If one of the nodes of the selected Minimum Edge is not connected then
					 * we can add that Minimum Edge. Also we will add the other previously not connected node to
					 * ArrayList vertices
					 */
					vertices.add(lowestedge.Takevertex2());
					path.add(lowestedge);
					break;
				}
				else if(!vertices.contains(lowestedge.Takevertex1())&&vertices.contains(lowestedge.Takevertex2()))
				{
					/* If one of the nodes of the selected Minimum Edge is not connected then
					 * we can add that Minimum Edge. Also we will add the other previously not connected node to
					 * ArrayList vertices
					 */
					vertices.add(lowestedge.Takevertex1());
					path.add(lowestedge);
					break;
				 }   }
			leftoveredges.addAll(store);
			store.clear();
			TotalCost = TotalCost+path.get(path.size()-1).takecost();
			}
		/* Returns the ArrayList for edges */
		return path;
	} }
    
    class comparetwoedges implements Comparator<Edge>
    {
    public int compare(Edge b1, Edge b2) {
    	if(b1.takecost() < b2.takecost())
    	{	return -1; } 
    	else if(b1.takecost() == b2.takecost())
    	{   return 0; }
    	else
    	{ return 1; } }
    }

   