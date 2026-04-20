package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDownloadDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/upload-download");

        // File Upload

        WebElement uploadElement = driver.findElement(By.id("uploadFile"));
        uploadElement.sendKeys("C:\Users\arun_reddy1\Documents\test.txt");

        // Validate upload
        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        if (uploadedFilePath.getText().contains("sample.txt")) {
            System.out.println("File uploaded successfully!");
        } else {
            System.out.println("File upload failed!");
        }

        // File Download
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        // Wait for download to complete (simple sleep, better to use a proper wait or file existence check)
        Thread.sleep(5000);

        // Verify file downloaded in project directory

        java.io.File downloadedFile = new java.io.File("C:\Users\arun_reddy1\Downloads\sample.png");
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully!");
        } else {
            System.out.println("File download failed!");
        }


        // Clean up
        driver.quit();
    }
}
