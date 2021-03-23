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

    public void OnMouseMove(MouseEvent e){ //detecteaza daca s-a apasat pe buton sau nu
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
    //Getters and setters

    public float GetX(){
        return x;
    }

    public void SetX(float x){
        this.x=x;
    }

    public float GetY(){
        return y;
    }

    public void SetY(float y){
        this.y=y;
    }


    public float GetWidth(){
        return width;
    }

    public void SetWidth(int width){
        this.width=width;
    }


    public float GetHeight(){
        return height;
    }

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
