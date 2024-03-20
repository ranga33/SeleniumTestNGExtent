package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;

public class ProductsPage {

    public static String formalShoes_xpath = "/html/body/div[2]/center/h2";
    public static String sportsShoes_xpath = "/html/body/div[3]/center/h2";
    public static String sneakers_xpath = "/html/body/div[4]/center/h2";
    public static String formalShoesDropdown_xpath =  "/html/body/div[2]/center/div/i[1]";
    public static String sportsShoesDropdown_xpath = "/html/body/div[3]/center/div/i[1]";
    public static String sneakersDropdown_xpath = "/html/body/div[2]/center/div/i[1]";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";

    public static String sportsShoes_firstShowName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";

    public static void formalShoes_verifyTitle() throws IOException {

        String expectedTitleFS = "Formal Shoes";
        String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText().trim();
        Assert.assertEquals(actualTitleFS, expectedTitleFS);
        if(expectedTitleFS.equals(actualTitleFS)){
            test.log(Status.PASS, "Test Passed for title verification");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed");
        }else{
            test.log(Status.FAIL, "Test Failed for title verification");
        }

    }

    public static void sportsShoes_verifyTitle(){

        String expectedTitleSS = "Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportsShoes_xpath)).getText().trim();
        Assert.assertEquals(actualTitleSS, expectedTitleSS);

    }
    public static void sneakers_verifyTitle(){

        String expectedTitleSn = "Sneakers";
        String actualTitleSn = driver.findElement(By.xpath(sneakers_xpath)).getText().trim();
        Assert.assertEquals(actualTitleSn, expectedTitleSn);

    }
    public static void formalShoes_FirstShoe_Verify(){

        driver.findElement(By.xpath(formalShoesDropdown_xpath)).click();
        String expectedFirstFormalShoe = "Classic Cheltenham";
        String actualFirstFormalShoe = driver.findElement(By.xpath(formalShoes_firstShoeName)).getText().trim();
        Assert.assertEquals(actualFirstFormalShoe, expectedFirstFormalShoe);
    }
    public static void sportsShoes_FirstShoe_Verify(){

        driver.findElement(By.xpath(sportsShoesDropdown_xpath)).click();
        String expectedFirstSportsShoe = "Ultimate";
        String actualFirstSportsShoe = driver.findElement(By.xpath(sportsShoes_firstShowName)).getText().trim();
        Assert.assertEquals(actualFirstSportsShoe, expectedFirstSportsShoe);

    }
    public static void sneakers_FirstShoe_Verify(){

        driver.findElement(By.xpath(sneakersDropdown_xpath)).click();
        String expectedFirstSneakers = "Archivo";
        String actualFirstSneakers = driver.findElement(By.xpath(sneakers_xpath)).getText().trim();
        Assert.assertEquals(actualFirstSneakers, expectedFirstSneakers);

    }
    public static void formalShoes_firstShoeName_getTitle(){

    }
    public static void sportsShoes_firstShoeName_getTitle(){

    }
}
