package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {
    public static void main(String[] args) {
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Quora.com
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

        Duration timeout = Duration.ofSeconds(10); // set the timeout to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div/form/div/div/div/div/div/input")));

        // Enter the search term
        searchInput.sendKeys("What is selenium");
        searchInput.sendKeys(Keys.ENTER);


        // Wait for the page to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find the first answer and print its text
        WebElement firstAnswer = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[1]/div/div[1]/div/span"));
        String firstAnswerText = firstAnswer.getText();
        if (firstAnswerText.equals("What is selenium")){
            System.out.println("test passed");
        }
        System.out.println(firstAnswerText);

        // Close the browser
        driver.quit();
    }
}
