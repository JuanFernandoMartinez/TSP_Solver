package model;

import java.util.ArrayList;

public class Route implements Comparable<Route>{
	
	ArrayList<Node> nodes;
	private double cost;
	private int trucks;
	private int fT;
	
	
	
	public Route() {
		nodes = new ArrayList<>();
		cost = 0;
		trucks = 0;
	}


	
	public ArrayList<Node> getNodes() {
		
		return nodes;
	}

	public double calculateDistance(Model m)
	{
		cost = CostCalculator.getInstance().calculateRouteCost((Node[])nodes.toArray(),m.getDistMatrix());
		return cost;
	}
	


	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}





	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getTrucks() {
		return trucks;
	}


	public void setTrucks(int trucks) {
		this.trucks = trucks;
	}



	public int getfT() {
		return fT;
	}



	public void setfT(int fT) {
		this.fT = fT;
	}



	@Override
	public int compareTo(Route o) {
		
		if (cost == o.cost)
		{
			if (trucks < o.trucks)
			{
				return -1;
			}else 
			{
				return 1;
			}
		}else if (cost < o.cost)
		{
			return -1;
		}else
		{
			return 1;
		}	
	}
}
