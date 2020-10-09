/**
* The Cruise class handles expenses related to the cruise.
* <p>
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
* @see Expense
*/
public class Cruise implements Expense {
	
	// Store the enum value
	Destination _dest;
	
	/**
	* @param dest Where we'll be going on vacation.
	*/
	public Cruise(Destination dest) {
		_dest = dest;
	}
	
	/**
	* @return The cost of the round-trip cruise to our destination.
	*/
	public float getCost() {
		
		// Enums work great with switch statements
		switch (_dest) {
			case Mexico:
				return 1000.00f;
			case Europe:
				return 2000.00f;
			case Japan:
				return 3000.00f;
			default:
				return 0.0f;
		}
	}
}