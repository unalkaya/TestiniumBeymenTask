package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;

public class ExcelReader {

    public static String readCellValue(String filePath, String sheetName, int rowNum, int colNum) {
        String cellValue = null;
        try {
            Workbook workbook = WorkbookFactory.create(new File(filePath));
            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum - 1); // Row numarasını 0'dan değil 1'den başlatmak için rowNum - 1
            Cell cell = row.getCell(colNum - 1); // Column numarasını 0'dan değil 1'den başlatmak için colNum - 1

            if (cell != null) {
                if (cell.getCellType() == CellType.STRING) {
                    cellValue = cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellValue;
    }

}
