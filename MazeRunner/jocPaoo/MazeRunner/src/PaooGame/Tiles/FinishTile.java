package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

/*! \class public class FinishTile extends Tile
    \brief Abstractizeaza notiunea de dala de final.
 */
public class FinishTile extends Tile {
    /*! \fn public FinishTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public FinishTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.finish, id);
    }
}
