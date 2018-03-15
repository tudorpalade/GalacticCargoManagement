package model;

public class Planet {
	private String name;
	private int distance;
	
	public Planet(final String name, final int distance){
		this.setName(name);
		this.setDistance(distance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String toString() {
		return name+ " " + distance;
	}
}
