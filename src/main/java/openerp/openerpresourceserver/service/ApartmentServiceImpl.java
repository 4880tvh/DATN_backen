package openerp.openerpresourceserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import openerp.openerpresourceserver.entity.Apartment;
import openerp.openerpresourceserver.repo.ApartmentRepository;
import openerp.openerpresourceserver.repo.CitizenApartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@AllArgsConstructor(onConstructor_ = @Autowired)
@Service
public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentRepository apartmentRepository;
    private CitizenApartmentRepository citizenApartmentRepository;

    @Override
    public List<Apartment> getAllApartments() {
        updateApartmentState();
        List<Apartment> apartments = apartmentRepository.findAll();
        return apartments;
    }

    @Override
    public Apartment createApartment(Apartment apartment) {
        // Lưu apartment mới vào cơ sở dữ liệu
        return apartmentRepository.save(apartment);
    }

    @Override
    public Apartment updateApartment(Integer id, Apartment updatedApartment) {
        Apartment existingApartment = apartmentRepository.findById(id).orElse(null);
        if (existingApartment == null) {
            return null; // hoặc throw exception nếu không tìm thấy apartment với id tương ứng
        }

        existingApartment.setApartmentId(updatedApartment.getApartmentId());
        existingApartment.setCode(updatedApartment.getCode());
        existingApartment.setName(updatedApartment.getName());
        existingApartment.setDescription(updatedApartment.getDescription());
        existingApartment.setPrice(updatedApartment.getPrice());
        existingApartment.setBuildingId(updatedApartment.getBuildingId());
        return apartmentRepository.save(existingApartment);
    }

    @Override
    public void deleteApartment(Integer apartmentId) {
        Apartment apartment = apartmentRepository.findById(apartmentId).orElse(null);
        if (apartment == null) {
            throw new NoSuchElementException("Apartment with ID " + apartmentId + " does not exist");
        }
        apartmentRepository.deleteById(apartmentId);
    }

    @Override
    public Apartment getApartmentById(Integer id) {
        Apartment apartment = apartmentRepository.findById(id).orElse(null);

        if (apartment != null) {
            log.info("Dữ liệu được trả về từ cơ sở dữ liệu: {}", apartment);
        } else {
            log.info("Không tìm thấy dữ liệu cho apartmentId: {}", id);
        }

        return apartment;
    }

    @Override
    public void updateApartmentState() {
        List<Apartment> apartments = apartmentRepository.findAll();

        for (Apartment apartment : apartments) {
            boolean isApartmentInUse = isApartmentInUse(apartment.getApartmentId());
            if (isApartmentInUse) {
                // Đặt trạng thái thành 1 nếu có bất kỳ citizen apartment nào sử dụng apartment này
                apartment.setState(1);
            } else {
                // Nếu không có citizen apartment nào sử dụng apartment này, đặt trạng thái thành 0
                apartment.setState(0);
            }
            apartmentRepository.save(apartment);
        }
    }

    private boolean isApartmentInUse(Integer apartmentId) {
        // Kiểm tra xem có bất kỳ citizen apartment nào sử dụng apartmentId này không
        return citizenApartmentRepository.existsByApartmentIdAndState(apartmentId, 1);
    }

    // Implement other methods for CRUD operations
}
