package org.sweetness;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{
    private String firstName = "Elena";
    private String lastName = "Robertson";
    private String new_user_password = "123456";

    public RegistrationPage(ChromeDriver driver) {
        super(driver);
    }

    By firstNameBy = By.xpath("//input[@id='customer_firstname']");
    By lastNameBy = By.xpath("//input[@id='customer_lastname']");
    By passwordBy = By.xpath("//input[@type='password']");
    By submitButtonBy = By.xpath("//button[@id ='submitAccount']");

    @Step("Заполнить поля формы регистрации: Имя, Фамилия, Пароль")
    public RegistrationPage enterNewUserData() {
        driver.findElement(firstNameBy).sendKeys(firstName);
        driver.findElement(lastNameBy).sendKeys(lastName);
        driver.findElement(passwordBy).sendKeys(new_user_password);
        return this;
    }
    public String getNewUserPassword() {
        return new_user_password;
    }

    public String getLastName() {
        return lastName;
    }
    @Step("Нажать кнопку 'Зарегистрироваться'")
    public UserInfoPage submitUserRegistration() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButtonBy)).click();
        return new UserInfoPage((ChromeDriver) driver);
    }
}
