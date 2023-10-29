package utils;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestData {
    public TestData(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    WebDriver driver;

    public static Map<Integer,String>key=new Hashtable<>();
    public static Map<Integer,String>values=new HashMap<>();
    static Map<String,String>datacomb=new Hashtable<>();
    static File  file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Country.xlsx");
    public static void readTestData(String testCaseID) throws FileNotFoundException {
        try {
            Workbook wb = WorkbookFactory.create(file);
            for(Sheet sheet:wb) {
                Sheet sh = wb.getSheet(sheet.getSheetName());
                for (Row row : sh) {
                    Cell firstCell = row.getCell(0);
                    String firstCellValue = firstCell.getStringCellValue();
                    if (firstCellValue.equalsIgnoreCase("testcaseID")) {
                        for (Cell cell : row) {
                            key.put(cell.getColumnIndex(), cell.getStringCellValue());
                        }
                    } else if (firstCellValue.equalsIgnoreCase(testCaseID)) {
                        for (Cell cell : row) {
                            values.put(cell.getColumnIndex(), cell.getStringCellValue());
                        }
                    }
                }
                for (Integer index : values.keySet()) {
                    if (!values.get(index).equals("")) {
                        datacomb.put(key.get(index), values.get(index));
                    }
                }
            }

        }catch (Exception e){
         System.out.println(e.getMessage());
        }
    }
    public static String get(String key) {
        return datacomb.getOrDefault(key,null);
    }
}
