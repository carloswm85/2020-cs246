package prove02;

import java.util.LinkedList;
import java.util.Random;
import java.awt.Point;
import java.util.List;

/**
* The "brains" of the game, which controls all of the creature activities.
* <p>
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
* @see Creature
*/
public class CreatureHandler
{
	int _rows;
	int _cols;
	Random _rand;
	LinkedList<Creature> _creatures;
	Boolean spawnTime = false;

	/**
	* Retrieves all of the creatures that exist in the world
	* @return A list of the creatures in the world.
	*/
	public List<Creature> getCreatures() { return _creatures; }

	/**
	* @param worldRows How many rows the world grid should have.
	* @param worldCols How many columns the world grid should have.
	* @param creatures A list of creatures to start the world with.
	*/
	public CreatureHandler(int worldRows, int worldCols, LinkedList<Creature> creatures) {
		_rand = new Random();
		_rows = worldRows;
		_cols = worldCols;
		_creatures = creatures;
	}

	/**
	* Sets the initial positions of the creatures to random locations within the 
	* world's grid.
	*/
	public void setStartingPositions() {

		// Java's enhanced for loop (AKA for-each loop).
		// See: http://stackoverflow.com/a/11685345/28106
		for(Creature c : _creatures) {
			c.setLocation(getRandomLocation());
		}
	}

	private Point getRandomLocation() {
		int r = _rand.nextInt(_rows);
		int c = _rand.nextInt(_cols);
		
		return new Point(r, c);
	}

	private void wrapPoint(Point p) {

		// If we go too far left or right, wrap around
		// to the other side.
		if(p.x > _cols - 1)
			p.x = 0;
		else if(p.x < 0)
			p.x = _cols - 1;
		
		// If we go too far up or down, wrap around
		// to the other side.
		if(p.y > _rows + 1)
			p.y = 0;
		else if(p.y < 0)
			p.y = _rows + 1;
	}

	private Creature getTarget(Creature source, int xOffset, int yOffset) {
		
		// Determine where we are looking based on our current location
		// and the offset
		Point newPoint = (Point)source.getLocation().clone();
		newPoint.x += xOffset;
		newPoint.y += yOffset;

		// Wrap the target point if necessary
		wrapPoint(newPoint);

		// Look at every creature in our list, and see if it is sitting in the spot
		// where we are looking. (ignoring dead creatures)
		for(Creature c : _creatures) {
			if(c == source || !c.isAlive())
				continue;
				
			if(c.getLocation().x == newPoint.x && 
			   c.getLocation().y == newPoint.y)
				return c;
		}
		
		// If we didn't find anything, return null.
		return null;
	}

	private void handleMove(Creature c) {
		
		Movable m = (Movable)c;
		m.move();
		
		wrapPoint(c.getLocation());
	}

	/**
	* Updates all of the living creatures in the game by making they each get a chance to
	* act on their implemented behaviors.
	*/
	public void updateCreatures() {

		// Handle all our creature behaviors here. Since we don't know ahead of time
		// which creatures implement which behaviors, we can use the instanceof keyword
		// to see if a given instance implements a particular interface.
		for(int i = 0; i < _creatures.size(); i++) {
		//for(Creature c : _creatures) {

			Creature c =  _creatures.get(i);
			// Skip dead creatures
			if(!c.isAlive())
				continue;

			if(c instanceof Aware) {
				Creature above = getTarget(c, 0, -1);
				Creature below = getTarget(c, 0, 1);
				Creature left = getTarget(c, -1, 0);
				Creature right = getTarget(c, 1, 0);

				Aware a = (Aware)c;
				a.senseNeighbors(above, below, left, right);
			}

			if(c instanceof Aggressor) {
				Creature target = getTarget(c, 0, 0);
				Aggressor a = (Aggressor)c;
				a.attack(target);
				if(c instanceof Wolf && target instanceof Animal)
					spawnTime = true;
			}

			if(c instanceof ZombieHunter) {
				Creature above = getTarget(c, 0, -_rand.nextInt(4));
				Creature right = getTarget(c, _rand.nextInt(4), 0);
				Creature below = getTarget(c, 0, _rand.nextInt(4));
				Creature left = getTarget(c, -_rand.nextInt(4), 0);

				Creature target = null;

				Aggressor a = (Aggressor)c;
				if (above != null)
					target = above;
				else if (right != null)
					target = right;
				else if (below != null)
					target = below;
				else if (left != null)
					target = left;
				a.attack(target);
			}

			if(c instanceof Movable) {
				handleMove(c);
			}

			if(c instanceof Spawner && spawnTime) {
				Spawner b = (Spawner)c;
				Creature newWolf = b.spawnNewCreature();
				_creatures.add(newWolf);
				System.out.println("BABY wolf is born!");
				spawnTime = false;
			}
		}
	}
}