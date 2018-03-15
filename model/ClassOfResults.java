package model;
//this class will hold all the final result has: total speed, total trips, etc
public class ClassOfResults {
	private CharacterA character;
	private int totalCargo;
	private Planet planet;
	private float hours;
	private Ship ship;
	private int trips;
	public ClassOfResults(CharacterA character2, int weight, Planet destinationPlanet, float totalNumberOfHours,
			Ship ship2, int numberOfTrips) {
		this.setCharacter(character2);
		this.setTotalCargo(weight);
		this.setPlanet(destinationPlanet);
		this.setHours(totalNumberOfHours);
		this.setShip(ship2);
		this.setTrips(numberOfTrips);
		
	}
	public CharacterA getCharacter() {
		return character;
	}
	public void setCharacter(CharacterA character) {
		this.character = character;
	}
	public int getTotalCargo() {
		return totalCargo;
	}
	public void setTotalCargo(int totalCargo) {
		this.totalCargo = totalCargo;
	}
	public Planet getPlanet() {
		return planet;
	}
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public Ship getShip() {
		return ship;
	}
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	public int getTrips() {
		return trips;
	}
	public void setTrips(int trips) {
		this.trips = trips;
	}
	
	public String toString() {
		if (trips != 1)
			return (character.getName() + " can transport a cargo of "+
						   totalCargo + " KG to " + planet.getName() +", in " + 
						   hours +" hours, using the "+ ship.getName() +" in "+ trips +" trips");
		else
			return (character.getName() + " can transport a cargo of "+
					   totalCargo + " KG to " + planet.getName() +", in " + 
					   hours +" hours, using the "+ ship.getName() +" in "+ trips +" trip");
	}
}
