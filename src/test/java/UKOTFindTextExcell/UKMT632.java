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

public class UKMT632 {


    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static WebDriver driver ;
    static String TEXT;
    static FileOutputStream fos;
    static String projectPath = System.getProperty("user.dir");
    static FileInputStream fis;
    static String XLS = "/exel/UKMT632/data.xlsx";
    static String FILE = projectPath + XLS;
    static Row row;
    static WebElement okThanks;
    static WebElement removeButton;
    static JavascriptExecutor js = (JavascriptExecutor)driver;

    static int TESTING_ROW = 0;
    static int TESTING_URL_CELL = 1;
    static int TESTING_DATA_CEL = 3;
    static int TEST_RESULT_CEL =  2;

    static int n;
    static int drop;

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
        drop = 4350;

        openBrowser();
        driver.get("https://p6-qa.samsung.com/uk/sign-up/");
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("samsungqa");
        driver.findElement(By.id("submit-button")).click();
        Thread.sleep(2000);

//        for (int i = 0; i<3; i++){
//            scrollClick();
//        }
        for (int i = 0; i <135; i++) {
            activityTest();
        }
        System.out.println("all done now!");
        quit();

    }


    public static void activityTest() throws Exception {

//        expectedTEXT(TESTING_ROW + n, TESTING_DATA_CEL);
        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
        findExpectedText(TESTING_ROW + n, TEST_RESULT_CEL);
        System.out.println(n);
        n = n + 1;


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


    public static void findExpectedText(int rowNum, int colNum) throws IOException, InterruptedException{

       try{
//           WebElement meta = driver.findElement(By.cssSelector(" head > link:nth-child(7)"));
          WebElement meta = driver.findElement(By.cssSelector("head > meta:nth-child(9)"));//description
//           WebElement meta = driver.findElement(By.cssSelector("head > meta:nth-child(8)"));// keywords
//        String meta_text = driver.getTitle();
//           String meta_text = meta.getAttribute("href");
        String meta_text = meta.getAttribute("content");//Keywords

            System.out.println("Founud -  "+meta_text);
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue(meta_text);
        writeFile(workbook, FILE);
       } catch (Exception exp) {
        System.out.println(exp.getMessage());
        System.out.println(exp.getCause());
        exp.printStackTrace();
    }



    }
    public static void quit(){
        driver.quit();
    }



}
