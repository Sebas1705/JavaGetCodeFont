package com;

import java.awt.*;

import com.GraphicsSwing.Frames.MainFrame;
import com.GraphicsSwing.Frames.StarterFrame;
import com.Launcher.ProgramLauncher;

/**
 * Hello world!
 */
public final class App {
    
    private static ProgramLauncher pl = new ProgramLauncher();

    /**
     * @version 1.0
     * @param args : String[] of arguments.
     */
    public static void main(String[] args) {
        //new StarterFrame("TituloPrincipal","TituloSecundario");
        new MainFrame();
        //pl.launch(args);
    }
}
