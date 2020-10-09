package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aggressor, Aware, Spawner {

    Random _rand;
    int _verticalDisplacement;
    int _horizontalDisplacement;
    int _previousVerticalDisplacement;
    int _previousHorizontalDisplacement;
    Direction _preferredDirection;
    Boolean readyForSpawning = false;

    // Times animals were sensed
    //int timesSensed = 0;

    public Wolf() {
        _rand = new Random();
        _health = 2;
        _verticalDisplacement = 0;
        _horizontalDisplacement = 0;
        _preferredDirection = getRandomDirection();
    }

    private Direction getRandomDirection() {
        switch (_rand.nextInt(4)) {
            case 0:
                return Direction.Up;
            case 1:
                return Direction.Right;
            case 2:
                return Direction.Down;
            case 3:
                return Direction.Left;
            default:
                return Direction.Error;
        }
    }

    @Override
    public Shape getShape() {
        return Shape.Square;
    }

    @Override
    public Color getColor() {
        return new Color(131, 133, 150);
    }

    @Override
    public Boolean isAlive() {
        return  _health > 0;
    }

    public void attack(Creature target) {
        if(target instanceof Animal) {
            target.takeDamage(5);
            _health++;
            System.out.format("Wolf bites weakens a animal (%d)%n", target._health);
            readyForSpawning = true;
        }
        else if(target instanceof ZombieHunter) {
            target.takeDamage(5);
            System.out.format("Wolf bites weakens Zombie Hunter (%d)%n", target._health);
            if(target._health <= 0)
                System.out.println("ZOMBIE HUNTER IS DEAD!");
        }

    }

    public void move() {
        switch (getRandomDirection()) {
            case Right:
                _location.x++;
                _horizontalDisplacement++;
                break;
            case Left:
                _location.x--;
                _horizontalDisplacement--;
                break;
            case Down:
                _location.y++;
                _verticalDisplacement++;
                break;
            case Up:
                _location.y--;
                _verticalDisplacement--;
                break;
            default:
                break;
        }
    }

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        // When checking for nearby animals, it should first check in the direction
        // it's already moving. If no Animal instance is there, it should search in
        // a clockwise pattern starting at the top.

        if(_horizontalDisplacement > _previousHorizontalDisplacement) {
            //System.out.println("R");
            if (right != null && right.isAlive() && above instanceof Animal) {
                _location.x++;
                _horizontalDisplacement++;
                // System.out.println("Moving one step East");
            }
            else if (below != null && below.isAlive() && above instanceof Animal) {
                _location.y++;
                _verticalDisplacement++;
                // System.out.println("Moving one step South");
            }
            else if (left != null && left.isAlive() && above instanceof Animal) {
                _location.x--;
                _horizontalDisplacement--;
                // System.out.println("Moving one step West");
            }
            else if (above != null && above.isAlive() && above instanceof Animal) {
                _location.y--;
                _verticalDisplacement--;
                // System.out.println("Moving one step North");
            }
        } // After moving Right

        else if(_horizontalDisplacement < _previousHorizontalDisplacement) {
            //System.out.println("L");
            if (left != null && left.isAlive() && above instanceof Animal) {
                _location.x--;
                _horizontalDisplacement--;
                // System.out.println("Moving one step West");
            }
            else if (above != null && above.isAlive() && above instanceof Animal) {
                _location.y--;
                _verticalDisplacement--;
                // System.out.println("Moving one step North");
            }
            else if (right != null && right.isAlive() && above instanceof Animal) {
                _location.x++;
                _horizontalDisplacement++;
                // System.out.println("Moving one step East");
            }
            else if (below != null && below.isAlive() && above instanceof Animal) {
                _location.y++;
                _verticalDisplacement++;
                // System.out.println("Moving one step South");
            }

        } // Left

        else if(_verticalDisplacement > _previousVerticalDisplacement) {
            //System.out.println("D");
            if (below != null && below.isAlive() && above instanceof Animal) {
                _location.y++;
                _verticalDisplacement++;
                // System.out.println("Moving one step South");
            }
            else if (left != null && left.isAlive() && above instanceof Animal) {
                _location.x--;
                _horizontalDisplacement--;
                // System.out.println("Moving one step West");
            }
            else if (above != null && above.isAlive() && above instanceof Animal) {
                _location.y--;
                _verticalDisplacement--;
                // System.out.println("Moving one step North");
            }
            else if (right != null && right.isAlive() && above instanceof Animal) {
                _location.x++;
                _horizontalDisplacement++;
                // System.out.println("Moving one step East");
            }
        } // Down

        else if(_verticalDisplacement < _previousVerticalDisplacement) {
            //System.out.println("U");
            if (above != null && above.isAlive() && above instanceof Animal) {
                _location.y--;
                _verticalDisplacement--;
                // System.out.println("Moving one step North");
            }
            else if (right != null && right.isAlive() && above instanceof Animal) {
                _location.x++;
                _horizontalDisplacement++;
                // System.out.println("Moving one step East");
            }
            else if (below != null && below.isAlive() && above instanceof Animal) {
                _location.y++;
                _verticalDisplacement++;
                // System.out.println("Moving one step South");
            }
            else if (left != null && left.isAlive() && above instanceof Animal) {
                _location.x--;
                _horizontalDisplacement--;
                // System.out.println("Moving one step West");
            }
        } // Up

        // The displacement is checked over ONE and only continuous value for both
        // horizontal and vertical direction.
        _previousHorizontalDisplacement = _horizontalDisplacement;
        _previousVerticalDisplacement = _verticalDisplacement;
    }

    @Override
    public Creature spawnNewCreature() {
        if(readyForSpawning) {
            Wolf baby = new Wolf();
            Point spawnPoint = new Point();

            spawnPoint.x = _location.x - 1;
            spawnPoint.y = _location.y;
            baby.setLocation(spawnPoint);

            readyForSpawning = false;
            return baby;
        }
        return null;
    }
}
