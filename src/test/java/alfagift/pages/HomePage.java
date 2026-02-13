package alfagift.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage {
    AndroidDriver driver;
    By phonenumberOrMemberCard = AppiumBy.className("android.widget.EditText");
    By masuk = AppiumBy.androidUIAutomator("new UiSelector().text(\"Masuk\")");
    By insertPassword = AppiumBy.className("android.widget.EditText");
    By masuk2 = AppiumBy.androidUIAutomator("new UiSelector().text(\"Masuk\").instance(1)");
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phonenumberOrMemberCard).sendKeys(phoneNumber);
    }
    public void enterMasukOrDaftar() {
        driver.findElement(masuk).click();
    }
    public void enterpassword(String password) {
        driver.findElement(insertPassword).sendKeys(password);
    }
    public void enterMasukOrDaftar2() {
        driver.findElement(masuk2).click();
    }


}
