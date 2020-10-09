import java.awt.Color;
import java.util.Random;
import java.awt.Point;

public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner {

    Random _rand;
    Direction _preferredDirection;
    Boolean _canSpawn;

    /**
    * Creates a wolf with 1 health point who moves in a random direction.
    */
    public Wolf() {
        _canSpawn = false;
        _health = 1;
        _rand = new Random();
        _preferredDirection = getRandomDireciton();
    }

    private Direction getRandomDireciton() {
        switch(_rand.nextInt(4)) {
            case 0:
                return Direction.Right;
            case 1:
                return Direction.Left;
            case 2:
                return Direction.Up;
            case 3:
                return Direction.Down;
            default:
                return Direction.Up;
        }
    }
    
    // No javadocs are necessary for these methods because they will inherit the 
    // documentation from the superclass. We only need to add docs here if we are
    // doing something non-obvious in our overridden version.
    
    public Boolean isAlive() {
        return _health > 0;
    }
    
    public Shape getShape() {
        return Shape.Square;
    }
    
    public Color getColor() {
        return new Color(72, 72, 72);
    }

    /**
    * @return The baby wolf.
    */
    public Creature spawnNewCreature() {

        if(!_canSpawn)
            return null;

        Wolf baby = new Wolf();
        
        // Set the baby to our left
        Point newPoint = (Point)_location.clone();
        newPoint.x--;
        baby.setLocation(newPoint);

        _canSpawn = false;

        return baby;
    }

    /**
    * If a wolf senses an animal nearby, it will change direction to move towards that animal.
    * It first checks in the direction it is already moving, then searches in a clockwise pattern.
    * @param above The {@link Creature} directly above us.
    * @param below The {@link Creature} directly below us.
    * @param left The {@link Creature} directly to the left of us.
    * @param right The {@link Creature} directly to the right of us.
    */
    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        if(_preferredDirection == Direction.Up)
        {
            if(above instanceof Animal)
                return;
            else if(right instanceof Animal)
                _preferredDirection = Direction.Right;
            else if(below instanceof Animal)
                _preferredDirection = Direction.Down;
            else if (left instanceof Animal)
                _preferredDirection = Direction.Left;
        }
        else if(_preferredDirection == Direction.Right)
        {
            if(right instanceof Animal)
                return;
            else if(below instanceof Animal)
                _preferredDirection = Direction.Down;
            else if(left instanceof Animal)
                _preferredDirection = Direction.Left;
            else if(above instanceof Animal)
                _preferredDirection = Direction.Up;
        }
        else if(_preferredDirection == Direction.Down)
        {
            if(below instanceof Animal)
                return;
            else if(left instanceof Animal)
                _preferredDirection = Direction.Left;
            else if(above instanceof Animal)
                _preferredDirection = Direction.Up;
            else if(right instanceof Animal)
                _preferredDirection = Direction.Right;
        }
        else if(_preferredDirection == Direction.Left)
        {
            if(left instanceof Animal)
                return;
            else if(above instanceof Animal)
                _preferredDirection = Direction.Up;
            else if(right instanceof Animal)
                _preferredDirection = Direction.Right;
            else if(below instanceof Animal)
                _preferredDirection = Direction.Down;

        }
    }
    
    /**
    * If the creature we've encountered is an animal, attack it.
    * @param target The {@link Creature} we've encountered.
    */
    public void attack(Creature target) {
        // Wolves only attack animals
        if(target instanceof Animal) {
            target.takeDamage(5);
            _canSpawn = true;
        }
    }
    
    /**
    * Wolves always move in their preferred direction. At the start
    * of the game, that will be random, but it is affected by creatures around them.
    */
    public void move() {
        switch(_preferredDirection) {
            case Right:
                _location.x++;
                break;
            case Left:
                _location.x--;
                break;
            case Down:
                _location.y++;
                break;
            case Up:
                _location.y--;
                break;
        }
    }

}