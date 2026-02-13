package alfagift.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BerandaPage {
    AndroidDriver driver;
    By akunIcon = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.alfamart.alfagift:id/tv_label_account\")");
    By memberNameText = AppiumBy.id("com.alfamart.alfagift:id/tv_member_name");
    By clickSearch = AppiumBy.id("com.alfamart.alfagift:id/iv_search");
    By editSearch = AppiumBy.id("com.alfamart.alfagift:id/edt_search");


    public void clickSearch() {
        driver.findElement(clickSearch).click();
    }
    public void filleditSearch(String search) {
        driver.findElement(editSearch).sendKeys(search);
    }
    public BerandaPage(AndroidDriver driver) {
        this.driver = driver;
    }
    public void validateLoginSuccess() {
        System.out.println("Menunggu loading Home Page...");
//        delay(5);

        String actualText = driver.findElement(memberNameText).getText();
        System.out.println("Teks yang muncul: " + actualText);

        Assert.assertTrue("Login Gagal! Teks sapaan tidak muncul.",
                actualText.contains("Hai"));
    }
    public void clickSearchButtonOnKeyboard() {
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

public void clickProductByName(String productName) {
    System.out.println("Mencari produk: " + productName);

    String searchKeyword = productName.split(" ")[0] + " " + productName.split(" ")[1];

    try {

        String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true).instance(1))" +
                ".scrollIntoView(new UiSelector().textContains(\"" + searchKeyword + "\"));";

        driver.findElement(AppiumBy.androidUIAutomator(scrollCommand));
        System.out.println("Scroll Berhasil di List Produk!");

    } catch (Exception e) {
        System.out.println("Gagal scroll di instance 1, mencoba instance 0 (backup)...");
        try {
            String scrollCommandBackup = "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                    ".scrollIntoView(new UiSelector().textContains(\"" + searchKeyword + "\"));";
            driver.findElement(AppiumBy.androidUIAutomator(scrollCommandBackup));
        } catch (Exception ex) {
        }
    }
    String xpath = "//android.widget.TextView[contains(@text, '" + productName + "')]" +
            "/ancestor::android.widget.FrameLayout[contains(@resource-id, 'card_product')]";

    driver.findElement(AppiumBy.xpath(xpath)).click();
}
    public void validateProductDetailPage() {
        System.out.println("Memvalidasi halaman detail produk...");
        try {
            String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                    ".scrollIntoView(new UiSelector().text(\"Deskripsi\"));";

            driver.findElement(AppiumBy.androidUIAutomator(scrollCommand));
        } catch (Exception e) {
            System.out.println("Gagal scroll ke Deskripsi (Mungkin sudah terlihat?): " + e.getMessage());
        }
        By deskripsiTitle = AppiumBy.androidUIAutomator("new UiSelector().text(\"Deskripsi\")");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(deskripsiTitle)).isDisplayed();

        Assert.assertTrue("Gagal! Tulisan 'Deskripsi' tidak ditemukan di halaman detail.", isDisplayed);
        System.out.println("Sukses! Berada di Product Detail Page.");
    }


//    public void delay(int detik) {
//        try {
//            Thread.sleep(detik * 1000);
//        } catch (InterruptedException e) {
//
//            e.printStackTrace();
//        }
//    }
}

