import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* This class reads the input file from the user or reads the randomly generated vertices and edges */
public class read {
    /* Instantiating the object of Class AdjacencyList */
	AdjacencyList userinput = new AdjacencyList();
	
	public AdjacencyList readf (String file ) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File(file));
		/* The first two strings are for number of vertices and edges */
		/* So we need to parse them into Integers */
		int cn = Integer.parseInt(scan.next());
		int ce = Integer.parseInt(scan.next());
		/* Now reading the next lines to get the edges and their respective costs */
		while(scan.hasNextLine())
		{  
			/* Again Parsing it into Integers */
			Element y = new Element(Integer.parseInt(scan.next()) );
			Element z = new Element(Integer.parseInt(scan.next()) );
			/* Adding new edge with vertex1, vertex 2 and its cost */
			Edge e = new Edge(y, z, Integer.parseInt(scan.next()) );
			userinput.AddNode(y);
			userinput.AddNode(z);
			userinput.AddLine(e);
		}
		/* Closing the input stream */
		scan.close();
		/* Returning the object of AdjacencyList Class */
		return userinput;

	}
}
