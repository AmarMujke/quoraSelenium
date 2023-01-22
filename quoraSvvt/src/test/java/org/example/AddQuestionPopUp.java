package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddQuestionPopUp {
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
        WebElement addPost = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[1]/div/div/div[1]/div/div[2]"));
        addPost.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("textarea.q-text-area.qu-fontSize--large.qu-lineHeight--regular.TextInput___StyledTextArea-sc-9srrla-1.idHrmV.puppeteer_test_selector_input")));
        if(textArea.isDisplayed()){
            System.out.println("Can see add question field");
        }else{
            System.out.println("Can not see add question field");
        }
        // Close the browser
        driver.quit();
    }
}
