//Jason Aaron Escobar Escoto

package assg7_Escobar;

import java.io.*;
import java.util.*;


public class FlightMap implements FlightMapInterface {


	private ArrayList<LinkedList<City>> flightMap;
	/**
	 * Creates an empty FlightMap
	 */
	public FlightMap() {
		flightMap = new ArrayList<LinkedList<City>>();
	}

	/**
	 * Retrieves information about the cities and adjacencies from the two
	 * files provided and stores the information in the FlightMap object.
	 * @param cityFileName The name of a file containing a list of city names; 
	 *        one city name per line.
	 * @param flightFileName The name of a file showing city adjacencies.  
	 *        There will be two city names listed per line, separated by a tab
	 *        character; the first city on the line is adjacent to the 
	 *        second city on the same line.
	 * @throws FileNotFoundException if either the city file or the flight
	 *         file are not able to be opened.
	 */

	public void loadFlightMap(String cityFileName, String flightFileName)
			throws FileNotFoundException {
		Scanner cityFile = null;
		Scanner flightFile = null;
		try {
			cityFile = new Scanner(new File(cityFileName));
			flightFile = new Scanner(new File(flightFileName));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Can not open " + cityFileName + " or " +
					flightFileName + " for reading.");
			System.exit(1);   
		}

		while(cityFile.hasNextLine()){
			LinkedList<City> temp = new LinkedList<City>();
			temp.add(new City(cityFile.nextLine()));
			flightMap.add(temp);
		}
		cityFile.close();

