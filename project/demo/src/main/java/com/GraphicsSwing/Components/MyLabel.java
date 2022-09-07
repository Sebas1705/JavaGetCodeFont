package com.GraphicsSwing.Components;

import java.awt.*;
import javax.swing.*;

public class MyLabel extends JLabel{

    public MyLabel(String text,Font letter,Color foreground,Dimension sizeMax){
        super(text);
        setFont(letter);
        setForeground(foreground);
        setFocusable(false);
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());
        setMaximumSize(sizeMax);
    }
}
