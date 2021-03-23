package PaooGame.States;

import PaooGame.Game;
import PaooGame.Graphics.Assets;
import PaooGame.Items.*;
import PaooGame.Maps.Map;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    EnemyFactory enemy;/*!< Referinta catre o fabrica de monstri.*/
    private Map map;    /*!< Referinta catre harta curenta.*/
    static private boolean gamerun=true;

    int moneyCount=10;  /*!< Numarul de monede de afisat pe ecran.*/
    static ArrayList<Money> money=new ArrayList<Money>();  /*!< Lista de monede.*/
    Random rand=new Random();
    private BufferedImage FinishGame;/*!< Referinta catre imaginea de final de joc.*/
    LinkedList<Enemy> e = EnemyFactory.GetEnemyList();
    private BufferedImage StopGame;

    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLinks)
    {
            ///Apel al constructorului clasei de baza
        super(refLinks);
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul
        hero = new Hero(refLink,0, 912);
        ///Construieste monstrii
        enemy=new EnemyFactory();

        ///Seteaza imaginea de final a jocului
        FinishGame=Assets.FinishGame;
        StopGame= Assets.StopGame;
       //Genereaza random monede pe harta
        for (int k = 0; k < moneyCount; k++) {
            addMoney(new Money(refLink, rand.nextInt(960), rand.nextInt(960), 36, 36));
        }
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        if(this.gamerun != false) {
            map.Update();
            hero.Update();
            enemy.Update();
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g) {
        if(this.gamerun!=false) {
            map.Draw(g);
            hero.Draw(g);
            enemy.Draw(g);
        }
        for(int k=0;k<money.size();k++)
        {
            Money tempMoney=money.get(k);
            tempMoney.Draw(g);
        }
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if((map.MiddleEastMap((int)hero.GetX()/48,(int)hero.GetY()/48)==2) ){
                    this.gamerun=false;
                    if(this.gamerun==false) {
                        g.drawImage(FinishGame, 0, 0, 960, 960, null);
                        g.setColor(Color.white);
                        g.setFont(new Font("verdana", Font.BOLD, 20));
                        g.drawString("GAME OVER", 410, 300);
                    }
                }
                else if( hero.GetBoundsE().intersects(e.get(i).GetBoundsE()))
                {
                    this.gamerun=false;
                    if(this.gamerun==false) {
                        g.drawImage(StopGame, 0, 0, 960, 960, null);
                        g.setColor(Color.white);
                        g.setFont(new Font("verdana", Font.BOLD, 20));
                        g.drawString("GAME OVER", 410, 300);
                    }
                }
            }
        }
    }

    /*! \fn public void addMoney(Money m)
          \brief Adauga monede in lista de monede.
       */
    public void addMoney(Money m){
        money.add(m);
    }

    /*! \fn public void RemoveMoney(Money m)
          \brief Sterge monede din lista de monede.
       */
    public static void RemoveMoney(Money m){
        money.remove(m);
    }

    /*! \fn public static ArrayList<Money> GetMoneyList()
          \brief Imi returneaza o lista de monede.
       */
    public static ArrayList<Money> GetMoneyList(){
    return money;
}
}
