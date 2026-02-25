package org.example.DesignPatterns.StrategyPattern;

public class CameraPlusApp extends PhoneCameraApp {

    @Override
    public void editPhoto() {
        System.out.println("Editing photo with Advanced Editor");
    }
}