		while(flightFile.hasNextLine()){
			String[] parts = flightFile.nextLine().split("\\s+");
			insertAdjacent(new City(parts[0]),new City(parts[1]));

		}
		flightFile.close();

	}
	
	/**
	 * Inserts information into the flight map to record the fact that there
	 * is a direct flight between aCity and adjCity. Both aCity and adjCity
	 * are assumed to be valid cities that are served by the airline.
	 * @param aCity The origin city.
	 * @param adjCity The destination city.
	 */

	public void insertAdjacent(City aCity, City adjCity) {
		Iterator<LinkedList<City>> iter = flightMap.iterator();
		while(iter.hasNext()){
			LinkedList<City> tempList = iter.next();
			City tempCity = tempList.element();
			if(tempCity.getName().equals(aCity.getName())){
				tempList.add(adjCity);
				break;
			}

		}
	}

	/**
	 * Displays to the screen, a list of all cities served by the airline
	 * along with the names of cities to which each is adjacent.
	 */

	public void displayFlightMap() {
		Iterator<LinkedList<City>> iter = flightMap.iterator();
		while(iter.hasNext()){
			displayAdjacentCities(iter.next().element());
		}
	}

	/**
	 * Displays to the screen, the names of all cities served by the airline.
	 */

	public void displayAllCities() {
		Iterator<LinkedList<City>> iter = flightMap.iterator();
		System.out.println("All of the Cities: ");		
		while(iter.hasNext()){
			City temp = iter.next().element();
			System.out.println("" + temp + " " + temp.isVisited() );
		}
	}

	/**
	 * Displays to the screen, the names of all cities which are are adjacent
	 * to aCity; aCity is assumed to be a valid city served by the airline.
	 * @param aCity The city for which the adjacency list is desired.
	 */

	public void displayAdjacentCities(City aCity) {
		Iterator<LinkedList<City>> iter = flightMap.iterator();
		while(iter.hasNext()){
			LinkedList<City> tempList = iter.next();
			City tempCity = tempList.element();
			if(tempCity.equals(aCity)){
				Iterator<City> tempI = tempList.iterator();
				if(tempI.hasNext()){
					System.out.print("Origin City: " + tempI.next() + "\t\tServes: ");
				}
				while(tempI.hasNext()){
					System.out.print(tempI.next());
					if(tempI.hasNext()){
						System.out.print(", ");
					}
				}
				System.out.print("\n");
			}

		}

	}

	/**
	 * Records information to note that aCity has been visited in the path 
	 * so that aCity won't be returned again; aCity is assumed to be 
	 * a valid city served by the airline.
	 * @param aCity The city to be marked.
	 */

	public void markVisited(City aCity) {
		Iterator<LinkedList<City>> iter = flightMap.iterator();
		while(iter.hasNext()){
			City tempCity = iter.next().element();
			if(tempCity.equals(aCity)){
				tempCity.visit();
			}
		}
	}

	/**
	 * Removes the visited marks on all cities served by the airline.
	 */

	public void unVisitAll() {
		Iterator<LinkedList<City>> iter = flightMap.iterator();
		while(iter.hasNext()){
			iter.next().element().clear();
		}
	}


	/**
	 * Determines whether or not aCity has been visited
	 * @param aCity The city for which you wish to determine visited status.
	 * @return True if aCity has been visited, and false otherwise.
	 */

	public boolean isVisited(City aCity) {
		Iterator<LinkedList<City>> iter = flightMap.iterator();
		while(iter.hasNext()){
			City tempCity = iter.next().element();
			if(tempCity.equals(aCity)){
				return tempCity.isVisited();
			}
		}
		return false;
	}

	/**
	 * Gets the next unvisited city, if any, to which aCity is adjacent.
	 * @param aCity The city for which you wish to get the next adjacency.
	 * @return The next unvisited city to which you can directly travel
	 *         from aCity, or null there are no unvisited cities to which
	 *         you can travel from aCity.
	 */
	public City getNextCity(City aCity) {
		Iterator<LinkedList<City>> iterList = flightMap.iterator();
		while(iterList.hasNext()){
			LinkedList<City> tempList = iterList.next();
			if(tempList.element().equals(aCity)){
				Iterator<City> iterCity = tempList.iterator();
				while(iterCity.hasNext()){
					City tempCity = iterCity.next();
					if(!isVisited(tempCity)){
						return tempCity;
					}
				}
				return null;
			}
		}
		return null;
	}

	/**
	 * Determines if the airline serves aCity
	 * @param aCity The city to check
	 * @return True if the airline has flights leaving or arriving at
	 *         aCity and false otherwise
	 */
	public boolean servesCity(City aCity) {
		Iterator<LinkedList<City>> iter = flightMap.iterator();
		while(iter.hasNext()){
			if (iter.next().element().equals(aCity)){
				return true;
			}
		}
		return false;
	}

	/**
	 * Determines if there is a sequence of flights which start at originCity,
	 * and take you to destinationCity; Both originCity and destinationCity are
	 * assumed to be valid cities served by the airline.
	 * @param originCity The city from which the search should begin
	 * @param destinationCity The final city at which you wish to arrive
	 * @return A LinkedList object containing a list of cities starting at the
	 *         originCity and ending at destinationCity, if there is a sequence 
	 *         of flights from originCity to destinationCity. The
	 *         originCity will be found in position 0 of the list.
	 *         If no sequence of flights exist, then null will be returned.
	 */
	public LinkedList<City> getPath(City originCity, City destinationCity) {
		Stack<City> stack = new Stack<City>();
		City topCity, nextCity;
		unVisitAll();

		stack.push(originCity);
		markVisited(originCity);
		topCity = (City) (stack.peek());
		while(!stack.isEmpty() && !topCity.equals(destinationCity)){
			nextCity = getNextCity(topCity);
			if(nextCity == null){
				stack.pop();

			}
			else{
				stack.push(nextCity);
				markVisited(nextCity);
				
			}
			if(!stack.isEmpty()){
				topCity = (City) stack.peek();
			}
		}
		if(stack.isEmpty()){
			return null;
		}
		else {
			Stack<City> reversedStack = new Stack<City>();
			while(!stack.isEmpty()){
				reversedStack.push(stack.pop());
			}
			LinkedList<City> path = new LinkedList<City>();
			while(!reversedStack.isEmpty()){
				path.add(reversedStack.pop());
			}
			return path;
		}
	}

}
