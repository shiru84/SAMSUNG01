package tabs;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class tabGames {
    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    static FileOutputStream outputStream;
    static LocalDate today;
    static File existingTest;
    static FileInputStream inputStream;


    public static void main(String[] args) throws Exception {
        projectPath = System.getProperty("user.dir");
        getTheDate();
        System.out.println(today);
        insertToExcel(0,0);
        System.out.println(today);
        //writeDataToExcel();
        System.out.println(today);

    }
    public static LocalDate getTheDate() {
        today = LocalDate.now();
        return today;

    }
//    public static void createNewExcel(List<Values> list) throws IOException {
//        try {
//            LocalDate today = getTheDate();
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("PFP filtered products");
//            Type("Converting data to Excel format.");
//            Type("Creating new Excel file. Any existing files ('output " + today + ".xlsx') will be overwritten!");
//            createHeadersInExcel(sheet);
//            int rownum = 1;
//            for (Values v : list) {
//                Row row = sheet.createRow(rownum++);
//                convertListToExcel(v, row);
//                tidyTheExcel(sheet);
//            }
//            writeDataToExcel(workbook, today);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void insertToExcel(int ROW,int CEL) throws IOException {
            today = getTheDate();

            existingTest = new File(projectPath + "/exel/data - Copy.xlsx");
            if (!existingTest.exists()) {
                System.out.println("createNewExcel(list)");
            } else {
                //inputStream = new FileInputStream(existingTest);
                workbook = new XSSFWorkbook(projectPath + "/exel/data - Copy.xlsx");
                sheet = workbook.getSheetAt(0);
                sheet.getRow(ROW).createCell(CEL).setCellValue(today);
                outputStream = new FileOutputStream(existingTest);
                workbook.write(outputStream);
                outputStream.close();
                workbook.close();


//                for (Values v : list) {
//                    Row row = sheet.createRow(rownum++);
//                    convertListToExcel(v, row);
//                    tidyTheExcel(sheet);
//                }
               // writeDataToExcel();

    }

//    public static void writeDataToExcel()
//			throws IOException, InterruptedException {
//
//            outputStream = new FileOutputStream(new File(projectPath + "/exel/data - Copy.xlsx"));
//            workbook.write(outputStream);
//            outputStream.close();
//            workbook.close();
            //Type("Data saved to the file: 'output " + today + ".xlsx'");
            //literallyWait();
    }

//    public static void convertListToExcel(Values v, Row row) {
//        Cell cell = row.createCell(0);
//        cell.setCellValue(v.filter);
//        cell = row.createCell(1);
//        cell.setCellValue(v.f_id);
//        cell = row.createCell(2);
//        cell.setCellValue(v.r_id);
//        cell = row.createCell(3);
//        cell.setCellValue(v.sku);
//        cell = row.createCell(4);
//        cell.setCellValue(v.deviceName);
//    }

    public static void createHeadersInExcel(XSSFSheet sheet) {

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Filter");
        header.createCell(1).setCellValue("Filter ID");
        header.createCell(2).setCellValue("Product ID");
        header.createCell(3).setCellValue("SKU Number");
        header.createCell(4).setCellValue("Product Name");
    }
    public static void tidyTheExcel( ){
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        sheet.autoSizeColumn(4);
        sheet.createFreezePane(0, 1);
    }



}
    //String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//        try{
//        projectPath = System.getProperty("user.dir");
//        FileInputStream fis = new FileInputStream(projectPath + "/exel/da22.xlsx");
//        workbook = new XSSFWorkbook(fis);
//        sheet = workbook.getSheetAt(0);
//        sheet.getRow(10).createCell(8).setCellValue("fail909");
//            FileOutputStream fos = new FileOutputStream(projectPath + "/exel/da22.xlsx");
//        workbook.write(fos);
//            workbook.close();
//        } catch (Exception e) {
//
//            e.printStackTrace();}
//
//System.out.println("FAILL2");