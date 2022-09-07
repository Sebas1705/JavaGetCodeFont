package com.GraphicsSwing.MyComponents;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class MyButton extends JButton{
    
    public MyButton(String text,Font letter,Color foreground,Dimension sizeMax,ActionListener listener){
        super(text);
        setFont(letter);
        setForeground(foreground);
        addActionListener(listener);
        setFocusable(false);
        setBackground(new Color(164, 16, 16));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,
            new Color(122, 10, 10), 
            new Color(122, 10, 10), 
            new Color(67, 14, 14 ), 
            new Color(67, 14, 14 )
        ));
        setMaximumSize(sizeMax);
    }
}
