
import java.util.ArrayList;
/* AdjacencyList Class is used to convert the input graph into the Adjacency List */ 
public class AdjacencyList 
    {
	/* ArrayList Circles is used to store the nodes of the graph */
	private ArrayList<Element> circles = new ArrayList<Element>();
	/* ArrayList lines is used to store the edges of the graph */
	private ArrayList<Edge> lines = new ArrayList<Edge>();
	/* Adding Edges to ArrayList lines */
	public boolean AddLine(Edge lin)
	    { if(!lines.contains(lin))
		{ lines.add(lin); return true;}
		else return false; }
	/* Adding nodes to ArrayList circles */
	public boolean AddNode(Element node){
	if(!circles.contains(node)) { circles.add(node); return true;}
	else { return false;}
	}
	/* This function removes the node from ArrayList circles */
	public boolean RemoveNode(Element node) 
	{	return	circles.remove(node); }
	/* Removes the Edges from the ArrayList lines */
	public boolean DeleteEdge(Edge ed){
	return lines.remove(ed);}
	/* This function returns the ArrayList circles */
	public ArrayList<Element> fectchnodes()  { return circles;}
	/* This function returns the ArrayList lines */
	public ArrayList<Edge> fetchedges()   { return lines;}
	/* This function returns an ArrayList called nearbylines. This ArrayList contains the neighbours of the NODE
	 * which has been passed into this function.
	 */
	public ArrayList<Edge> fetchnearbyedges(ArrayList<Element> ver, ArrayList<Edge> left)
		{
		ArrayList<Edge> nearbylines = new ArrayList<Edge>();
          for(Edge z : left)
		    { /* Checks for one of the vertices of an edge */
			  if( !ver.contains(z.Takevertex1()) && ver.contains(z.Takevertex2())) /* Now add */
			     { nearbylines.add(z);}
		      else /* Checks for one of the vertices of an edge */
		    	  if( ver.contains(z.Takevertex1()) && !ver.contains(z.Takevertex2())) /* Now add */
			    { nearbylines.add(z); }
			}
			return nearbylines;
	    }
	/* The function display() prints the edges and nodes from ArrayList circles and ArrayList lines */
     public void display(){
    	    for(Element n : circles)
    	    { System.out.print("Node: "+n.takeNum()+", ");}
    	    System.out.println();
    	    for(Edge e : lines)
    	    { System.out.print("Edge: "+ e.Takevertex1().takeNum() +"->"+e.Takevertex2().takeNum()+" Weight: "+e.takecost() +", ");}
    	    System.out.println();
         	}
	
     /* This function fetches the neighbours of the node */
	public void FetchNeigh()
		{
		/* For each edge we consider both the vertexes i.e. vertex1 and vertex2 */
			for(Element cir: circles)
			{ for(Edge eg: lines)
				{
					if(eg.Takevertex1().equals(cir))  
						/* Add the edge to n's nearbyedges */
						cir.nearbyedges.add(eg); 
					if(eg.Takevertex2().equals(cir)) 
						/* Add the edge to n's nearbyedges */
						cir.nearbyedges.add(eg);
				} 
     }}}













