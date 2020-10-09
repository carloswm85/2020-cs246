/**
*  Spawners create new versions of themselves.
* <p>
* @author  Brother Falin
* @version 1.0
* @since   2016-12-08 
* @see Creature
*/
public interface Spawner {

    /**
    * @return The {@link Creature} we've spawned.
    */
    public Creature spawnNewCreature();

}