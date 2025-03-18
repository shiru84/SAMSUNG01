package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RunMe {



    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        ExelUtils excel = new ExelUtils(projectPath+"/exel/data.xlsx", "cartTestData");

        //excel.getRowCount();
        excel.getCellDataString(4,6);
        excel.getCellDataNumber(0,3);


    }
}
