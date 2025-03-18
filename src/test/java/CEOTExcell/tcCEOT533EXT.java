package CEOTExcell;
import org.openqa.selenium.By;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class tcCEOT533EXT {


    static String URL;
    static WebDriver driver;
    static String projectPath = System.getProperty("user.dir");
    static FileInputStream fis;
    static String FILE = projectPath + "/exel/CEOT533/dataExtract.xlsx";
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static Row row;
    static int TESTING_ROW = 0;
    static int TESTING_URL_CELL = 1;
    static int TEST_RESULT_CEL2 = 2;
    static int TEST_RESULT_CEL5 = 5;
    static int TEST_RESULT_CEL6 = 6;
    static int TEST_RESULT_CEL7 = 7;
    static int TEST_RESULT_CEL8 = 8;
    static int TEST_ROW_NUMBERING = 0;
    static int n;
    static String DAYS = "#content > div > div > div.seuk-easter-sale--bannerWrapper > div > div.seuk-easter-sale--right > div.seuk-easter-sale--counter > div.seuk-easter-sale--timeComponent.seuk-easter-sale--days > span.seuk-easter-sale--time";
    static String HRS = "#content > div > div > div.seuk-easter-sale--bannerWrapper > div > div.seuk-easter-sale--right > div.seuk-easter-sale--counter > div.seuk-easter-sale--timeComponent.seuk-easter-sale--hours > span.seuk-easter-sale--time";
    static String MINS = "#content > div > div > div.seuk-easter-sale--bannerWrapper > div > div.seuk-easter-sale--right > div.seuk-easter-sale--counter > div.seuk-easter-sale--timeComponent.seuk-easter-sale--minutes > span.seuk-easter-sale--time";
    static String SECS = "#content > div > div > div.seuk-easter-sale--bannerWrapper > div > div.seuk-easter-sale--right > div.seuk-easter-sale--counter > div.seuk-easter-sale--timeComponent.seuk-easter-sale--seconds > span.seuk-easter-sale--time";
    static String SKU = "#content > div > div > div.pd-g-product-detail-kv.aem-GridColumn.aem-GridColumn--default--12 > div.product-detail-kv > div.product-detail-kv__buying-tool > section > div.pd-buying-tool__info > div > p > span";
//    static WebElement elementWithText;
//    static String  DATA;

    public static void main (String[] args)throws Exception {
        workbook = new XSSFWorkbook(FILE);
        openBrowser();
        getN(TESTING_ROW+1, TEST_ROW_NUMBERING);
        activityTest();activityTest();activityTest();
        activityTest();activityTest();activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();

        activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();
//10
        activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();

        activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();
        //20
        activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();

        activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();
//10
        activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();

        activityTest();
        activityTest();
        activityTest();
        activityTest();
        activityTest();
        System.out.println("all done now!");
        quit();
    }

    public static void activityTest() throws Exception{

        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
        //fuckedOrFound();
        findExpectedText(SKU,TESTING_ROW + n, TEST_RESULT_CEL2);
        findExpectedText(DAYS,TESTING_ROW + n, TEST_RESULT_CEL5);
        findExpectedText(HRS,TESTING_ROW + n, TEST_RESULT_CEL6);
        findExpectedText(MINS, TESTING_ROW +n, TEST_RESULT_CEL7 );
        findExpectedText(SECS, TESTING_ROW +n, TEST_RESULT_CEL8 );
        n = n + 1;

    }
//    public static void fuckedOrFound() throws Exception{
//        //elementWithText = driver.findElement(By.cssSelector("#content > div > div > div.pd-g-product-detail-kv.aem-GridColumn.aem-GridColumn--default--12 > div.product-detail-kv > div.product-detail-kv__buying-tool > section > div.pd-buying-tool__info > div > p > span"));
//        try {
//            elementWithText = driver.findElement(By.cssSelector("#content > div > div > div.pd-g-product-detail-kv.aem-GridColumn.aem-GridColumn--default--12 > div.product-detail-kv > div.product-detail-kv__buying-tool > section > div.pd-buying-tool__info > div > p > span"));
//                DATA = elementWithText.getText();
//
//
//            }catch (Exception exp){System.out.println(exp.getMessage());
//            System.out.println(exp.getCause());
//            exp.printStackTrace();}
//
//
//
//
//    }

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

    public static void writeFile(XSSFWorkbook workbook,String FILE ) throws IOException{
        FileOutputStream fos = new FileOutputStream(FILE);
        workbook.write(fos);
        fos.close();
        workbook.close();
        System.out.println("File Writen");
    }

    public static void findExpectedText(String SELECTOR, int rowNum, int colNum) throws IOException, InterruptedException{
        try {
            WebElement elementWithText = driver.findElement(By.cssSelector(SELECTOR));



        if (elementWithText.isEnabled()){
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue(elementWithText.getText());
            writeFile(workbook, FILE);
        }else {
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("MMP Page");
            writeFile(workbook, FILE);
        }
        }catch (Exception exp){System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();}


    }
    public static void quit(){
        driver.quit();
    }



}