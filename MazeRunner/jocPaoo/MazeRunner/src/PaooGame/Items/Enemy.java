package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;
import PaooGame.States.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Enemy {

    protected float x = 48;                  /*!< Pozitia pe axa X a "tablei" de joc a imaginii entitatii.*/
    protected float y = 48;                  /*!< Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.*/
    protected int width;                /*!< Latimea imaginii entitatii.*/
    protected int height;               /*!< Inaltimea imaginii entitatii.*/
    protected int life;                 /*!< Retine viata caracterului.*/
    public static final int DEFAULT_CREATURE_WIDTH = 48;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 48;   /*!< Inaltimea implicita a imaginii caracterului.*/

    protected float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected Rectangle bounds;         /*!< Dreptunghiul curent de coliziune.*/
    private BufferedImage enemy;
    RefLinks refLink;
    Random rd = new Random();

    /*! \fn public Enemy(RefLinks refLink, float x, float y, int width, int height, int life, float speed)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
        \param life Viata imaginii caracterului.
        \param speed Viteza imaginii caracterului.
     */
    public Enemy(RefLinks refLinks, float x, float y, int width, int height, int life, float speed) {

        this.x = x;             /*!< Retine coordonata pe axa X.*/
        this.y = y;             /*!< Retine coordonata pe axa X.*/
        this.width = DEFAULT_CREATURE_WIDTH;     /*!< Retine latimea imaginii.*/
        this.height = DEFAULT_CREATURE_WIDTH;   /*!< Retine inaltimea imaginii.*/
        this.refLink = refLinks; /*!< Retine the "shortcut".*/
        this.life = life; //Seteaza pe valorile implicite pentru viata
        this.speed = rd.nextInt(9);
        bounds=new Rectangle(0,0,width,height);

        ///Seteaza imaginea de start a monstrului
        enemy = Assets.enemy;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        bounds.x=15;
        bounds.y=18;
        bounds.width=15;
        bounds.height=20;
    }
    /*! \fn public void Update()
           \brief Actualizeaza pozitia si imaginea inamicului.
        */
    public void Update() {
        x -= 3;
    }

    /*! \fn public void Draw(Graphics g)
           \brief Randeaza/deseneaza inamicul in noua pozitie.

           \brief g Contextul grafic in care trebuie efectuata desenarea inamicului.
    */
    public void Draw(Graphics g) {
        g.drawImage(enemy, (int) x, (int) y, width, height, null);
        //g.drawRect((int) (x+bounds.x ), (int) (y+bounds.y ), bounds.width, bounds.height);
    }
    /*! \fn public Rectangle GetBoundsE()
           \brief Returneaza dreptunghiul de coliziune intre inamic si player.
        */
    public Rectangle GetBoundsE(){
        return new Rectangle((int)x, (int)y,48,48);
    }
}
