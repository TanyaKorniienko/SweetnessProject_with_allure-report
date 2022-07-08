package org.sweetness;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserInfoPage extends BasePage{
    public UserInfoPage(ChromeDriver driver) {
        super(driver);
    }

    By openPersonalInfoPageBy = By.xpath("//a[@href='https://sweetness.com.ua/identity']");
    By openUserAddressPageBy = By.xpath("//a[@href='https://sweetness.com.ua/addresses']");

    @Step("Перейти на страницу 'Моя Информация'")
    public PersonalInfo openPersonalInfoPage() {
        driver.findElement(openPersonalInfoPageBy).click();
        return new PersonalInfo((ChromeDriver) driver);
    }
    @Step("Перейти на страницу 'Мои Адреса'")
    public UserAddressPage openUserAddressPage() {
        driver.findElement(openUserAddressPageBy).click();
        return new UserAddressPage((ChromeDriver) driver);
    }
}
