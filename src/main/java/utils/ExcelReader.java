package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelReader {


    public static List<Map<String, String>> readExcel(String path) {
        List<Map<String, String>> testData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(path));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            int columnCount = headerRow.getPhysicalNumberOfCells();

            for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;
                Map<String, String> dataMap = new HashMap<>();

                for (int c = 0; c < columnCount; c++) {
                    Cell cell = row.getCell(c);
                    dataMap.put(headerRow.getCell(c).getStringCellValue().trim(),
                            cell == null ? "" : cell.toString().trim());
                }
                testData.add(dataMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testData;
    }
}
