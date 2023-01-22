package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UserCanSwitchToNotifications {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Navigate to Quora
        driver.get("https://www.quora.com/");

        // Find the email/username field and enter the login credentials
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.sendKeys("amar.mujkic1@stu.ibu.edu.ba");

        // Find the password field and enter the login credentials
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys("svvtQP1!");

        // Find the login submit button and click it
        WebElement loginSubmitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div[2]/div[2]/div[4]/button"));
        loginSubmitButton.click();

        // Wait for the page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on the "Notifications" button
        WebElement notifications = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div/a[4]"));
        notifications.click();

        // Wait for the page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the user is on the Topics page
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/notifications")) {
            System.out.println("User successfully navigated to the Notifications page");
        } else {
            System.out.println("User FAILED to navigate to the Notifications page");
        }

        // Close the browser
        driver.quit();
    }
}
