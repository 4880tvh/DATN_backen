package openerp.openerpresourceserver.repo;


import java.io.Serializable;
import openerp.openerpresourceserver.entity.Excel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcelRepository extends JpaRepository<Excel, Long> {

}