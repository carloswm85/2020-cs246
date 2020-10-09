package prove02;

import java.awt.*;
import java.util.Random;

public class ZombieHunter extends Creature implements Aggressor, Movable {

	Random _rand;

	public ZombieHunter() {
		_rand = new Random();
		_health = 100;
	}
	
	// No javadocs are necessary for these methods because they will inherit the 
	// documentation from the superclass. We only need to add docs here if we are
	// doing something non-obvious in our overridden version.

	public Shape getShape() {
		return Shape.Circle;
	}
	
	public Color getColor(){
		return new Color(255, 99, 71);
	}	
	
	public Boolean isAlive() {
		return _health > 0;
	}

	public void attack(Creature target) {
		if(target instanceof Zombie) {
			target.takeDamage(5);
			System.out.format("Zombie Hunter punches a zombie, the zombie's life is %d%n", target._health);
			if(target._health <= 0)
				System.out.format("Zombie Hunter has killed an evil zombie! His life is %d points %n", _health);
			move();
		}
		else if(target instanceof Wolf) {
			target.takeDamage(1);
			System.out.format("Zombie Hunter punches a wolf, wolf's life is %d%n", target._health);
			if (target._health <= 0)
				System.out.format("Zombie Hunter has killed a wolf! His life is %d points%n", _health);
			move();
		} else if(target instanceof Plant) {
			_health++;
			target.takeDamage(1);
			System.out.format("Zombie Hunter recovers some health thanks to a plant. His life rises to %d%n", _health);
			move();
		}

	}

	private DiagonalDirection getRandomDirection() {
		switch (_rand.nextInt(4)) {
			case 0:
				return DiagonalDirection.NE;
			case 1:
				return DiagonalDirection.SE;
			case 2:
				return DiagonalDirection.SW;
			case 3:
				return DiagonalDirection.NW;
			default:
				return DiagonalDirection.Error;
		}
	}

	@Override
	public void move() {
		switch (getRandomDirection()) {
			case NE:
				_location.x++;
				_location.y--;
				break;
			case SE:
				_location.x++;
				_location.y++;
				break;
			case SW:
				_location.x--;
				_location.y++;
				break;
			case NW:
				_location.x--;
				_location.y--;
				break;
			default:
				break;
		}
	}
}