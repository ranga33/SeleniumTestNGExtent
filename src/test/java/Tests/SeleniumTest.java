package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SeleniumTest {

    public static WebDriver driver;
    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");
        extent.attachReporter(spark);
        HomePage.click_hamburger_menu();
        HomePage.click_onlineProducts_link();

    }

    public static String capture(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("src/../ExecImages/" + System.currentTimeMillis() + ".png");
        String errflpath = dest.getAbsolutePath();
        FileUtils.copyFile(src, dest);
        return errflpath;

    }

    @Test
    void ValidateTitles_OnlineProducts() throws InterruptedException, IOException {

        test = extent.createTest("Validate Shoe Titles on products Page", "This test validates the different shoe types");
        ProductsPage.formalShoes_verifyTitle();
        ProductsPage.sportsShoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();

    }

    @Test
    void validateFirstFormalShoes(){

        test = extent.createTest("Validate First Formal Shoename");
        ProductsPage.formalShoes_FirstShoe_Verify();

    }

    @Test
    void validateFirstSportsShoes(){

        test = extent.createTest("Validate Second Formal Shoename");
        ProductsPage.sportsShoes_FirstShoe_Verify();

    }

    @AfterSuite
    public static void cleanup(){

        extent.flush();
        driver.quit();
    }


}
