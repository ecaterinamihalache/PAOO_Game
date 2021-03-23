package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class MazeTile extends Tile {
    public MazeTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.maze, id);
    }

    @Override
    public boolean IsSolid() {
        return true;
    }
}