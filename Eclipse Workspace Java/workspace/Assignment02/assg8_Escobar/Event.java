// Jason Aaron Escobar Escoto

/*
 * creates and manages an object with type Event which contains 3 parameters,
 * time, processingTime, and type.
 */
package assg8_Escobar;

public class Event {

	private int time, processingTime;
	private char type;
	
	/**
	 * Three parameter constructor for type Event. Designed for Arrival Events Sets t to time and p to processingTime.
	 * The type is set to 'A' so symbolize Arrival
	 * @param t	the	time of the Event
	 * @param p	the processingTime of the Event
	 */
	
	public Event(int t, int p){
		type = 'A';
		time = t;
		processingTime = p;
	}
	
	/**
	 * Two parameter constructor for Event. Designed for departure events with time equal to t.
	 * ProcessingTime is -1 because a departure Event doesn't have a processingTime. the type is set to 'D' to symbolize departure.
	 * @param t	the time of the departure.
	 */
	
	public Event(int t){
		type = 'D';
		time = t;
		processingTime = -1;
	}
	
	/**
	 * getter method for type of event
	 * @return the type of event.
	 */
	
	public char getType(){
		return type;
	}
	
	/**
	 * setter method for type of event
	 * @param t	the type of Event
	 */
	
	public void setType(char t){
		type = t;
	}
	
	/**
	 *  getter method for time
	 * @return	the time of arrival or departure
	 */
	
	public int getATorDT(){
		return time;
	}
	
	/**
	 * setter method for time
	 * @param a	the arrival of departure time
	 */
	
	public void setATorDT(int a){
		time = a;
	}
	
	/**
	 * getter method for processingTime
	 * @return	the processingTime for the event
	 */
	
	public int getPT(){
		return processingTime;
	}
	
	/**
	 * getter method for processingTime
	 * @param pt	the processingTime for the event
	 */
	
	public void setPT(int pt){
		processingTime = pt;
	}

}
