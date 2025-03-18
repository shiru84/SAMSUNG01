package UKOTFindTextExcell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UKOT422 {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static WebDriver driver ;
    static String TEXT;
    static FileOutputStream fos;
    static String projectPath = System.getProperty("user.dir");
    static FileInputStream fis;
    static String XLS = "/exel/UKOT422/data.xlsx";
    static String FILE = projectPath + XLS;
    static Row row;
    static WebElement okThanks;
    static WebElement removeButton;
    static WebElement getTEXT;

    static int TESTING_ROW = 0;
    static int TESTING_URL_CELL = 1;
    static int TESTING_DATA_CEL = 3;
    static int TEST_RESULT_CEL =  2;
    static int TESTING_DATA_CEL2 = 5;
    static int TEST_RESULT_CEL2 =  6;
    static int TESTING_ITEM_URL_CELL = 4;
    static int n;
    static String SELECTOR = "#wrap > div.seuk-galaxy-week--bannerWrapper > div > div.seuk-galaxy-week--right > div.seuk-galaxy-week--textCopy";
static String SELECTOR2 = "#content > div > div > div.seuk-galaxy-week--bannerWrapper > div > div.seuk-galaxy-week--right > div.seuk-galaxy-week--textCopy";


    public static void main(String[] args) throws Exception {

        n = 1;
//        openBrowser();
//        testIfInStock(TESTING_ROW + n, TEST_RESULT_CEL2);
        for (int i = 0; i < 14; i++) {
            activityTest();
        }
        System.out.println("all done now!");
//        quit();

    }

    public static void activityTest() throws Exception {
        openBrowser();
        goToPage(TESTING_ROW + n, TESTING_ITEM_URL_CELL);
//        Thread.sleep(1000);
        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
//        Thread.sleep(500);

        expectedTEXT(TESTING_ROW + n, TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW + n, TEST_RESULT_CEL);


        System.out.println(n);
        n = n + 1;
            quit();

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
    public static void findExpectedText(String TT,  int rowNum, int colNum) throws IOException, InterruptedException{
        //String getTEXT = driver.findElement(By.cssSelector("#content > div > div > div.seuk-galaxy-week--bannerWrapper > div > div.seuk-galaxy-week--right > div.seuk-galaxy-week--textCopy")).getText();
//#content > div > div > div.seuk-galaxy-week--bannerWrapper > div > div.seuk-galaxy-week--right > div.seuk-galaxy-week--textCopy
//            #wrap > div.seuk-galaxy-week--bannerWrapper > div > div.seuk-galaxy-week--right > div.seuk-galaxy-week--textCopy
        try{WebElement getTEXT = driver.findElement(By.cssSelector(SELECTOR));
//                "#content > div > div > div.seuk-galaxy-week--bannerWrapper > div > div.seuk-galaxy-week--right > div.seuk-galaxy-week--textCopy"));
    System.out.println(getTEXT.getText());

        if (getTEXT.getText().equals(TEXT)){
//                driver.getPageSource().contains(TEXT)){
            System.out.println("Founud -  "+TEXT);
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("PASS");
//            quit();
        }else {
            System.out.println("NOT Founud  -  "+TEXT);
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue(getTEXT.getText());
        }
    writeFile(workbook, FILE);
}catch (Exception exp){System.out.println(exp.getMessage());
    System.out.println(exp.getCause());
    exp.printStackTrace();}

    }
    public static void quit(){
        driver.quit();
    }



}
