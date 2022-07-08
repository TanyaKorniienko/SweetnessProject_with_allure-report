package org.sweetness;

import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AddNewUserInfoTest extends BaseTestClass {

    @Flaky
    @Test
    @Description("Добавление персональной информации для существующего пользователя.")
    @Severity(SeverityLevel.NORMAL)
    public void updateUserInfo() {
        HomePage homePage = new HomePage((ChromeDriver) driver);
        new HomePage((ChromeDriver) driver).clickLoginButton();

        AuthorizationPage authorizationPage = new AuthorizationPage((ChromeDriver) driver);
        new AuthorizationPage((ChromeDriver) driver)
                .enterExistingUserData()
                .clickSignInButton();

        UserInfoPage userInfoPage = new UserInfoPage((ChromeDriver) driver);
        new UserInfoPage((ChromeDriver) driver).openPersonalInfoPage();

        PersonalInfo personalInfo = new PersonalInfo((ChromeDriver) driver);
        new PersonalInfo((ChromeDriver) driver)
                .addUserInfo()
                .saveAddedInfo();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://sweetness.com.ua/identity");
        assertThat(authorizationPage.getEmail_Of_existing_User()).isEqualTo("elenarobertson37+50@gmail.com");
        assertThat(authorizationPage.getPassword_Of_existing_User()).isEqualTo("555555");
        assertThat(personalInfo.getSelectedYear().strip()).isEqualTo("2020");
        assertThat(personalInfo.getSuccessMessage()).isEqualTo("Ваша персональная информация обновлена.");
    }

}
