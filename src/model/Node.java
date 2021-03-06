package model;

public class Node {
	
	/*
	 * The identifier of the node
	 */
	private int id;
	
	/*
	 * X coordinate of the node in the cartesian plane
	 */
	private double xCoord;
	
	/*
	 * Y coordinate of the node in the cartesian plane
	 */
	private double yCoord;
	
	/*
	 * The angle of the node in degrees
	 */
	private double angle;
	
	/*
	 * True if the Node belongs to the tour
	 */
	private boolean onRoute;
	
	/**
	 * this refers to the needen products in the node
	 */
	private int demand;
	
	/*
	 * Creates an instance of the Node class
	 * 
	 * @param id The identifier of the node
	 * @param xCoord X coordinate of the node in the cartesian plane
	 * @param yCoord Y coordinate of the node in the cartesian plane
	 */
	public Node(int id, double xCoord, double yCoord) {
		this.id = id;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.onRoute = false;
		this.angle = 0;
		
	}
	
	
	/**
	 * this constructor have characteristics similar to last but this manage the demand and is for VRP   
	 * @param id The identifier of the node
	 * @param xCoord 
	 * @param yCoord
	 * @param demand
	 */
	public Node(int id, double xCoord, double yCoord, int demand)
	{
		this.id = id;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.onRoute = false;
		this.angle = 0;
		this.demand = demand;
	}
	
	
	
	/*
	 * Returns the id of the node
	 * @return int Id of the node
	 */
	public int getId() {
		return id;
	}
	
	/*
	 * Returns the X coordinate of the node
	 * @returns double X coordinate
	 */
	public double getxCoord() {
		return xCoord;
	}
	
	/*
	 * Returns the Y coordinate of the node
	 * @returns double Y coordinate
	 */
	public double getyCoord() {
		return yCoord;
	}

	/*
	 * Returns True if the node belongs to the tour
	 * @returns boolean True if the node belongs to the tour
	 */
	public boolean isOnRoute() {
		return onRoute;
	}
	
	public void setOnRoute(boolean onRoute) {
		this.onRoute = onRoute;
	}
	
	/*
	 * Sets the angle of the node in degrees
	 * @param angle Angle in degrees
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	/*
	 * Returns the angle of the node
	 * @return double Angle of the node
	 */
	public double getAngle() {
		return angle;
	}
	
	@Override
	public String toString() {
		return this.id + "";
	}


	public int getDemand() {
		return demand;
	}


	public void setDemand(int demand) {
		this.demand = demand;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}


	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}
	
	
}
