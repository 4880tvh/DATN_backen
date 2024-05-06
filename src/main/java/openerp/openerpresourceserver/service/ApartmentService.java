package openerp.openerpresourceserver.service;

import openerp.openerpresourceserver.entity.Apartment;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ApartmentService {
    List<Apartment> getAllApartments();

    Apartment createApartment(Apartment apartment);
    Apartment updateApartment(Integer id, Apartment apartment);
    void deleteApartment(Integer id);
    Apartment getApartmentById(Integer apartmentId);
    // Other methods for CRUD operations
    void updateApartmentState();
}

