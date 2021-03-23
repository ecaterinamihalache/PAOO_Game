package PaooGame.Graphics;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;

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

    public static BufferedImage[] buton_start;
    public static BufferedImage grass;
    public static BufferedImage maze;


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init() {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        grass = ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png");
        maze = ImageLoader.LoadImage("/textures/PaooGameSpriteSheet1.jpg");
/*
      SpriteSheet sheet1 = new SpriteSheet(ImageLoader.LoadImage("/textures/p1.jpg"));
        heroLeft = sheet1.crop(0, 0);
        heroRight = sheet1.crop(2, 2);
        heroFront = sheet1.crop(1, 1);
        heroBack = sheet1.crop(1, 3);
        */


       heroLeft=ImageLoader.LoadImage("/textures/player_sprite_l.png");
        heroRight=ImageLoader.LoadImage("/textures/player_sprite_r.png");
        heroFront=ImageLoader.LoadImage("/textures/player_sprite_f.png");
        heroBack=ImageLoader.LoadImage("/textures/player_sprite_b.png");

        buton_start=new BufferedImage[2];
        buton_start[0]=ImageLoader.LoadImage("/textures/menustart_1.png");
        buton_start[1]=ImageLoader.LoadImage("/textures/menustart_2.png");
        //buton_start[1]=ImageLoader.LoadImage("/textures/menustart_2.png");



/*
        heroLeft=ImageLoader.LoadImage("/textures/sprite_sheet_left.png");
        heroRight=ImageLoader.LoadImage("/textures/sprite_sheet_right.png");
        heroFront=ImageLoader.LoadImage("/textures/sprite_sheet_front.png");
        heroBack=ImageLoader.LoadImage("/textures/sprite_sheet_back.png");



 */
        //player=ImageLoader.LoadImage("/textures/PaooGameSpriteSheet2.jpg");
        /*grass = sheet.crop(0, 0);
        soil = sheet.crop(1, 0);
        water = sheet.crop(2, 0);
        */
    }
}
