package UKOTFindTextExcell;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileOutputStream;

public class TestCase1 {
    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static String URL;
    static WebDriver driver;
    static String LOGIN;
    static String PASSWORD;
    static String TEXT;
    static FileOutputStream fos;
    static String FILE = "/exel/data.xlsx";

    public static void main(String[] args)throws Exception{
        projectPath = System.getProperty("user.dir");
        workbook = new XSSFWorkbook(projectPath + "/exel/data.xlsx");
        openBrowser();
//        CellDataURL(1,6);
//        goToPage(URL);
//        CellDataLOGIN(0,0);
//        CellDataPASSWORD(0,1);
//        logInSamsung(LOGIN,PASSWORD);
        CellDataURL(6,4);
        goToPage(URL);
        Thread.sleep(1000);
        expectedTEXT(6,10);
        findExpectedText(TEXT, 6,6);
        driver.quit();
    }
    public static void openBrowser() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void goToPage(String URL) throws Exception {
        driver.get(URL);

        //driver.get(URL);Thread.sleep(500);
    }
    public static void logInSamsung(String LOGIN, String PASSWORD) throws Exception {
        driver.findElement(By.cssSelector("#content > div > div > div > div.home-login__account > div > div:nth-child(2) > a")).click();
        driver.findElement(By.id("iptLgnPlnID")).sendKeys(LOGIN);
        Thread.sleep(1000);
        driver.findElement(By.id("iptLgnPlnPD")).sendKeys(PASSWORD);
        Thread.sleep(1000);
        driver.findElement(By.id("iptLgnPlnPD")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.id("btnNotNow")).click();
        Thread.sleep(2000);
    }

    public static void CellDataURL(int rowNum, int colNum) {
        try {
            sheet = workbook.getSheet("cartTestData");
            URL = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
    public static void CellDataLOGIN(int rowNum, int colNum) {
        try {
            sheet = workbook.getSheet("loginCredentials");
            LOGIN = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        }
    public static void CellDataPASSWORD ( int rowNum, int colNum){
        try {
            sheet = workbook.getSheet("loginCredentials");
            PASSWORD = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }public static void expectedTEXT ( int rowNum, int colNum){
        try {
            sheet = workbook.getSheet("cartTestData");
            TEXT = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
    public static void findExpectedText(String TEXT, int rowNum, int colNum) throws Exception{
        if (driver.getPageSource().contains(TEXT)){
            sheet = workbook.getSheetAt(1);
            sheet.getRow(rowNum).createCell(colNum).setCellValue("pass");
            sheet.getRow(rowNum).createCell(11).setCellValue("'"+TEXT+"'"+" - present on the page!");
            fos = new FileOutputStream(projectPath + "/exel/data.xlsx");
            workbook.write(fos);
            fos.close();
            workbook.close();
            System.out.println("PASS, "+ "'"+TEXT+"'"+" - present on the page!");
        }else {
            sheet = workbook.getSheetAt(1);
            sheet.getRow(rowNum).createCell(colNum).setCellValue("fail");
            sheet.getRow(rowNum).createCell(11).setCellValue("'"+TEXT+"'"+ " - not found!");
            fos = new FileOutputStream(projectPath + "/exel/data.xlsx");
            workbook.write(fos);
            fos.close();
            workbook.close();
            System.out.println("FAIL, " + "'"+TEXT+"'"+ " - not found!");
        }
    }



}

