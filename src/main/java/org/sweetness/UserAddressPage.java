package org.sweetness;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UserAddressPage extends BasePage{
    private final String userAddress = "Saksaganskogo Street 125";
    private final String city = "Kiev";

    public UserAddressPage(ChromeDriver driver) {
        super(driver);
    }

    By addressBy = By.xpath("//input[@id='address1']");
    By cityBy = By.xpath("//input[@id='city']");
    By stateBy = By.xpath("//select[@id='id_state']");
    By submitAddressButtonBy = By.xpath("//button[@id='submitAddress']");
    By addAddressButton = By.xpath("//a[@href='https://sweetness.com.ua/address']");
    @Step("Нажать кнопку Добавить адрес")
    public UserAddressPage clickAddAddressButton() {
        driver.findElement(addAddressButton).click();
        return this;
    }

    public void inputAddress() {
        driver.findElement(addressBy).sendKeys(userAddress);
    }

    public String getAddress() {
        return userAddress;
    }

    public void inputCity() {
        driver.findElement(cityBy).sendKeys(city);
    }

    public String getCity() {
        return city;
    }

    public void selectState() {
        WebElement states = driver.findElement(stateBy);
        Select dropdown = new Select(states);
        dropdown.getOptions().get(2).click();
    }
    @Step("Заполнить форму 'Ваши Адреса' (заполнить поля: Адрес, Город, Область")
    public UserAddressPage addUserAddress() {
        inputAddress();
        inputCity();
        selectState();
        return this;
    }
    @Step("Нажать кнопку 'Сохранить'")
    public UserAddressPage clickSubmitButton() {
        driver.findElement(submitAddressButtonBy).click();
        return this;
    }
}
