package src;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();

        player.name="Eugene";
        player.health=100000;
        player.mana=1004030;
        player.gold=88888888;
        player.equipment.put("Sword", 100);
        Game game=new Game(player);
        game.saveGame();

        Game newGame=Game.loadGame("something.json");
        System.out.println(newGame.player.toString());
    }
}
