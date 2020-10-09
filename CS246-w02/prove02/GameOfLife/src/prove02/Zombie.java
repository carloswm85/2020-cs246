package prove02;

import java.awt.*;
import java.util.Random;

public class Zombie extends Creature implements Movable, Aggressor {

    Random _rand;

    public Zombie() {
        _rand = new Random();
        _health = 10;
    }

    @Override
    public Boolean isAlive() {
        return _health > 0;
    }

    @Override
    public Shape getShape() {
        return Shape.Square;
    }

    @Override
    public Color getColor() {
        return new Color(0, 0, 255);
    }

    @Override
    public void attack(Creature target) {
        if (target != null && !(target instanceof Plant)) {
            target.takeDamage(10);
            System.out.println("Zombie bites a victim");
            if(target._health <= 0 && target instanceof Animal)
                System.out.println("Animal is dead");
            if(target._health <= 0 && target instanceof ZombieHunter)
                System.out.println("ZOMBIE HUNTER IS DEAD!");
        }
    }

    @Override
    public void move() {
        _location.x++;
    }
}
