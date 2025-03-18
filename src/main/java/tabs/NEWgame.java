//package tabs;
//
//import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.ss.usermodel.CreationHelper;
//import org.apache.poi.ss.usermodel.RichTextString;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.lang.reflect.Type;
//
//public class NEWgame {
//
//    static String projectPath= System.getProperty("user.dir");
//    static XSSFWorkbook workbook;
//    static XSSFSheet sheet;
//    static String URL;
//    static WebDriver driver = new ChromeDriver;
//    static String LOGIN;
//    static String PASSWORD;
//    static String TEXT;
//    static FileOutputStream fos;
//    static FileInputStream fis;
//    static String FILE = projectPath + "/exel/data.xlsx";
//    static Row row;
//
//    public static void main(String[] args)throws Exception{
//        //createFile();
//        updateFile("pass", 1, 1);
//        updateFile("pass", 2, 1);
//        //editFile();
//        //writeFile();
//        //Text("pass", 0,1);
//
//    }
//    public static void createFile() throws IOException {
//       try {
//           workbook = new XSSFWorkbook();
//           sheet = workbook.createSheet("data9");
//           Row row1 = sheet.createRow(0);
//           row1.createCell(0);
//           writeFile(workbook, FILE);
//       }catch (FileNotFoundException | InterruptedException e) { e.printStackTrace();}
//
//    }
//    public static void updateFile(String TEXT, int rowNum, int colNum) throws IOException, InterruptedException{
//        fis = new FileInputStream(FILE);
//        workbook = new XSSFWorkbook(fis);
//        sheet = workbook.getSheetAt(0);
//        row = sheet.createRow(rowNum);
//        row.createCell(colNum).setCellValue(TEXT);
//        writeFile(workbook, FILE);
//    }
//    public static void writeFile(XSSFWorkbook workbook,String FILE ) throws IOException, InterruptedException {
//        FileOutputStream fos = new FileOutputStream(FILE);
//        workbook.write(fos);
//        fos.close();
//        workbook.close();
//        //Type("File Writen");
//        System.out.println("File Writen");
//
//    }
////    public static void Text(int rowNum, int colNum){
////    sheet = workbook.getSheetAt(0);
////    sheet.getRow(rowNum).createCell(colNum).setCellValue("PASS");
////    fos = new FileOutputStream(projectPath + "/exel/data.xlsx");
////    workbook.write(fos);
////    fos.close();
////    workbook.close();}
//    public static void Text(String TEXT, int rowNum, int colNum) throws Exception{
//        try {
//            // FileInputStream fis = new FileInputStream(FILE);
//            FileOutputStream fos = new FileOutputStream(FILE);
//            // CreationHelper cHelp = workbook.getCreationHelper();
//            XSSFWorkbook workbook = new XSSFWorkbook();
//                // fis.close();
//                XSSFSheet sheet = workbook.createSheet("data");
//                Row row1 = sheet.createRow(rowNum);
//                row1.createCell(colNum++).setCellValue(TEXT);
//                row1.createCell(colNum++).setCellValue(TEXT);
//                row1.createCell(colNum++).setCellValue(TEXT);
//
//                workbook.write(fos);
//
//            //workbook.close();
//            //fos.close();
//            System.out.println(TEXT);
//        }catch(FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
