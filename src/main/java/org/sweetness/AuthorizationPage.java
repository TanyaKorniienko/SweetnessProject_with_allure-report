package org.sweetness;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class AuthorizationPage extends BasePage{
    private static String emailForNewUser;
    private final String emailOfExistingUser = "elenarobertson37+50@gmail.com";
    private final String password = "555555";

    public AuthorizationPage(ChromeDriver driver) {
        super(driver);
    }

    By userEmailBy = By.xpath("//input[@id='email_create']");
    By createButtonBy = By.xpath("//button[@id='SubmitCreate']");
    By existingUserEmailBy = By.xpath("//input[@id='email']");
    By existingUserPasswordBy = By.xpath("//input[@id='passwd']");
    By loginButtonBy = By.xpath("//button[@id='SubmitLogin']");

    @Step("Заполнить поля 'E-mail' и 'Пароль'")
    public AuthorizationPage enterExistingUserData() {
        driver.findElement(existingUserEmailBy).sendKeys(emailOfExistingUser);
        driver.findElement(existingUserPasswordBy).sendKeys(password);
        return this;
    }

    public String getEmailRandoms() {
        String CHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        while (s.length() < 10) {
            int index = (int) (r.nextFloat() * CHARS.length());
            s.append(CHARS.charAt(index));
        }
        String sStr = "elena" + s.toString() + "@gmail.com";
        return sStr;
    }

    public AuthorizationPage setUserEmail() {
        emailForNewUser = getEmailRandoms();
        driver.findElement(userEmailBy).sendKeys(emailForNewUser);
        return this;
    }

    public String getNew_User_email() {
        return emailForNewUser;
    }

    public String getEmail_Of_existing_User() {
        return emailOfExistingUser;
    }

    public String getPassword_Of_existing_User() {
        return password;
    }

    @Step("Нажать кнопку 'Войти'")
    public UserInfoPage clickSignInButton() {
        driver.findElement(loginButtonBy).click();
        return new UserInfoPage((ChromeDriver) driver);
    }
    @Step("Нажать кнопку 'Создание учетной записи'")
    public RegistrationPage startCreateUserButton() {
        driver.findElement(createButtonBy).click();
        return new RegistrationPage((ChromeDriver) driver);
    }
}
