package openerp.openerpresourceserver.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import openerp.openerpresourceserver.entity.Excel;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Id", "Name", "Age", "DOB", "Address", "Email","Phone","NIN" };
    static String SHEET = "Tutorials";
    public static ByteArrayInputStream tutorialsToExcel(List<Excel> excels) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Excel excel : excels) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(excel.getUserId());
                row.createCell(1).setCellValue(excel.getName());
                row.createCell(2).setCellValue(excel.getAge());
                row.createCell(3).setCellValue(excel.getDob());
                row.createCell(3).setCellValue(excel.getAddress());
                row.createCell(3).setCellValue(excel.getEmail());
                row.createCell(3).setCellValue(excel.getPhone());
                row.createCell(3).setCellValue(excel.getNin());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}