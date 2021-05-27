package model;

public class VRPSolution {
	
	private Vehicle[] trucks;
	private double cost;
	private Node[] nodeList;
	
	public VRPSolution() {
		
	}

	public Vehicle[] getTrucks() {
		return trucks;
	}

	public void setTrucks(Vehicle[] trucks) {
		this.trucks = trucks;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Node[] getNodeList() {
		return nodeList;
	}

	public void setNodeList(Node[] nodeList) {
		this.nodeList = nodeList;
	}
	
	
	
	
	
	
}
