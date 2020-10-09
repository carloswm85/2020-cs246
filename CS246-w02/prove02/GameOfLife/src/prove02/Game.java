package prove02;

import java.util.LinkedList;

/**
* The starting class of the game. This class initializes the game world and all
* of three creatures within it.
* <p>
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
* @see Creature
*/
public class Game {
	
	World _theWorld;
	
	/**
    * Launches the game.
    */
	public void run()
	{
		// Create our initial batch of creatures
		LinkedList<Creature> creatures = new LinkedList<>();
		
		// Add some plants to the world (25 plants)
		for(int i = 0; i < 10; i++) {
			Plant p = new Plant();
			creatures.add(p);
		}
		
		// Add some animals to the world (25 animals)
		for(int i = 0; i < 35; i++) {
			Animal a = new Animal();
			creatures.add(a);
		}

		// Add some zombies to the world (10 zombies)
		for(int i = 0; i < 10; i++) {
			Zombie z = new Zombie();
			creatures.add(z);
		}

		// Add some wolves to the world (10 wolves)
		for(int i = 0; i < 10; i++) {
			Wolf w = new Wolf();
			creatures.add(w);
		}

		// Add Zombie Hunter to the world (1 Zombie Hunter)
		ZombieHunter zh = new ZombieHunter();
		creatures.add(zh);

		// Create the world
		_theWorld = new World(creatures);
	}
	
	/**
	* main() simply creates an instance of the Game class and calls its run() function.
    * @param args Unused.
    */
	public static void main(String[] args) {
		// It all starts here.
		new Game().run();
	}
}