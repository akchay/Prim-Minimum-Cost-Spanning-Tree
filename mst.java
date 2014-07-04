import java.io.FileNotFoundException;
import java.util.*;

public class mst {
	public static void main(String[] args) throws FileNotFoundException {
		long BeginSimple, BeginFibo, FinishSimple, FinishFibo;
	    AdjacencyList userinput = new AdjacencyList();
		read myobject = new read();
		
	                           /* ~~~~~~~~FIBONACCI HEAP~~~~~~~~ */
	    String s = args[0];
	    /* For the Fibonacci Heap the argument is -f */
		if (s.equals("-f"))
			{
			String name = args[1].trim();
			/* Reading the input file through object of read class */
			userinput= myobject.readf(name);
			/* Instantiating object of PrimFibo Class and passing InputGraph */
			PrimFibo mstfib = new PrimFibo (userinput);
			/* Calling ConstructMST functions which generates the MST and then 
			 * calling printMST function to display the generated MST.
			 */
			display (mstfib.ConstructMST());
			System.out.println("Fibonacci Heap MST cost" + mstfib.FindMSTcost());
		}
		/* For Simple Scheme the argument is -s */
		if (s.equals("-s"))
			{  
			String name = args[1].trim();
			System.out.println(name);
			userinput= myobject.readf(name);
			/* Instantiating object of SimpleScheme.java and passing InputGraph to it */
			SimpleScheme sobject = new SimpleScheme (userinput);
			/* Printing the MST constructed */
			display(sobject.getMST());
			System.out.println("Simple Scheme MST cost" + sobject.getTotalCost());
			
		}
		/* For the Random Mode the argument is -r with number of vertices and density */ 
		if (s.equals("-r"))
		{
			String vertices= args[1];
			/* Parsing the string argument into Integer */
			int numv= Integer.parseInt(vertices);
			String density = args[2];
			/* Parsing the string argument into Integer */
			int den = Integer.parseInt(density);
			ArbitraryInput rd = new ArbitraryInput(numv, den);
			AdjacencyList randominput = rd.Output();
			/* Fibonacci */
			BeginFibo = System.currentTimeMillis();
			/* Instantiating object of PrimFibo.java and passing random input through it */
			PrimFibo fobj = new PrimFibo(randominput);
			/* ConstrcutMST is called and then the MST generated is printed */
			display(fobj.ConstructMST());
			System.out.println("Cost of MST from Fibonacci is "+fobj.FindMSTcost());
			FinishFibo = System.currentTimeMillis()-BeginFibo;
	        /*Simple Scheme*/	
			BeginSimple = System.currentTimeMillis();
			/* Instantiating object of SimpleScheme.java and passing random input through it */ 
			SimpleScheme sobj = new SimpleScheme(randominput);
			display(sobj.getMST());
			System.out.println("Cost of MST is "+sobj.getTotalCost());
			/* Calculating the Time for the Program Completion */ 
			FinishSimple = System.currentTimeMillis() - BeginSimple;
			System.out.println("Fibonacci Heap time "+ FinishFibo + "; Simple Scheme time "+ FinishSimple);
		}
	}
	
	/* This function is used to print the MST in the following format: 
	 * vertex1 vertex2 cost
	 */
	public static void display(ArrayList<Edge> mst)
	{
		if(mst != null)
		{
			for(Edge iterator : mst)
	    	{ System.out.print(iterator.Takevertex1().takeNum()+ " " +iterator.Takevertex2().takeNum() +" " +iterator.takecost()); 
	    	System.out.println("\n");
	    	}
		}
		else 
			/* Error Message */
			System.out.println("I am sorry. MST cannot be generated, because probably the input graph was itself " +
					"not connected. Sorry. Try again!!!");}
}





