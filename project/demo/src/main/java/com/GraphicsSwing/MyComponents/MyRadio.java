package com.GraphicsSwing.MyComponents;

import java.awt.*;
import javax.swing.*;

public class MyRadio extends JRadioButton{
    public MyRadio(String text,Font font,Color foreground) {
        super(text);
        setFont(font);
        setForeground(foreground);
        setFocusable(false);
        setOpaque(false);
    }
}
