import java.util.Random;
import java.util.*;

        public class ArbitraryInput {
        /* measureedges is for keeping count of the number of edges */
	    private int measureedges;
	    /* measurenodes is for keeping count of the number of edges */
	    private int measurenodes;
	    /* The constructor of ArbitraryInput 
	     * The number of vertices/nodes and the density of the graph is passed as arguments 
	     */
        public ArbitraryInput(int circles, double density)
        {   measureedges = (int) ( density * circles*(circles-1)/200);
		    measurenodes = circles; }
	    public AdjacencyList Output() {
	    /* Instantiating the object of AdjacencyList Class */
		AdjacencyList chart = new AdjacencyList();
		/* Random is a default class of JAVA. Instantiating it's object */
		Random obj = new Random(System.currentTimeMillis());
		int counter, metric, FirstNode,SecondNode, sum = 0;
		for(counter = 0; counter < measurenodes; counter++)
		{   Element node = new Element(counter);
			chart.AddNode(node); }
		ArrayList<Element> chartnode = chart.fectchnodes();
		/* While goes on till no edge is left */
		while (sum < measureedges)
		{
			/* The weight or cost is assigned randomly */
			metric = obj.nextInt(1000) + 1;
			FirstNode = obj.nextInt(measurenodes);
			SecondNode = obj.nextInt(measurenodes);
			Edge abc = new Edge(chartnode.get(FirstNode),chartnode.get(SecondNode), (double)metric);
			boolean check = chart.AddLine(abc);
			if(check==true) sum = sum+1;
			System.out.println(sum);
		}
		System.out.println("The output is Vertex1->Vertex2->Cost");
		return chart;
		}
    }
