package org.example.DesignPatterns.StrategyPattern;

public abstract class PhoneCameraApp {

    private ShareStrategy shareStrategy;

    public void setShareStrategy(ShareStrategy shareStrategy) {
        this.shareStrategy = shareStrategy;
    }

    public void takePhoto() {
        System.out.println("Taking photo...");
    }

    public abstract void editPhoto();   // Different for each variant

    public void savePhoto() {
        System.out.println("Saving photo...");
    }

    public void performShare(String photo) {
        if (shareStrategy != null) {
            shareStrategy.share(photo);
        } else {
            System.out.println("No sharing strategy selected!");
        }
    }
}