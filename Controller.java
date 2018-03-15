import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import model.CharacterA;
import model.ClassOfResults;
import model.Planet;
import model.Ship;
import model.ShipComparator;

public class Controller {
	//Scanner variable for reading data from keyboard
	static Scanner keyboard = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// returns the Character object, that matches with the one user wants to use
		CharacterA character = getCharacter();
		// returns the Planet object, that matches with the one user wants to use
		Planet destinationPlanet = getPlanet();
		System.out.print("Please enter the cargo weight: ");
		//the program keep asking for an integer value( if the user doesn`t type an integer value)
		while(!keyboard.hasNextInt()) {
		    keyboard.next();
		    System.out.print("Please enter an integer value! :");
		}
		int weight = keyboard.nextInt();
		//this function will display the final result
		displayResult(character,destinationPlanet,weight);
	}
	
	// takes a Character ,Planet and weight (all introduced by user) and displays the result
	private static void displayResult(CharacterA character, Planet destinationPlanet, int weight) {
		//results will containt all the Ships the character can drive, ordered by the one who delivers the cargo fastest (plus all the other info - nrOfhours,nrOfTrips,etc)
		Set<ClassOfResults> results = new TreeSet<>(new ShipComparator());
		//for each of character`s type of licence ,check which ship he can drive
		for (String shipCharacterCanDrive : character.getShipsType()) {
			for (Ship ship : Utils.ships) {
				if (shipCharacterCanDrive.equals(ship.getType())) {
					//number of trips needed to deliver all the cargo (two way)
					int numberOfTrips = (int) Math.ceil((double)weight / ship.getMaxCargoWeight());
					// how many hours takes a trip( one way ) ex . from current point to Jakku : 20 hours
					float hoursPerTrip = destinationPlanet.getDistance() / ship.getSpeed();
					//total number of hours needed to deliver all the cargo
					float totalNumberOfHours = (numberOfTrips *2 -1) * hoursPerTrip;
					//add the result for the current Ship to the Set.
					results.add(new ClassOfResults(character,weight,destinationPlanet,totalNumberOfHours,ship,numberOfTrips));
				}
			}
		}
		//display the results
		for(ClassOfResults result : results)
			System.out.println(result);
	}

	// returns the Character object, that matches with the one user wants to use
	private static CharacterA getCharacter() {
		//finalCharacter will hold the character with the name entered from keyboard
		CharacterA finalCharacter = null;
		//when condition is true, the character has been found
		boolean condition = false;
		do {
			//if licenceAvalabile is false, then the character has no driving licene
			boolean licenceAvalabile = true;
			System.out.print("Please enter the character you want to use : ");
			String characterName = keyboard.nextLine();
			for (CharacterA character : Utils.characters) {
				licenceAvalabile = true;
				//if current Character`s name corresponds with the one user entered
				if (character.getName().equals(characterName)) {
					//and he can drive at least one type of Ship
					if (!character.getShipsType().isEmpty()) {
						//then we found the character, and we will return it.
						condition = true;
						finalCharacter = character;
					}
					else
						//the character has no driving licence if his list of ships he can drive is empty
						licenceAvalabile = false;
					break;
				}
			}
			if (licenceAvalabile == false) {
				System.out.println("The character you wish to use has no driving licence!");
			}
			//if condition is still false after checking through all the characters, then the name user entered doesn`t match any character`s name
			else if (condition == false) {
				System.out.println("The character you wish to use doesn`t exist!");
			}
		}while (condition == false);
		return finalCharacter;
	}
	// returns the Planet object, that matches with the one user wants to use
	private static Planet getPlanet() {
		//finalPlanet will hold the planet ,the user wants to go to
		Planet finalPlanet = null;
		//condition = true if the name of the planet entered by user, exists
		boolean condition = false;
		do {
			System.out.print("Please enter the planet you want to travel to : ");
			String planetName = keyboard.nextLine();
			for (Planet planet : Utils.planets) {
				if (planet.getName().equals(planetName)) {
					finalPlanet=planet;
					condition = true;
					break;
				}
			}
			if (condition == false) {
				System.out.println("The planet you`ve entered doesn`t exist!");
			}
		}while(condition == false);
		return finalPlanet;
	}
}
