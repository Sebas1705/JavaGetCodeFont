package com.GraphicsSwing.Components;

import javax.swing.JPanel;
import java.awt.*;

public class PanelWithBackImage extends JPanel{
    
    Toolkit tk = Toolkit.getDefaultToolkit();
    Image back;

    public PanelWithBackImage(String urlImage){
        super();
        back=tk.getImage(urlImage);
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(back,getX(),getY(),getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}
