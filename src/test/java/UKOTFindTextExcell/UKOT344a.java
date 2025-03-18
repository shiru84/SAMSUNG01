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

public class UKOT344a {


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
    static int TEST_RESULT_CEL =  2;
    static WebElement DELIVERY;
    static WebElement FINANCE;
    static JavascriptExecutor js = (JavascriptExecutor)driver;

    static int n;
    static int drop;
    public static void main(String[] args) throws Exception {

        n = 1;
        drop = 300;
        openBrowser();
        goToPage(TESTING_ROW + n, TESTING_URL_CELL);
        driver.findElement(By.cssSelector("#truste-consent-button")).click();


        for (int i = 0; i <78; i++) {
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
//            DELIVERY = driver.findElement(By.xpath("//*[text() = 'Delivery and Returns']"));
//            Thread.sleep(4000);
//
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DELIVERY);
//            Thread.sleep(4000);
//

//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DELIVERY);
//            Thread.sleep(2000);
//            ((JavascriptExecutor) driver).executeScript("window.scrollTo (0, "+drop+")  ");


             ((JavascriptExecutor) driver).executeScript("window.scrollTo (0, "+drop+")");
//            FINANCE =
//                    driver.findElement(By.cssSelector("#content > div > div > div.pd-g-product-detail-kv.aem-GridColumn.aem-GridColumn--default--12 > div.product-detail-kv.product-detail-kv--fixed > div.product-detail-kv__buying-tool > section > div.pd-buying-tool__option > div.pd-select-option.pd-select-option--type-offer.option-offer.has-component > div > ul > li.pd-offer__item.has-component.finance > div > div.pd-offer-desc > div > a"));
//                    driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div/div[4]/div[2]/div[2]/section/div[2]/div[11]/div/ul/li[1]/div/div[2]/div/a"));
                    FINANCE = driver.findElement(By.xpath("//*[contains(text(), 'Calculate Finance')]"));

//                    driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[1]/div[4]/div[2]/div[2]/section/div[2]/div[12]/div/ul/li[1]/div/div[2]/div/a"));
            System.out.println("Founud");
//            FINANCE = driver.findElement(By.xpath("//*[text() = 'Calculate Finance']"));
//            FINANCE.click();
//            System.out.println("Clicked");
//            driver.findElement(By.cssSelector("#cheil-id-root__financeModule > div.FinanceModule__Tabs__Container > div.FinanceModule__Tabs > div:nth-child(2) > div > div")).click();
//            Thread.sleep(1000);

            System.out.println("Founud - Offer ");
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue(FINANCE.getText());

            System.out.println("File Writen2");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
            fis = new FileInputStream(FILE);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            row = sheet.getRow(rowNum);
            row.createCell(colNum).setCellValue("NO Offer");


        }
        writeFile(workbook, FILE);



    }
    public static void quit(){
        driver.quit();
    }



}
