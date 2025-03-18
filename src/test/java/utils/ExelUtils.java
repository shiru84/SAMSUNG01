package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelUtils {
    static String projectPath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExelUtils(String exelPath, String sheetName){
        try {
            workbook = new XSSFWorkbook(exelPath);
            sheet = workbook.getSheet(sheetName);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
//        getRowCount();
//        getCellDataString(0,1);
//        getCellDataNumber(0,5);
    }
    public static void getRowCount(){
        try {

            int rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of rows :"+rowCount);
        }catch(Exception exp){
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
    public static void getCellDataString(int rowNum, int colNum){
        try {
            String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            System.out.println(cellData);
            return;


        }catch(Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
    public static void getCellDataNumber(int rowNum, int colNum){
        try {
            double cellNumeric = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            System.out.println(cellNumeric);


        }catch(Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }
}
