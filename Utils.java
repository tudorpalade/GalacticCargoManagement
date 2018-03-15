import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.CharacterA;
import model.Planet;
import model.Ship;

// contains the List of Ships,Planets and Characters
public class Utils {
	private static JSONParser parser = new JSONParser();	
	public static List<Ship> ships = returnShips();
	public static List<Planet> planets = returnPlanets();
	public static List<CharacterA> characters = returnCharacters();
	
	// returns a Set of Ships, created by parsing the .json file containing ships
	public static List<Ship> returnShips(){
		//we don`t need to sort the Ships , so we`ll use an ArrayList
		List<Ship> shipList = new ArrayList<>();
		try {
			//shipObj holds the all content of "ships.json" as an Java Object
			Object shipObj = parser.parse(new FileReader("ships.json"));
			//jsonShipArray is a JSONObject, obtained by convertingg shipObject . We need this JSONArray to iterate through .json file
			JSONArray jsonShipArray = (JSONArray) shipObj;
				// we loop through all the JSONObjects of .json file
				for (int i=0;i<jsonShipArray.size();i++) {
					//contains the values for Ship`s variables
					JSONObject jsonShip = (JSONObject) jsonShipArray.get(i);
					String name = (String) jsonShip.get("name");
					long speed = (long) jsonShip.get("speed");
					String type = (String) jsonShip.get("type");
					long maxCargoWeight = (long) jsonShip.get("maxCargoWeight");
					//create a new instance of Ship with the values got from .json file
					shipList.add(new Ship(name,(int)speed,type,(int)maxCargoWeight));
				}
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		return shipList;
	} 
	
	public static List<Planet> returnPlanets(){
		//we don`t need to sort the Planets , so we`ll use an ArrayList
		List<Planet> planetList = new ArrayList<>();
		try {
			Object planetObj = parser.parse(new FileReader("planets.json"));
			JSONArray jsonShipArray = (JSONArray) planetObj;
				for (int i=0;i<jsonShipArray.size();i++) {
					JSONObject jsonPlanet = (JSONObject) jsonShipArray.get(i);
					String name = (String) jsonPlanet.get("name");
					long distance = (long) jsonPlanet.get("distance");
					planetList.add(new Planet(name,(int)distance));
				}
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		return planetList;
	}
	
	public static List<CharacterA> returnCharacters(){
		//we don`t need to sort the Characters , so we`ll use an ArrayList
		List<CharacterA> characterList = new ArrayList<>();
		try {
			Object characterObj = parser.parse(new FileReader("characters.json"));
			JSONArray jsonCharacterArray = (JSONArray) characterObj;
				for (int i=0;i<jsonCharacterArray.size();i++) {
					JSONObject jsonCharacter = (JSONObject) jsonCharacterArray.get(i);
					String name = (String) jsonCharacter.get("name");
					List<String> shipsType = new ArrayList<>();
					JSONArray charAux = (JSONArray) jsonCharacter.get("shipsType");
					for (int k = 0 ; k < charAux.size() ; k++) {
						shipsType.add((String) charAux.get(k));
					}
					characterList.add(new CharacterA(name, shipsType));
				}
		}
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(ParseException e) {e.printStackTrace();}
		catch(Exception e) {e.printStackTrace();}
		return characterList;
	}
}
