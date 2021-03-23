package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
/*! \class public class Money extends Character
    \brief Implementeaza notiunea de moneda.

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        dreptunghiul de coliziune
 */
public class Money extends Character {

    private BufferedImage money;     /*!< Referinta catre imaginea curenta a monedei.*/


    /*! \fn public Money(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructorul de initializare al clasei Money.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a monedei.
        \param y Pozitia initiala pe axa Y a monedei.
        \param width Latimea initiala a monedei.
        \param height Inaltimea initiala a monedei.
     */
    public Money(RefLinks refLinks, float x, float y, int width, int height) {
        ///Apel al constructorului clasei de baza
        super(refLinks, x, y, width, height);
        ///Seteaza imaginea de start a monedei
        money = Assets.money;
    }
    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea monedei.
     */

    @Override
    public void Update() {

    }

    /*! \fn public void Draw(Graphics g)
           \brief Randeaza/deseneaza moneda in noua pozitie.

           \brief g Contextul grafic in care trebuie efectuata desenarea monedei.
        */
    @Override
    public void Draw(Graphics g) {
        g.drawImage(money, (int)x, (int)y, width, height, null);
        //g.drawRect((int) x, (int) y, width, height);
    }

    @Override
    public void Die() {

    }
    /*! \fn public Rectangle GetBounds()
          \brief Returneaza dreptunghiul de coliziune intre moneda si player.
*/
    public Rectangle GetBounds(){
        return new Rectangle((int)x, (int)y, money.getWidth(null),money.getHeight(null));
    }


}
