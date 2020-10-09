package src;

import java.util.HashMap;
import java.util.Map;

public class Player {
    String name;
    int health;
    int mana;
    int gold;
    Map<String, Integer> equipment;

    Player(){
        equipment=new HashMap<>();
    }

    public String toString(){
        return "Name: "+ name+" health:"+health+" mana: "+mana+" Gold: "+gold;

    }

}
