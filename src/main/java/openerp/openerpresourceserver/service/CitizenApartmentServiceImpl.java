package openerp.openerpresourceserver.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import openerp.openerpresourceserver.entity.CitizenApartment;
import openerp.openerpresourceserver.service.CitizenApartmentService;
import openerp.openerpresourceserver.repo.CitizenApartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.util.List;
@Log4j2
@AllArgsConstructor(onConstructor_ = @Autowired)
@Service
public class CitizenApartmentServiceImpl implements CitizenApartmentService {
    @Autowired
    private CitizenApartmentRepository citizenApartmentRepository;

    @Override
    public List<CitizenApartment> getAllCitizenApartments() {
        // Lấy tất cả citizen apartments trừ những cái có state = 0
        List<CitizenApartment> citizenapartments = citizenApartmentRepository.findByStateNot(0);
        return citizenapartments;
    }
    @Override
    public CitizenApartment getCitizenApartmentById(Integer id) {
        CitizenApartment citizenapartment = citizenApartmentRepository.findById(id).orElse(null);

        if (citizenapartment != null) {
            log.info("haved found: {}", citizenapartment);
        } else {
            log.info("cannot find data apartmentId: {}", id);
        }
        return citizenapartment;
    }
    @Override
    public CitizenApartment createCitizenApartment(CitizenApartment newApartment) {
        // Xác định ownerLevel
        int ownerLevel = calculateOwnerLevel(newApartment.getUserId(), newApartment.getApartmentId());

        // Thiết lập state mặc định
        newApartment.setState(1);

        // Thiết lập ownerLevel
        newApartment.setOwnerLevel(ownerLevel);

        // Lưu citizen apartment mới vào cơ sở dữ liệu
        return citizenApartmentRepository.save(newApartment);
    }

    @Override
    public int calculateOwnerLevel(Integer userId, Integer apartmentId) {
        // Viết logic để đếm số hợp đồng hiện có của userId và apartmentId và trả về ownerLevel
        // Đây là một ví dụ giả định
        // Tính số lượng hợp đồng hiện có với userId và apartmentId
        int existingContractsCount = citizenApartmentRepository.countByUserIdAndApartmentId(userId, apartmentId);
        // ownerLevel = số lượng hợp đồng hiện có + 1
        return existingContractsCount + 1;
    }

    @Override
    public CitizenApartment updateCitizenApartment(Integer id, CitizenApartment updatedApartment) {
        CitizenApartment existingApartment = citizenApartmentRepository.findById(id).orElse(null);
        if (existingApartment == null) {
            return null; // hoặc throw exception nếu không tìm thấy citizen apartment với id tương ứng
        }

        existingApartment.setUserId(updatedApartment.getUserId());
        existingApartment.setApartmentId(updatedApartment.getApartmentId());
        existingApartment.setOwnerLevel(updatedApartment.getOwnerLevel());
        existingApartment.setDayStart(updatedApartment.getDayStart());
        existingApartment.setDayEnd(updatedApartment.getDayEnd());
        existingApartment.setState(updatedApartment.getState());
        existingApartment.setCost(updatedApartment.getCost());

        return citizenApartmentRepository.save(existingApartment);
    }

    @Override
    public void deleteCitizenApartment(Integer id) {
        CitizenApartment citizenApartment = citizenApartmentRepository.findById(id).orElse(null);
        if (citizenApartment != null) {
            // Chuyển state về 0 thay vì xóa khỏi cơ sở dữ liệu
            citizenApartment.setState(0);
            citizenApartmentRepository.save(citizenApartment);
        }
    }

    @Override
    public CitizenApartment changeApartmentState(Integer id, Integer newState) {
        CitizenApartment citizenApartment = citizenApartmentRepository.findById(id).orElse(null);
        if (citizenApartment != null) {
            citizenApartment.setState(newState);
            return citizenApartmentRepository.save(citizenApartment);
        } else {
            return null; // hoặc throw exception nếu không tìm thấy citizenApartment với id tương ứng
        }
    }
//    @Override
//    public Apartment getApartmentById(Integer id) {
//        Apartment apartment = apartmentRepository.findById(id).orElse(null);
//
//        if (apartment != null) {
//            log.info("Dữ liệu được trả về từ cơ sở dữ liệu: {}", apartment);
//        } else {
//            log.info("Không tìm thấy dữ liệu cho apartmentId: {}", id);
//        }
//
//        return apartment;
//    }

    // Implement other methods for CRUD operations
}
