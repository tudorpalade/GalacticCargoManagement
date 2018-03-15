package model;

import java.util.List;

public class CharacterA {
	private String name;
	private List<String> shipsType;
	
	public CharacterA(final String name, final List<String> shipsType){
		this.setName(name);
		this.setShipsType(shipsType);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getShipsType() {
		return shipsType;
	}

	public void setShipsType(List<String> shipsType) {
		this.shipsType = shipsType;
	}
	
	public String toString() {
		return name+ " " + shipsType;
	}
	
	
}
