package PaooGame.Input;

import PaooGame.UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {
    private boolean lPressed;       //Mouse-ul a fost apasat pe butonul stang
    private boolean rPressed;       //Mouse-ul a fost apasat pe butonul drept
    private int mouseX, mouseY;     //pozitia mouse-ului pe ecran
    private UIManager uiManager;

    public MouseManager(){

    }
    public void SetUiManager(UIManager uiManager){
            this.uiManager=uiManager;
    }
    //Getters

    public boolean IsLeftPressed(){
        return lPressed;
    }

    public boolean IsRightPressed(){
        return rPressed;
    }

    public int GetMouseX(){
        return mouseX;
    }

    public int GetMouseY(){
        return mouseY;
    }

    //Implemented methods
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1) {//butonul din stanga
            lPressed = true;
        }
        else if(e.getButton()==MouseEvent.BUTTON3)//butonul din dreapta
        {
            rPressed=true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==MouseEvent.BUTTON1) {
            lPressed = false;
        }
        else if(e.getButton()==MouseEvent.BUTTON3)
        {
            rPressed=false;
        }
        if(uiManager != null)
        {
            uiManager.OnMouseRelease(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        if(uiManager != null)
        {
            uiManager.OnMouseMove(e);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
