package PaooGame.Graphics;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.nio.BufferOverflowException;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage heroFront;
    public static BufferedImage heroBack;
    public static BufferedImage enemy;
    public static BufferedImage money;
    public static BufferedImage[] buton_start;
    public static BufferedImage buton_restart;
    public static BufferedImage buton_exit;
    public static BufferedImage StopGame;
    public static BufferedImage menub;
    public static BufferedImage grass;
    public static BufferedImage maze;
    public static BufferedImage start;
    public static BufferedImage finish;
    public static BufferedImage FinishGame;
    public static int levels;

    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {

        /// Se creaza un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        grass = ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png");
        maze = ImageLoader.LoadImage("/textures/PaooGameSpriteSheet1.jpg");
        start=ImageLoader.LoadImage("/textures/start.png");
        finish=ImageLoader.LoadImage("/textures/Finish.png");
        heroLeft=ImageLoader.LoadImage("/textures/player_sprite_l.png");
        heroRight=ImageLoader.LoadImage("/textures/player_sprite_r.png");
        heroFront=ImageLoader.LoadImage("/textures/player_sprite_f.png");
        heroBack=ImageLoader.LoadImage("/textures/player_sprite_b.png");
        money=ImageLoader.LoadImage("/textures/money.png");
        enemy=ImageLoader.LoadImage("/textures/enemy12.png");
        buton_start=new BufferedImage[2];
        buton_start[0]=ImageLoader.LoadImage("/textures/menustart_1.png");
        buton_start[1]=ImageLoader.LoadImage("/textures/menustart_2.png");
        buton_restart=ImageLoader.LoadImage("/textures/buton_restart.png");
        buton_exit=ImageLoader.LoadImage("/textures/buton_exit.png");
        StopGame=ImageLoader.LoadImage("/textures/loser.png");
        menub=ImageLoader.LoadImage("/textures/manugame2.png");
        FinishGame=ImageLoader.LoadImage("/textures/FinishGame.png");
    }
}
