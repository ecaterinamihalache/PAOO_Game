package PaooGame.Items;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;

import PaooGame.Game;
import PaooGame.Input.KeyManager;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
import PaooGame.States.MenuState;
import PaooGame.States.PlayState;

import static java.lang.System.exit;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage player;    /*!< Referinta catre imaginea curenta a eroului.*/
    private static int CountMoney=0;/*!< Referinta catre scorul jocului.*/
    private LinkedList<Enemy> e=EnemyFactory.GetEnemyBounds();/*!< Referinta catre lista de monstri.*/

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

            ///Seteaza imaginea de start a eroului
        player = Assets.heroFront;
        ///Seteaza imaginea de final a jocului

            ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        bounds.x=15;
        bounds.y=18;
        bounds.width=15;
        bounds.height=20;
    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
            ///Verifica daca a fost apasata o tasta
            GetInput();
            ///Actualizeaza pozitia
            Move();

            ///Actualizeaza imaginea
            if (refLink.GetKeyManager().left == true) {
                player = Assets.heroLeft;

            }
            if (refLink.GetKeyManager().right == true) {
                player = Assets.heroRight;
            }
            if (refLink.GetKeyManager().up == true) {
                player = Assets.heroBack;
            }
            if (refLink.GetKeyManager().down == true) {
                player = Assets.heroFront;
            }
            //Actualizeaza coliziunile
            CheckColisions();


    }


    @Override
    public void Die(){

    }
    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
        ///Verificare apasare tasta "space"
        if(refLink.GetKeyManager().space)
        {
            xMove = 0;
            yMove = 0;
            CountMoney= 0;
        }
            ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up)
        {
                yMove = -speed;

        }
            ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
        }
            ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
        }
            ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafic in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {
            g.drawImage(player, (int) x, (int) y, width, height, null);
            //g.drawRect((int)x, (int)y, player.getWidth(null),player.getHeight(null));

            ///doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
            //g.setColor(Color.red);
            //g.fillRect((int)(x+bounds.x ),(int)(y+bounds.y) , bounds.width , bounds.height);
            g.setColor(Color.green);
            g.setFont(new Font("vedana", Font.PLAIN, 12));
            g.drawString("Score: " + CountMoney + "/10", 0, 10);
    }


 /*! \fn public Rectangle GetBounds()
           \brief Returneaza dreptunghiul de coliziune intre player si moneda.
 */
    public Rectangle GetBounds(){
        return new Rectangle((int)x, (int)y, player.getWidth(null),player.getHeight(null));
    }


    /*! \fn public Rectangle GetBoundsE()
          \brief Returneaza dreptunghiul de coliziune intre player si inmaic.
       */
    public Rectangle GetBoundsE(){
        return new Rectangle((int)x, (int)y,48, 48);
    }


    /*! \fn public  void CheckColisions()
         \brief Genereaza coliziunea dintre player si monede.
      */
    public void CheckColisions(){
        ArrayList<Money> money = PlayState.GetMoneyList();

        for(int i=0;i<money.size();i++){
            Money tempMoney=money.get(i);
            if(GetBounds().intersects(tempMoney.GetBounds())){
                    PlayState.RemoveMoney(tempMoney);
                    CountMoney++;
            }
        }
    }
}
