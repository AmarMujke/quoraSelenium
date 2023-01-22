package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileFollowersTabTest {
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("qu-borderRadius--circle")));


        WebElement profileButton = driver.findElement(By.className("qu-borderRadius--circle"));
        profileButton.click();

        // Wait for the page to load
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement goToProfile = driver.findElement(By.xpath("//a[@class='q-box Link___StyledBox-t2xg9c-0 dFkjrQ puppeteer_test_link qu-display--block qu-px--medium qu-py--small qu-borderBottom qu-color--gray_dark qu-cursor--pointer qu-hover--textDecoration--none']"));
        goToProfile.click();

        // Switch to the new tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        WebElement foll = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div/div[3]/div/div/div[5]/div/div[1]/div"));
        foll.click();

        // Check if Edit tab is loaded
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/followers")) {
            System.out.println("User successfully navigated to the Followers tab");
        } else {
            System.out.println("User failed to navigate to the Followers tab");
        }


        // Close the browser
        driver.quit();
    }
}
