package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HidePostTest {
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

        // Click hide svg
        WebElement hideButton = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[2]/div/div/div/div/div/div/div/div[1]/div[1]"));
        hideButton.click();

        // Check if post is now hidden
        WebElement textAfterHiding = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[2]"));
        String txt = textAfterHiding.getText();
        if (txt.contains("Undo")) {
            System.out.println("Success");
        } else {
            System.out.println("Test failed");
        }

        // Close the browser
        driver.quit();
    }
}

