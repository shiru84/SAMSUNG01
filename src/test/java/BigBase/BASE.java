package BigBase;

import jakarta.validation.constraints.Null;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import static BigBase.BASErunner.*;

public class BASE {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static WebDriver driver ;
    static String TEXT;
    static FileOutputStream fos;
    static String projectPath = System.getProperty("user.dir");
    static FileInputStream fis;
    static String XLS = "/exel/406/data.xlsx";
    static String FILE = projectPath + XLS;
    static Row row;
    static WebElement okThanks;
    static WebElement removeButton;

    static int TESTING_ROW = 0;
    static int TESTING_URL_CELL = 1;
    static int TESTING_DATA_CEL = 3;
    static int TEST_RESULT_CEL =  2;
    static int TESTING_ITEM_URL_CELL = 4;
    static int n;
    static int TEST_RESULT_CEL2 = 12;
//    static WebElement okThanks = driver.findElement(By.cssSelector("#header > div.seuk-popup-cart--wrap > div > div > div.seuk-popup-cart--info > span"));
//    static WebElement removeButton = driver.findElement(By.cssSelector("#app > div.site-wrapper.siteHeader.scrollHeight > main > div > div > div.container.checkout-cart-page-holder.page-holder > div.grid > div.shopping-cart-holder > div.shopping-cart-items-holder.cart-items > div:nth-child(2) > div > div.sc-product-meta-details > div.sc-product-details > div.sc-product-meta-data > p > span.for-desktop.data-omni-remove > button\n"));

//    static int TESTING_ROW;
//    static int TESTING_URL_CELL;
//    static int TESTING_DATA_CEL;
//    static int TEST_RESULT_CEL;
//    static int TESTING_ITEM_URL_CELL;
//    static int n;

    public static void main(String[] args) throws Exception {

        n = 1;
//        openBrowser();
//        testIfInStock(TESTING_ROW + n, TEST_RESULT_CEL2);
        for (int i = 0; i < 31; i++) {
            activityTest();
        }
        System.out.println("all done now!");
//        quit();

    }

    public static void activityTest() throws Exception {
        openBrowser();
        goToPage(TESTING_ROW + n, TESTING_ITEM_URL_CELL);
        Thread.sleep(1000);
        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
//        Thread.sleep(1000);
        expectedTEXT(TESTING_ROW + n, TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW + n, TEST_RESULT_CEL);
        removeItemFromCart(TESTING_ROW + n, TEST_RESULT_CEL);
        System.out.println(n);
        n = n + 1;
        quit();

    }
    public static void testIfInStock(int rowNum, int colNum) throws IOException,InterruptedException{
        if (driver.getPageSource().contains("Remove")) {

            System.out.println("item is in stock");

        } else {
            System.out.println("OOS");
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("Not Available");
            System.out.println("Not Available");
            writeFile(workbook, FILE);
        }
    }

    public static void triggerPopup () {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/main/div/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div[1]/p[2]/a")).click();
    }
    public static void findOkThanks(){
        try {
            okThanks = driver.findElement(By.cssSelector("#header > div.seuk-popup-cart--wrap > div > div > div.seuk-popup-cart--info > span"));
            System.out.println(okThanks.getText()+" - FOUND");
        }catch (Exception e) {
            System.out.println("ok, thanks - Not FOUND");

        }
    }
    public static void findRemoveButton(){
       try {
          removeButton = driver.findElement(By.cssSelector("#app > div.site-wrapper.siteHeader.scrollHeight > main > div > div > div.container.checkout-cart-page-holder.page-holder > div.grid > div.shopping-cart-holder > div.shopping-cart-items-holder.cart-items > div:nth-child(2) > div > div.sc-product-meta-details > div.sc-product-details > div.sc-product-meta-data > p > span.for-desktop.data-omni-remove > button\n"));
           System.out.println(removeButton.getText()+" - FOUND");
       }catch (Exception e){System.out.println("Remove - Not FOUND");}
    }
    public static void clickOkThanks(){
            WebElement okThanks = driver.findElement(By.cssSelector("#header > div.seuk-popup-cart--wrap > div > div > div.seuk-popup-cart--info > span"));
            System.out.println(okThanks.getText()+" - FOUND");
        okThanks.click();
    }
    public static void clickRemoveButton() {
            WebElement removeButton = driver.findElement(By.cssSelector("#app > div.site-wrapper.siteHeader.scrollHeight > main > div > div > div.container.checkout-cart-page-holder.page-holder > div.grid > div.shopping-cart-holder > div.shopping-cart-items-holder.cart-items > div:nth-child(2) > div > div.sc-product-meta-details > div.sc-product-details > div.sc-product-meta-data > p > span.for-desktop.data-omni-remove > button\n"));
System.out.println(removeButton.getText()+" - FOUND");
removeButton.click();
    }

    public static void removeItemFromCart(int rowNum, int colNum) throws IOException, InterruptedException {
        driver.get("https://www.samsung.com/uk/web/cart/");
        Thread.sleep(4000);
        findRemoveButton();
        findOkThanks();
        if (okThanks != null) {
//                driver.getPageSource().contains("Ok, thanks")) {
            System.out.println("Ok, thanks ???");
            okThanks.click();
            System.out.println("Ok, thanks - Clicked");
            Thread.sleep(2000);
            removeButton.click();
            System.out.println("Removed!");
            Thread.sleep(2000);
//            clickOkThanks();
//           clickRemoveButton();

        } else { try {
//            if (removeButton !=null) {
//(driver.getPageSource().contains("Remove"))
                System.out.println("Remove ???");
//                clickRemoveButton();
                removeButton.click();
                System.out.println("Removed!!");
            } catch (Exception e) {
            System.out.println("OOS");
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("Not Available");
            writeFile(workbook, FILE);
        }
            }
        }



    public static void openBrowser() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void goToPage( int rowNum, int cellNum) throws Exception {
        try {
            workbook = new XSSFWorkbook(FILE);
            sheet = workbook.getSheetAt(0);
            URL = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        driver.get(URL);
        System.out.println("URL found");}
    public static void getN(int rowNum, int cellNum) {
        try {
            sheet = workbook.getSheetAt(0);
            n = (int) sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static void writeFile(XSSFWorkbook workbook,String FILE ) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream(FILE);
        workbook.write(fos);
        fos.close();
        workbook.close();
        System.out.println("File Writen");
    }

    public static void expectedTEXT ( int rowNum, int colNum){
        try {
            sheet = workbook.getSheetAt(0);
            TEXT = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            System.out.println(TEXT);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
    public static void findExpectedText(String TT, int rowNum, int colNum) throws IOException, InterruptedException{

        if (driver.getPageSource().contains(TT)){
            System.out.println("Founud -  "+TEXT);
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("PASS");
        }else {
            System.out.println("NOT Founud  -  "+TEXT);
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("FAIL");
        }
        writeFile(workbook, FILE);
    }
    public static void quit(){
        driver.quit();
    }



}
