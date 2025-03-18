package UKOTFindTextExcell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IM2GBS21329002875 {


    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static String TITLE;
    static WebDriver driver ;
    static String TEXT;
    static FileOutputStream fos;
    static String projectPath = System.getProperty("user.dir");
    static FileInputStream fis;
    static String XLS = "/exel/IM2GBS21329002875/data.xlsx";
    static String FILE = projectPath + XLS;
    static Row row;
    static WebElement okThanks;
    static WebElement removeButton;
    static JavascriptExecutor js = (JavascriptExecutor)driver;
    static String theExpectedcopy;

    static int TESTING_ROW = 0;
    static int TESTING_URL_CELL = 1;
    static int TESTING_DATA_CEL = 2;
    static int TEST_RESULT_CEL =  2;
    static int TEST_RESULT_CEL3 =  3;
    static int TEST_RESULT_CEL4 =  4;
    static int TEST_RESULT_CEL5 =  5;
    static int TEST_RESULT_CEL6 =  6;
    static int TEST_RESULT_CEL7 =  7;
    static int TEST_RESULT_CEL8 =  8;
    static int TEST_RESULT_CEL9 =  9;
    static int TEST_RESULT_CEL10 =  10;
    static int TEST_RESULT_CEL11 =  11;
    static int drop;

    static int n;

    public static void main(String[] args) throws Exception {

        n = 1;
        drop = 4350;
        openBrowser();
        goToPage(TESTING_ROW + n, TESTING_URL_CELL);

        driver.findElement(By.id("username")).sendKeys("amy.l");
        driver.findElement(By.id("password")).sendKeys("amy.l@2021");
        driver.findElement(By.id("submit-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#truste-consent-button")).click();
        Thread.sleep(3000);
        scrollClick ();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#Compare > div > button")).click();
        for (int i = 0; i <30; i++) {
            activityTest();
        }
        System.out.println("all done now!");
        quit();
    }


    public static void activityTest() throws Exception {



        findExpectedText(TESTING_ROW + n, TEST_RESULT_CEL);


        System.out.println(n);


        n = n + 1;
    }
    public static void scrollClick () throws Exception{

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        js.executeScript("window.scrollTo (0, "+drop+") ");
        System.out.println("Scroll");}
    public static void openBrowser() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void getTheSelector( int rowNum, int cellNum) throws Exception {
        try {
            workbook = new XSSFWorkbook(FILE);
            sheet = workbook.getSheetAt(0);
            theExpectedcopy = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }

        System.out.println("theSelector found");}
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



    public static void findExpectedText(int rowNum, int colNum) throws Exception {
        getTheSelector(TESTING_ROW + n, colNum);
        System.out.println(theExpectedcopy);
        Boolean PassFail = (driver.getPageSource().contains(theExpectedcopy));
        try{
            Assert.assertTrue(PassFail);

            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum+1).setCellValue("PASS");


        } catch (AssertionError e) {
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum+1).setCellValue("Fail");
        }
        writeFile(workbook, FILE);
    }
    public static void quit(){
        driver.quit();
    }



}
