package model;

import java.util.Arrays;

public class VrpCapacity {
	
	
	private Vehicle[] vehicles;
	
	
	public VrpCapacity(int n) {
		vehicles = new Vehicle[n];
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
	
	
	
	
	
		//array de nodos organizados (con sweep)	
		//La idea de esto es encontrar las rutas que menos costos generen (esto no es necesario porque el método es heuristico)
		//otra opción es hacerlo aleatorio
		//en este array iteraremos haciendo que el primer nodo pasr a ser el último
		//luego de hacer n iteraciones, se invierte el orden de los nodos y se hace lo mismo
		//Ordenar el array de los camiones de mayor a menor
		//asignar nodos a cada camión

}
