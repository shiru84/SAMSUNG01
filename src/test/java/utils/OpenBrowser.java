package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

    public static final String ACTIVITY_URL = "https://www.samsung.com/uk/";
    public static final String SKU= "SM-G996BZVDEUA";
    public static final String QTTY = ",1";
    public static final String CART_URL = "https://www.samsung.com/uk/web/cart/?addItem%5B%5D="+SKU+QTTY;
    public static void main(String args[]) throws Exception {

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ACTIVITY_URL);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#truste-consent-button")).click();
        Thread.sleep(2000);

        JavascriptExecutor jse=(JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.get(CART_URL);
        Thread.sleep(4000);
        //

        if (driver.findElement(By.cssSelector("#header > div.seuk-popup-cart--wrap > div > div")).isDisplayed()) {
            System.out.println("Pop up present");
        }else {
            System.out.print("Pop up missing");
        }
        WebElement correctMessage = driver.findElement(By.cssSelector("#header > div.seuk-popup-cart--wrap > div > div > div.seuk-popup-cart--items-holder > div:nth-child(3) > p"));
        String correctMessageValue = correctMessage.getText();

        if(correctMessageValue.contains("Great value\n" +
                "installation packages")) {
            System.out.println("Test passed");
        }else {
            System.out.print("Test failed "+correctMessageValue);
        }
        driver.quit();

    }

}
