//Jason Aaron Escobar Escoto
// Main Program to test FlightMap.java.
package assg7_Escobar;

import java.io.*;
import java.util.*;

public class DeterminePaths {

	public static void main(String[] args) throws FileNotFoundException {
		FlightMap FM = new FlightMap();
		FM.loadFlightMap("cityFile.txt", "flightFile.txt");
		Scanner reqFile = new Scanner (new File("requestFile.txt"));
		while(reqFile.hasNextLine()){
			String[] parts = reqFile.nextLine().split("\\s+");
			City from = new City(parts[0]);
			City to = new City(parts[1]);
			boolean boolFrom, boolTo;
			boolFrom = FM.servesCity(from);
			boolTo = FM.servesCity(to);
			if(boolFrom && boolTo){
				LinkedList<City> path = new LinkedList<City>();
				path = FM.getPath(from, to);
				if(path != null){
					System.out.print("The following sequence of flights exist between cities " + 
							from + " and " + to + ":\n" + path.pop());
					while(!path.isEmpty()){
						System.out.print(" -> " + path.pop());
					}
					System.out.println("\n");
				}
				else{
					System.out.println("No sequence of flights exist between cities " + 
							from + " and " + to + ".\n");
				}
			}
			else if(!boolFrom && !boolTo){
				System.out.println("The airline does not serve cities " + from + " nor " + to);
			}
			else if(!boolTo){
				System.out.println("The airline does not serve city " + to);
			}
			else {
				System.out.println("The airline does not serve city " + from);
			}

		}
		reqFile.close();
	}

}
