package PaooGame.Tiles;

import PaooGame.Graphics.Assets;
/*! \class public class StartTile extends Tile
    \brief Abstractizeaza notiunea de dala de inceput.
 */
public class StartTile extends Tile{
    /*! \fn public StartTile(int id)
        \brief Constructorul de initializare al clasei

        \param id Id-ul dalei util in desenarea hartii.
     */
    public StartTile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.start, id);
    }
}
