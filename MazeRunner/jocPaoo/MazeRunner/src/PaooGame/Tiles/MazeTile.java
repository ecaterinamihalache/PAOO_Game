package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class MazeTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba (labirint).
 */
public class MazeTile extends Tile {
    /*! \fn public MazeTile(int id)
       \brief Constructorul de initializare al clasei

       \param id Id-ul dalei util in desenarea hartii.
    */
    public MazeTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.maze, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    @Override
    public boolean IsSolid() {
        return true;
    }
}