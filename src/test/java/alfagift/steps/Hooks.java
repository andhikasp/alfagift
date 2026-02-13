package alfagift.steps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Hooks {

    // Kita bikin static supaya bisa dipanggil oleh semua Steps (LoginSteps,
    // ProductSteps, dll)
    public static AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        System.out.println(">>> STARTING APPIUM DRIVER... <<<");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setUdid("RRCXA08RNJA");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.alfamart.alfagift");
        options.setAppActivity("com.alfamart.alfagift.feature.auth.pages.onboarding.OnboardingActivity");
        options.setNoReset(true);
        // Timeout & Automation Settings
        options.setNewCommandTimeout(Duration.ofSeconds(3600)); // Biar gak gampang timeout pas debug

        // URL Appium Server (Pastikan server jalan di port 4723)
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // Implicit Wait (Jaga-jaga loading lambat)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        System.out.println(">>> STOPPING DRIVER... <<<");
        if (driver != null) {
            driver.quit(); // Matikan driver biar RAM lega
        }
    }
}