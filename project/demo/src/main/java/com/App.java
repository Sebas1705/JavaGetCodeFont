package com;

import com.Launcher.ProgramLauncher;

public final class App {
    private static ProgramLauncher pl = ProgramLauncher.getInstance();
    /**
     * @version 1.0
     * @param args : String[] of arguments.
     */
    public static void main(String[] args) {
        pl.launch();
    }
}
