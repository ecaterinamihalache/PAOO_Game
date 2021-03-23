package PaooGame.UI;

import PaooGame.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {
    private RefLinks refLinks;
    private ArrayList<UIObject> objects;

    public UIManager(RefLinks refLinks){
        this.refLinks=refLinks;
        objects=new ArrayList<UIObject>();
    }

    public void Update(){
        for(UIObject o:objects)
            o.Update();
    }

    public void Draw(Graphics g){
        for(UIObject o:objects)
            o.Draw(g);
    }
    public void OnMouseMove(MouseEvent e){
        for(UIObject o:objects)
            o.OnMouseMove(e);
    }
    public void OnMouseRelease(MouseEvent e){
        for(UIObject o:objects)
            o.OnMouseRelease(e);
    }
    public void AddObject(UIObject o){
        objects.add(o);
    }
    public void RemoveObject(UIObject o){
        objects.remove(o);
    }
}
