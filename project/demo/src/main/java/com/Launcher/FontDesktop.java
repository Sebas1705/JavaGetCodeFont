package com.Launcher;

import java.awt.*;

public class FontDesktop {
    private String[] fonts;
    public FontDesktop() {
        fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    }
    public String[] getFonts() {return fonts;} 
}
