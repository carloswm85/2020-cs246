package src;

import java.io.*;
import java.util.Scanner;

import com.google.gson.Gson;

public class Game {
    static String testData;
    public Player player;
    Gson gson;
    Game (Player p){
        player=p;
    }

    void saveGame(){
        FileWriter wrter;
        gson=new Gson();

        try {
            wrter=new FileWriter("something.json");
            testData=gson.toJson(player);
            wrter.write(testData);
            wrter.close();
        }
        catch (java.io.IOException e){
            System.out.println("File Error");
        }
    }
    public static Game loadGame(String file){
        String data="";
        Gson gson=new Gson();
        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data =data+myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(data.compareTo(testData));
        Player p=gson.fromJson(data,Player.class);
        return new Game(p);
    }
}
