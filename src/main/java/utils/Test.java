package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) throws IOException {

        String excelFilePath =".\\src\\test\\resources\\testData\\Country.xlsx";
                FileInputStream inputstream =new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator iterator=sheet.iterator();
        while(iterator.hasNext()){
            XSSFRow row=(XSSFRow) iterator.next();
            Iterator cellIterator=row.cellIterator();
            while(cellIterator.hasNext()){
                XSSFCell cell=(XSSFCell) cellIterator.next();
                CellType cellType = cell.getCellType();

                switch (cellType) {
                    case STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                    // Handle other cell types here if needed
                }
                System.out.print("  |  ");
            }
            System.out.println(" ");
        }
    }
}
