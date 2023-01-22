package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserCanSeeCreateSpaceForm {
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
        WebElement createSpace = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[3]/div/div/div[1]/div/div[1]/div[1]/div/div/div/div"));
        createSpace.click();
        // Wait for the page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modal-title:unique-7573389858895452\"]")));
        if(textArea.isDisplayed()){
            System.out.println("Create Space visible");
        }else{
            System.out.println("Create Space NOT visible");
        }
        // Close the browser
        driver.quit();
    }
}
