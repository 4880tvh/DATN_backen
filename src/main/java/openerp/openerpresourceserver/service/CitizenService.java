package openerp.openerpresourceserver.service;

import openerp.openerpresourceserver.entity.Citizen;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public interface CitizenService {

    List<Citizen> getAllCitizens();
    Citizen getCitizenById(Integer id);
    // Other methods for CRUD operations
    Citizen createCitizen(Citizen citizen);
    Citizen updateCitizen(Integer id, Citizen citizen);
    void deleteCitizen(Integer id);
}
