package PaooGame.UI;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected boolean hovering=false;

    public UIObject(float x, float y, int width, int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds=new Rectangle((int)x, (int)y,width,height);
    }
    public abstract void Update();

    public abstract void Draw(Graphics g);

    public abstract void OnClick();

    public void OnMouseMove(MouseEvent e){     //detecteaza daca s-a apasat pe buton sau nu
        if(bounds.contains(e.getX(),e.getY())){
            hovering=true;
        }
        else
        {
            hovering=false;
        }
    }

    public void OnMouseRelease(MouseEvent e){
        if(hovering)
        {
            OnClick();
        }
    }

 /*! \fn public float GetX()
        \brief Intoarce referinta coordonata de pe aza x.
     */
    public float GetX(){
        return x;
    }


    /*! \fn public void SetX(float x)
           \brief Seteaza referinta catre o coordonata pe axa x.

           \param x Referinta catre coordonata de pe axa x.
        */
    public void SetX(float x){
        this.x=x;
    }


    /*! \fn public float GetY()
           \brief Intoarce referinta coordonata de pe aza y.
        */
    public float GetY(){
        return y;
    }
    /*! \fn public void SetY(float y)
           \brief Seteaza referinta catre o coordonata pe axa x.

           \param y Referinta catre coordonata de pe axa x.
        */
    public void SetY(float y){
        this.y=y;
    }


    /*! \fn public float GetWidth()
           \brief Intoarce referinta catre latimea unui obiect.
        */
    public float GetWidth(){
        return width;
    }


    /*! \fn public void SetWidth(int width)
           \brief Seteaza referinta catre latimea unui obiect.

           \param width Referinta catre latimea obiectului.
        */
    public void SetWidth(int width){
        this.width=width;
    }


 /*! \fn public float GetHeight()
        \brief  Intoarce referinta catre inaltimea unui obiect.
     */
    public float GetHeight(){
        return height;
    }


    /*! \fn public void SetHeight(int width)
          \brief Seteaza referinta catre inaltimea unui obiect.

          \param height Referinta catre inaltimea obiectului.
       */
    public void SetHeight(int height){
        this.height=height;
    }

    public boolean GetHovering(){
        return hovering;
    }

    public void SetHovering(boolean hovering){
        this.hovering=hovering;
    }
}
