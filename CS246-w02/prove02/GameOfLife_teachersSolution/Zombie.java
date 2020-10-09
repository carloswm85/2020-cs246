import java.awt.Color;

public class Zombie extends Creature implements Movable, Aggressor {

    /**
    * Creates a zombie with 1 health point.
    */
    public Zombie() {
        _health = 1;
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
        return new Color(15, 108, 182);
    }
    
    /**
    * If the creature we've encountered is not a plant, attack it.
    * @param target The {@link Creature} we've encountered.
    */
    public void attack(Creature target) {
        // Zombies attack everything but plants
        if(target != null && !(target instanceof Plant)) {
            target.takeDamage(10);
        }
    }
    
    /**
    * Zombies always move from left to right.
    */
    public void move() {
        _location.x++;
    }

}