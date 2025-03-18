package CEOTExcell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class tcCEOT533 {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static WebDriver driver;
    static String TEXT;
    static String projectPath = System.getProperty("user.dir");
    static FileInputStream fis;
    static String FILE = projectPath + "/exel/CEOT533/data.xlsx";
    static Row row;
    static int TESTING_ROW = 0;
    static int TESTING_URL_CELL = 1;
    static int TESTING_DATA_CEL = 3;
    static int TEST_RESULT_CEL = 2;
    static int TEST_ROW_NUMBERING = 0;
    static int TESTING_ITEM_URL_CELL = 4;
    static int n;
    //static WebElement pause = driver.findElement(By.cssSelector("#pause-bold"));

    public static void main (String[] args)throws Exception {
        workbook = new XSSFWorkbook(FILE);
        openBrowser();
        getN(TESTING_ROW+1, TEST_ROW_NUMBERING);
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
        goToPage(TESTING_ROW + n, TESTING_ITEM_URL_CELL);
        //goToPage(TESTING_ROW + n, TESTING_URL_CELL);
//        driver.get("https://www.samsung.com/uk/");
        driver.navigate().refresh();

        Thread.sleep(500);
        //driver.findElement(By.cssSelector("#pause-bold")).click();

        expectedTEXT(TESTING_ROW + n, TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW + n, TEST_RESULT_CEL);
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

    public static void expectedTEXT ( int rowNum, int colNum){
        try {
            sheet = workbook.getSheetAt(0);
            TEXT = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
    public static void findExpectedText(String TEXT, int rowNum, int colNum) throws IOException, InterruptedException{

        if (driver.getPageSource().contains(TEXT)){
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("PASS");
            writeFile(workbook, FILE);
        }else {
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("FAIL");
            writeFile(workbook, FILE);
        }
    }
    public static void quit(){
        driver.quit();
    }



}