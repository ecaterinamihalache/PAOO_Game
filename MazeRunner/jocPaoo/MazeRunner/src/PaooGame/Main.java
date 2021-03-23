package PaooGame;

import PaooGame.GameWindow.GameWindow;

public class Main
{
    public static void main(String[] args)
    {
        Game paooGame = new Game("Maze Runner", 960, 960);
        paooGame.StartGame();
    }
}
