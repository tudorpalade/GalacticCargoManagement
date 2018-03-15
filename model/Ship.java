package model;
public class Ship {
	private String name;
	private int speed;
	private String type;
	private int maxCargoWeight;
	
	public Ship(final String name , final int speed ,final String type, final int maxCargoWeight){
		this.setName(name);
		this.setSpeed(speed);
		this.setType(type);
		this.setMaxCargoWeight(maxCargoWeight);
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMaxCargoWeight() {
		return maxCargoWeight;
	}
	public void setMaxCargoWeight(int maxCargoWeight) {
		this.maxCargoWeight = maxCargoWeight;
	}

	public String toString() {
		return name+ " " + speed + " " + type + " " + maxCargoWeight;
	}
		
}
