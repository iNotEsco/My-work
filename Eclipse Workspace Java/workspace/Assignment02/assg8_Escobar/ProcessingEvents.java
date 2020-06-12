//Jason Aaron Escobar Escoto
/*
 * processes events given through an input file containing arrival events, each in a separate line, with the first
 * integer as the arrival time and the second integer as the processing time of the arrival, separated by whitespace(s).
 * only one event can be processed at a time. outputs the processing of an arrival events and departure events.
 */
package assg8_Escobar;

import java.io.*;
import java.util.*;

public class ProcessingEvents {

	static int currentTime = 0, processed = 0, time = 0;

	/**
	 * helper function for main. processes a departure event. it will delete the first departure event from q and 
	 * it's corresponding event from the event list and then processed the next event in queue, making a departure event
	 * for that arrival event.
	 * 
	 * @param temp	the departure event getting processed
	 * @param list	the list containing the events
	 * @param q		the queue containing the events
	 */
	private static void processDeparture(Event temp, LinkedList<Event> list,
			QueueReferenceBased<Event> q){
		currentTime = temp.getATorDT();
		System.out.println("Processing a departure event at time: \t" + currentTime);
		list.remove();
		q.dequeue();
		if(!q.isEmpty()){
			Event tempEvent = new Event(currentTime + q.peek().getPT());
			time += temp.getATorDT() - q.peek().getATorDT();
			if(!list.isEmpty() && tempEvent.getATorDT() <= list.peek().getATorDT()){
				list.addFirst(tempEvent);
			}
			else{
				list.add(tempEvent);
			}


		}
		processed++;

	}
	
	/**
	 * helper function for main. processes an arrival by adding it into the queue. if it is the only thing in the queue then process
	 * arrival will automatically make a departure event for it. process arrival will read from the input and add a new event into the
	 * event list from it.
	 * @param temp
	 * @param input
	 * @param list
	 * @param q
	 */
	private static void processArrival(Event temp, Scanner input, LinkedList<Event> list,
			QueueReferenceBased<Event> q){
		currentTime = temp.getATorDT();
		System.out.println("Processing an arrival event at time: \t" + currentTime);
		list.remove();
		if(q.isEmpty()){
			q.enqueue(temp);
			list.add(new Event(currentTime + temp.getPT()));
		}
		else{
			q.enqueue(temp);
		}
		if(input.hasNextLine()){
			String[] parts = input.nextLine().split("\\s+");
			Event newTemp = new Event(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
			if(newTemp.getATorDT() <= list.peek().getATorDT()){
				list.addFirst(newTemp);
			}
			else{
				list.add(newTemp);
			}

		}

	}
	public static void main(String[] args) throws FileNotFoundException {
		QueueReferenceBased<Event> q = new QueueReferenceBased<Event>();
		LinkedList<Event> list = new LinkedList<Event>();
		Scanner input = null;
		try {
			input = new Scanner(new File("test"));
		} catch (FileNotFoundException e) {
			System.out.print("ERROR: Can not read file \"test\" for input");
			System.exit(1);
		}
		System.out.println("Simulation Begins");
		String[] parts = input.nextLine().split("\\s+");
		list.add(new Event(Integer.parseInt(parts[0]),Integer.parseInt(parts[1])));

		while(!list.isEmpty()){
			Event temp = list.peek();
			if (temp.getType() == 'A'){
				processArrival(temp, input, list, q);
			}
			if(temp.getType() == 'D'){
				processDeparture(temp, list, q);
			}
		}

		System.out.println("Simulation Ends\n\nFinal Statistics:");
		System.out.println("Total number of people processed: " + processed);
		System.out.println("Average amount of time spent waiting: " + ((double)time/processed));
	}

}