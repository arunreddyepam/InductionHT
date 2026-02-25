package org.example.DesignPatterns.StrategyPattern;

public class BasicCameraApp extends PhoneCameraApp {

    @Override
    public void editPhoto() {
        System.out.println("Editing photo with Basic Editor");
    }
}