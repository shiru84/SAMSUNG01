package UKOTFindTextExcell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCaseUKOT378 {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static WebDriver driver;
    static String TEXT;
    static FileOutputStream fos;
    static String projectPath= System.getProperty("user.dir");
    static FileInputStream fis;
    static String FILE = projectPath + "/exel/378/data.xlsx";
    static Row row;
    static int TESTING_ROW = 0;
    static int TESTING_URL_CELL = 1;
    static int TESTING_DATA_CEL = 3;
    static int TEST_RESULT_CEL = 10;
    static int TEST_ROW_NUMBERING=0;
    static int TESTING_ITEM_URL_CELL = 4;
    static int n ;

    public static void main(String[] args)throws Exception{
        workbook = new XSSFWorkbook(FILE);
        openBrowser();

        getN(TESTING_ROW+1, TEST_ROW_NUMBERING);
        goToPage( TESTING_ROW+n, TESTING_URL_CELL);
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        Thread.sleep(2000);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC2
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        Thread.sleep(1000);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC3
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC4
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC5
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC6
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        n=n+1;
        //next CC7
        quit();
        openBrowser();
        goToPage( TESTING_ROW+n, TESTING_URL_CELL);
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        Thread.sleep(2000);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC8
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC9
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC10
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC11
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC12
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
//next CC13
        n=n+1;
        quit();
        openBrowser();
        goToPage( TESTING_ROW+n, TESTING_URL_CELL);
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        Thread.sleep(2000);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC14
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC15
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC16
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC17
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        //next CC18
        n=n+1;
        goToPage( TESTING_ROW+n, TESTING_ITEM_URL_CELL);
        expectedTEXT(TESTING_ROW+n,TESTING_DATA_CEL);
        findExpectedText(TEXT, TESTING_ROW+n,TEST_RESULT_CEL);
        System.out.println("all done now!");

        quit();
    }
    public static void triggerPopup () {
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/main/div/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[1]/div[2]/div[2]/div[1]/p[2]/a")).click();
    }
    public static void removeItemFromCart(){
        driver.get("https://www.samsung.com/uk/web/cart/");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div/div[2]/div[1]/div[1]/div[3]/div[2]/div/div[1]/div[2]/div[1]/p/span[2]/button")).click();
    }
    public static void openBrowser() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void goToPage( int rowNum, int cellNum) throws Exception {
       //CellDataURL(int rowNum, int cellNum);
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
//    public static void CellDataURL(int rowNum, int cellNum) {
//        try {
//            //workbook = new XSSFWorkbook(FILE);
//            sheet = workbook.getSheetAt(0);
//            URL = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
//        } catch (Exception exp) {
//            System.out.println(exp.getMessage());
//            System.out.println(exp.getCause());
//            exp.printStackTrace();
//        }
//    }
    public static void createFile() throws IOException {
        try {
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet("data9");
            Row row1 = sheet.createRow(0);
            row1.createCell(0);
            writeFile(workbook, FILE);
        }catch (FileNotFoundException | InterruptedException e) { e.printStackTrace();}

    }
    public static void updateFile(String TEXT, int rowNum, int cellNum) throws IOException, InterruptedException{
        fis = new FileInputStream(FILE);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        row = sheet.createRow(rowNum);
        row.createCell(cellNum).setCellValue(TEXT);
        writeFile(workbook, FILE);
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

