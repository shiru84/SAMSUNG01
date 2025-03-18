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

public class CEOT489 {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static WebDriver driver ;
    static String TEXT;
    static FileOutputStream fos;
    static String projectPath = System.getProperty("user.dir");
    static FileInputStream fis;
    static String XLS = "/exel/UKOT375/data.xlsx";
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



    public static void main(String[] args) throws Exception {

        n = 1;
        for (int i = 0; i < 76; i++) {
            activityTest();
        }
        System.out.println("all done now!");
    }

    public static void activityTest() throws Exception {
        openBrowser();
        goToPage(TESTING_ROW + n, TESTING_ITEM_URL_CELL);
        Thread.sleep(13000);
        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
        Thread.sleep(12000);
        removeItemFromCart(TESTING_ROW + n, TEST_RESULT_CEL);
        System.out.println(n);
        n = n + 1;
        quit();

    }

    public static void findOkThanks(){
        try {
            okThanks = driver.findElement(By.cssSelector("body > app-root > cx-storefront > div > div > div > div.seuk-popup-cart--info > span"));
            System.out.println(okThanks.getText()+" - FOUND");
        }catch (Exception e) {
            System.out.println("ok, thanks - Not FOUND");

        }
    }
    public static void findRemoveButton(){
        try {
            removeButton = driver.findElement(By.cssSelector("body > app-root > cx-storefront > main > cx-page-layout > cx-page-slot.TokoLeftContent.has-components.ng-star-inserted > cx-cart-details > div > cx-cart-item-list > div > div > cx-cart-item > div > div.cart-item__remove > button"));
            System.out.println(removeButton.getText()+" - FOUND");
        }catch (Exception e){System.out.println("Remove - Not FOUND");}
    }

    public static void recordPass(int rowNum, int colNum) throws IOException, InterruptedException {
        fis = new FileInputStream(FILE);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        row = sheet.getRow(rowNum);
        row.createCell(colNum).setCellValue("PASS");
        System.out.println("Recorded");
        writeFile(workbook, FILE);
    }
    public static void recordFail(int rowNum, int colNum) throws IOException, InterruptedException {
        fis = new FileInputStream(FILE);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        row = sheet.getRow(rowNum);
        row.createCell(colNum).setCellValue("Fail");
        writeFile(workbook, FILE);
    }
    public static void recordNA(int rowNum, int colNum) throws IOException, InterruptedException{
        System.out.println("OOS");
        fis = new FileInputStream(FILE);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        row = sheet.getRow(rowNum);
        row.createCell(colNum).setCellValue("Not Available");
        writeFile(workbook, FILE);
    }

    public static void removeItemFromCart(int rowNum, int colNum) throws IOException, InterruptedException {
        Thread.sleep(1000);
        findRemoveButton();
        findOkThanks();
        try {

            System.out.println("Ok, thanks ???");
            okThanks.click();
            removeButton.click();
            Thread.sleep(2000);
            System.out.println("Ok, thanks - Clicked");
            recordPass(rowNum, colNum);

        } catch (Exception d) {

            try {
                System.out.println("Remove ???");

                removeButton.click();
                System.out.println("Removed!!");
                recordFail(rowNum, colNum);

            } catch (Exception e) {
                recordNA(rowNum, colNum);

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


    public static void quit(){
        driver.quit();
    }



}
