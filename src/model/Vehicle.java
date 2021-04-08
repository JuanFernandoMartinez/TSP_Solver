package model;

import java.util.ArrayList;
import java.util.List;

public class Vehicle implements Comparable<Vehicle>{
	/*
	 * The identifier of the node
	 */
	private int id;

	private int capacity;
	
	private List<Node> nodes;
	
	public Vehicle(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.nodes = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	
	public double getCapacity() {
		return capacity;
	}
	
	public Vehicle(int id, int capacity, ArrayList<Node> nodes) {
		this.id = id;
		this.capacity = capacity;
		this.nodes = nodes;
	}
	
	public void setnodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	@Override
	public int compareTo(Vehicle o) {
		int status = 0;
		if (capacity > o.capacity) status = 1;
		else if (capacity < o.capacity) status = -1;
		return status;
	}
	
	
	public void addNode(Node a)
	{
		nodes.add(a);
	}
	
}
