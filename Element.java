import java.util.*;
public class Element 
    {
	/* A boolean variable for checking a node has been traversed or not */
	private boolean traversed = false;
	private int num;
	/* If the node has been traversed, this function would be invoked each time. */
	public void traversed()         { traversed = true;}
	/* If the node has not been traversed yet then this function would be invoked each time. */
	public void nottraversed()      { traversed = false;}
	public Element(int NUM)         { this.num = NUM;}
	/* To check a node has been traversed or not, this function is used. */
    public boolean IsTraversed()    { return traversed; }
    public int takeNum()            { return num;}
    /* An ArrayList for nearby neighbours is made. Its type is Edge. */
    public  ArrayList<Edge> nearbyedges = new ArrayList<Edge>();
    public boolean equals(Object abc ){  if (abc != null && abc instanceof Element)
    	{return this.takeNum() == ((Element) abc).takeNum();}
    	return false;
    	}
	}
