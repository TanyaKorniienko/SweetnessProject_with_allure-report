package org.sweetness;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BasePage {

    public HomePage(ChromeDriver driver) {
        super(driver);
    }
    By loginButtonBy = By.xpath("//nav/div[@class='header_user_info']/a[@href='https://sweetness.com.ua/my-account']");

    @Step("Нажать кнопку-стрелку 'Войти в учетную запись' в левом верхнем углу")
    public AuthorizationPage clickLoginButton() {
        driver.findElement(loginButtonBy).click();
        return new AuthorizationPage((ChromeDriver) driver);
    }
}
