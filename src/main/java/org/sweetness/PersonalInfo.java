package org.sweetness;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PersonalInfo extends BasePage{
    private final String passwordOld = "555555";
    private static String selectedYear;

    public PersonalInfo(ChromeDriver driver) {
        super(driver);
    }

    By genderBy = By.xpath("//input[@id='id_gender1']");
    By daysBy = By.xpath("//select[@id='days']");
    By monthsBy = By.xpath("//select[@id='months']");
    By yearsBy = By.xpath("//select[@id='years']");
    By passwordOldBy = By.xpath("//input[@id='old_passwd']");
    By saveInfoButtonBy = By.xpath("//button[@name='submitIdentity']");
    By congratulationsBy = By.xpath("//p[(contains(text(), ' Ваша персональная информация обновлена.'))]");

    @Step("Заполнить форму персональной информации (добавить пол, выбрать дату рождения(дд-мм-гг), ввести пароль")
    public PersonalInfo addUserInfo() {
        driver.findElement(genderBy).click();
        setDay();
        setMonth();
        setYear();
        driver.findElement(passwordOldBy).sendKeys(passwordOld);
        return this;
    }

    public void setDay() {
        WebElement days = driver.findElement(daysBy);
        Select dropdown = new Select(days);
        dropdown.getOptions().get(1).click();
    }

    public void setMonth() {
        WebElement months = driver.findElement(monthsBy);
        Select dropdown = new Select(months);
        dropdown.getOptions().get(2).click();
    }

    public void setYear() {
        WebElement years = driver.findElement(yearsBy);
        Select dropdown = new Select(years);
        dropdown.selectByIndex(3);
        selectedYear = dropdown.getFirstSelectedOption().getText();
    }

    public String getSelectedYear() {
        return selectedYear;
    }

    public String getSuccessMessage() {
        return driver.findElement(congratulationsBy).getText();
    }
    @Step("Нажать кнопку 'Сохранить'")
    public PersonalInfo saveAddedInfo() {
        driver.findElement(saveInfoButtonBy).click();
        return new PersonalInfo((ChromeDriver) driver);
    }
}
