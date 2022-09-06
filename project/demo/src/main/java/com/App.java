package com;

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
        pl.launch(args);
    }
}
