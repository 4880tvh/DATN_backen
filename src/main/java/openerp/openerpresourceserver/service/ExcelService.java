package openerp.openerpresourceserver.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import openerp.openerpresourceserver.helper.ExcelHelper;
import openerp.openerpresourceserver.entity.Excel;
import openerp.openerpresourceserver.repo.ExcelRepository;

@Service
public class ExcelService {

    @Autowired
    ExcelRepository citizenRepo;

    public ByteArrayInputStream load() {

        List<Excel> citizens = citizenRepo.findAll();

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(citizens);
        return in;
    }
}
