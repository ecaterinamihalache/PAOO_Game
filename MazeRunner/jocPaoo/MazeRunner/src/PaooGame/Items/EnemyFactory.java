package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.Graphics.ImageLoader;
import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class EnemyFactory {
    static LinkedList<Enemy> e=new LinkedList<Enemy>();

    Enemy TempEnemy;     /*!< Referinta catre un monstru.*/
    RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    Random r=new Random();
    int enemyCount=30;    /*!< Numarul de monstri de generat in joc.*/
    int dx, dy;           /*!< Coordonatele pe axa x si pe axa y a fiecarui monstru.*/

    public EnemyFactory() {
        synchronized (e) {
            for (int k = 0; k < enemyCount; k++) {

                dy = r.nextInt(960);
                dy = dy / 100 * 100 + 10;
                int aux = dx;

                addEnemy(new Enemy(refLink, aux, dy, 48, 48, 5,r.nextInt(9)));
                dx = aux + r.nextInt(960) + 100;
            }
        }
    }
    /*! \fn public void Draw(Graphics g)
              \brief Randeaza/deseneaza inamicii in noua pozitie.

              \brief g Contextul grafic in care trebuie efectuata desenarea inamicii.
       */
    public void Draw(Graphics g){
        for(int i=0;i<e.size();i++){
            TempEnemy=e.get(i);
            TempEnemy.Draw(g);
        }
    }
    /*! \fn public void Update()
              \brief Actualizeaza pozitia si imaginea inamicilor.
           */
    public void Update(){
        for(int i=0;i<e.size();i++){
            TempEnemy=e.get(i);
            TempEnemy.Update();
        }
    }

    /*! \fn public static void addEnemy(Enemy enemy)
              \brief Adauga monstri in lista.
       */
    public static void addEnemy(Enemy enemy){
        e.add(enemy);
    }

    /*! \fn public static LinkedList<Enemy> GetEnemyBounds()
                 \brief Recturneaza pentru fiecare monstru cate un dreptunghi de coliziune.
          */
    public static LinkedList<Enemy> GetEnemyBounds(){
        return e;
    }
    /*! \fn public static LinkedList<Enemy> GetEnemyList()
                 \brief Returneaza lista de monstri.
          */
    public static LinkedList<Enemy> GetEnemyList(){
        return e;
    }

}
