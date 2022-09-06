package com.Launcher;

import java.awt.*;

public class FontDestop {
    private String[] fonts;
    public FontDestop() {
        fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    }
    public String[] getFonts() {return fonts;} 
}
