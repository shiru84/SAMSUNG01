package UKOTFindTextExcell;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UKOT344b {


    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static WebDriver driver;
    static String projectPath = System.getProperty("user.dir");
    static FileInputStream fis;
    static String XLS = "/exel/UKOT344/data.xlsx";
    static String FILE = projectPath + XLS;
    static Row row;

    static int TESTING_ROW = 0;
    static int TESTING_URL_CELL = 1;
    static int TEST_RESULT_CEL = 2;
    static WebElement DELIVERY;
    static WebElement FINANCE;
    static JavascriptExecutor js = (JavascriptExecutor) driver;
static WebElement WHERE_TO_BUY;
static WebElement WHERE_TO_BUY2;
    static int n;
    static int drop;

    public static void main(String[] args) throws Exception {

        n = 1;
        drop = -30;
        openBrowser();
        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
        driver.findElement(By.cssSelector("#truste-consent-button")).click();


        for (int i = 0; i < 35; i++) {
            activityTest();
        }
        System.out.println("all done now!");
        quit();

    }


    public static void activityTest() throws Exception {


        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
        Thread.sleep(1000);


        findExpectedText(TESTING_ROW + n, TEST_RESULT_CEL);
        System.out.println(n);
        n = n + 1;


    }

    public static void openBrowser() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void goToPage(int rowNum, int cellNum) throws Exception {
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
        System.out.println("URL found");
    }

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

    public static void writeFile(XSSFWorkbook workbook, String FILE) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream(FILE);
        workbook.write(fos);
        fos.close();
        workbook.close();
        System.out.println("File Writen");
    }


    public static void findExpectedText(int rowNum, int colNum) throws IOException, InterruptedException {

        try {
//            WHERE_TO_BUY = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[3]/div[2]/div[1]/div[2]/div[3]/a"));

            WHERE_TO_BUY = driver.findElement(By.xpath("//*[text() = 'ADD TO BASKET']"));
//            driver.getPageSource().contains(WHERE_TO_BUY);
//            WHERE_TO_BUY.getText();
//<a class="cta cta--contained cta--emphasis add-special-tagging js-buy-now tg-add-to-cart" href="javascript:;" data-cta-type="add-cart" data-sku-code="RR39A74A3CE/EU" an-tr="pdd01_anchor nav-product detail-cta-cart page" an-ca="ecommerce" an-ac="addToCart" an-la="secondary navi:add to cart" aria-label="Add to basket:Bespoke Tall 1 door Fridge 1.85m (Metal)" data-discountprice="849" data-modelcode="RR39A74A3CE/EU" data-modeldisplay="Bespoke Tall 1 door Fridge 1.85m (Metal)" data-modelname="RR39A74A3CE" data-modelrevenue="899" data-modelprice="899" data-pvitype="refrigerator" data-pvisubtype="tall one door" data-modelqty="1">ADD TO BASKET</a>

Thread.sleep(1000);


            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue(WHERE_TO_BUY.getText());
            System.out.println(WHERE_TO_BUY.getText());
            writeFile(workbook, FILE);
        } catch (Exception exp) {
            try {
                System.out.println(exp.getMessage());
                System.out.println(exp.getCause());
                exp.printStackTrace();
//            <a class="cta cta--contained cta--emphasis add-special-tagging js-cta-buy tg-wtb" href="javascript:;" data-modelname="RB34T632EWW" data-title="RB7300T 4 Series Frost Free Classic Fridge Freezer with Non Plumbed Water Dispenser" data-img-src="//images.samsung.com/is/image/samsung/uk-fridge-freezer-rb34t632eww-rb34t632eww-eu-frontwhite-thumb-292907631" data-iacode="08030100" data-modelcode="RB34T632EWW/EU" an-tr="pdd01_anchor nav-product detail-cta-where to buy" an-ca="buy cta" an-ac="where to buy" an-la="where to buy" data-modeldisplay="rb7300t 4 series frost free classic fridge freezer with non plumbed water dispenser" data-pvitype="refrigerator" data-pvisubtype="bottom freezer" data-pimsubtype="bottom mount freezer" data-modelqty="1">WHERE TO BUY </a>

//                    driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[3]/div[2]/div[1]/div[2]/div[3]/a"));
                WHERE_TO_BUY2 = driver.findElement(By.xpath("//*[text() = 'WHERE TO BUY ']"));
                fis = new FileInputStream(FILE);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                row = sheet.getRow(rowNum);
                row.createCell(colNum).setCellValue(WHERE_TO_BUY2.getText());
                writeFile(workbook, FILE);

            } catch (Exception e) {
                System.out.println(exp.getMessage());
                System.out.println(exp.getCause());
                exp.printStackTrace();
//
                fis = new FileInputStream(FILE);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0);
                row = sheet.getRow(rowNum);
                row.createCell(colNum).setCellValue("N/A");
                writeFile(workbook, FILE);
            }
        }



        }

        public static void quit(){
            driver.quit();
        }


    }

