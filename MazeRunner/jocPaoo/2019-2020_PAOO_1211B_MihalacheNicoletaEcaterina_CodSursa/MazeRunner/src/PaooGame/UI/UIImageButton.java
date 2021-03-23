package PaooGame.UI;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

    private BufferedImage[] images;
    private ClickListener cliker;
    public UIImageButton(float x, float y, int width, int height, BufferedImage images[], ClickListener clicker){
        super(x,y,width,height);
        this.images=images;
        this.cliker=clicker;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(Graphics g) {
        if(hovering)
            g.drawImage(images[1], (int)x, (int)y, width,height,null);
        else
            g.drawImage(images[0], (int)x, (int)y, width,height,null);
    }

    @Override
    public void OnClick() {
        cliker.OnClick();
    }

}
