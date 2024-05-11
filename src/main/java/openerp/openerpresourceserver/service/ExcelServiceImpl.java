//package openerp.openerpresourceserver.service;
//
//import java.io.IOException;
//import java.util.List;
//
//import jakarta.servlet.ServletOutputStream;
//import jakarta.servlet.http.HttpServletResponse;
//
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import openerp.openerpresourceserver.entity.Citizen;
//import openerp.openerpresourceserver.repo.CitizenRepository;
//
//@Service
//public class ExcelService {
//
//    @Autowired
//    private CitizenRepository citizenRepo;
//
//    public void generateExcel(HttpServletResponse response) throws Exception {
//
//        List<Citizen> citizens = citizenRepo.findAll();
//
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        HSSFSheet sheet = workbook.createSheet("Citizens Info");
//        HSSFRow row = sheet.createRow(0);
//
//        row.createCell(0).setCellValue("ID");
//        row.createCell(1).setCellValue("Name");
//        row.createCell(2).setCellValue("Age");
//        row.createCell(3).setCellValue("DoB");
//        row.createCell(4).setCellValue("Address");
//        row.createCell(5).setCellValue("Email");
//        row.createCell(6).setCellValue("Phone");
//        row.createCell(7).setCellValue("NiN");
//
//        int dataRowIndex = 1;
//
//
//        for (Citizen citizen : citizens) {
//            HSSFRow dataRow = sheet.createRow(dataRowIndex);
//            dataRow.createCell(0).setCellValue(course.getUserId());
//            dataRow.createCell(1).setCellValue(course.getName());
//            dataRow.createCell(2).setCellValue(course.getAge());
//            dataRow.createCell(3).setCellValue(course.getDob());
//            dataRow.createCell(4).setCellValue(course.getAddress());
//            dataRow.createCell(5).setCellValue(course.getEmail());
//            dataRow.createCell(6).setCellValue(course.getPhone());
//            dataRow.createCell(7).setCellValue(course.getNin());
//            dataRowIndex++;
//        }
//
//        ServletOutputStream ops = response.getOutputStream();
//        workbook.write(ops);
//        workbook.close();
//        ops.close();
//
//    }
//
//}