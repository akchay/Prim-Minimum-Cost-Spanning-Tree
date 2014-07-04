public class Edge 
   
    {    
	    /* The class Edge is used to define the associated variables and functions required by an edge. */
	    /* This metric is the cost or weight of edge */
		private double metric;
		/* Variables vertex1 and vertex 2 are of type Element (Node) */
		private Element vertex1, vertex2;
		/* The constructor of Edge Class. First Vertex, Second Vertex and cost of an edge is passed */
		public Edge(Element q1, Element q2, double cost)
		{ vertex1 = q1; vertex2 = q2; this.metric = cost; }
		/* takecost function returns the cost or weight of the edge */
		public double takecost() { return this.metric; }
		/* Takevertex1 returns the first node of an edge */
		public Element Takevertex1() {return vertex1;}
		/* Takevertex2 returns the second node of an edge */
		public Element Takevertex2() {return vertex2;}
	}
