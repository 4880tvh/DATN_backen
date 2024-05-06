package openerp.openerpresourceserver.service;

import openerp.openerpresourceserver.entity.CitizenApartment;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public interface CitizenApartmentService {


    List<CitizenApartment> getAllCitizenApartments();
    CitizenApartment getCitizenApartmentById(Integer id);
    CitizenApartment createCitizenApartment(CitizenApartment citizenApartment);
    CitizenApartment updateCitizenApartment(Integer id, CitizenApartment updatedApartment);
    void deleteCitizenApartment(Integer id);
    CitizenApartment changeApartmentState(Integer id, Integer newState);
    int calculateOwnerLevel(Integer userId, Integer apartmentId);


}
