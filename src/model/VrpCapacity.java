package model;



import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

import structures.Queue;

public class VrpCapacity {
	
	
	private Vehicle[] vehicles;
	private Queue<Node> nodes;
	private Model model;
	
	
	public VrpCapacity(int n) {
		vehicles = new Vehicle[n];
		nodes = new Queue<>();
	}
	
	
	
	
	/**
	 * receive all vehicles capacities an initialize the vehicles objects
	 * @param a Integer vector with all capacities ordered 
	 */
	public void fillVehicles(int[] a)
	{
		for (int i = 0; i < vehicles.length; i++)
		{
			vehicles[i] = new Vehicle(i,a[i]);
		}
		
		Arrays.sort(vehicles);
	}
	
	
	public Node[] sweep() throws IOException
	{
		FileReaderLIB fr = new FileReaderLIB();
		model = fr.readFile("VRP_EXAMPLE.txt");
		Sweep sp = new Sweep();
		Solution sol = sp.solve(model,model.getG().getxCoord(),model.getG().getyCoord());
		fillVehicles(model.getTrucks());
		return sol.getRoute();
	}
	
	
	public void fillQueue() throws IOException
	{
		Node[] nodeList = sweep();
		for (int i = 0; i < nodeList.length; i++)
		{
			nodes.add(nodeList[i]);
		}
		
	}
	
	public void iterateQueue()
	{
		nodes.add(nodes.top());
		nodes.remove();
	}
	
	public void reverseQueue()
	{
		Stack<Node> reverser = new Stack<>();
		
		int limit = nodes.size();
		
		for (int i = 0; i < limit; i++)
		{
			reverser.add(nodes.top());
			nodes.remove();
		}
		
		for (int i = 0; i < limit; i++)
		{
			nodes.add(reverser.peek());
			reverser.pop();
		}
	}
	
	
	public Route calculateRoute()
	{
		Route r = new Route();
		boolean finished = false;
		int currentPos = 0;
		
		
		for (int i = 0; i < vehicles.length && !finished; i++)
		{
			r.getNodes().add(model.getG());
			r.setTrucks(r.getTrucks()+1);
			int cap = vehicles[i].getCapacity();
			boolean space = true; 
			
			for (int j = currentPos; j < nodes.size() && space; j++)
			{
				Node aux = nodes.get(j);
				if (cap >= aux.getDemand())
				{
					r.getNodes().add(aux);
					cap -= aux.getDemand();
					
					if (j == nodes.size()-1)
					{
						finished = true;
					}
					
				}else
				{
					r.getNodes().add(model.getG());
					currentPos = j;
					space = false;
					
				}
			}
			
			
		}
		
		if (r.getNodes().size() == nodes.size()) return r;
		return null;
		
	}
	
	
	public Route chooseRoute()
	{
		Route aux = null;
		// ->
		for (int i = 0; i < nodes.size(); i++ )
		{
			if (aux != null)
			{
				Route r = calculateRoute();
				
				if (r != null)
				{
					r.calculateDistance(model);
					if (aux.compareTo(r) > 0)
					{
						aux =  r;
					}	
				}
				iterateQueue();
			}else
			{
				aux = calculateRoute();
				if (aux != null) aux.calculateDistance(model);
				iterateQueue();
			}
		}
		
		//<-
		reverseQueue();
		
		for (int i = 0; i < nodes.size(); i++ )
		{
			if (aux != null)
			{
				Route r = calculateRoute();
				
				if (r != null)
				{
					r.calculateDistance(model);
					if (aux.compareTo(r) > 0)
					{
						aux =  r;
					}
					
				}
				iterateQueue();
			}else
			{
				aux = calculateRoute();
				if (aux != null) aux.calculateDistance(model);
				iterateQueue();
			}
		}
		
		return aux;
	}
	
	
	
	
	
	
		//checked - array de nodos organizados (con sweep) 	
		//checked - Ordenar el array de los camiones de mayor a menor
		//checked - luego de hacer n iteraciones, se invierte el orden de los nodos y se hace lo mismo
		//checked - en este array iteraremos haciendo que el primer nodo pasr a ser el último
		//checked - La idea de esto es encontrar las rutas que menos costos generen (esto no es necesario porque el método es heuristico)
		//asignar nodos a cada camión

}
