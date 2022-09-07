package com.Launcher;

import com.GraphicsSwing.Frames.StarterFrame;

public class ProgramLauncher extends Thread{
    private static ProgramLauncher instance=null;
    public static ProgramLauncher getInstance() {
        if(instance==null) instance=new ProgramLauncher();
        return instance;
    }
    private ProgramLauncher(){
        setPriority(10);
    }
    @Override
    public void run(){
        new StarterFrame("AppFonts-Gets your java fonts in code.","By Sebas1705");
    }
    public void launch(){
        start();
    }
}
