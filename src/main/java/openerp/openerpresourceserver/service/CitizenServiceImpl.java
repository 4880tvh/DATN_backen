package openerp.openerpresourceserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import openerp.openerpresourceserver.entity.Citizen;
import openerp.openerpresourceserver.repo.CitizenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Optional;
@Log4j2
@AllArgsConstructor(onConstructor_ = @Autowired)
@Service
public class CitizenServiceImpl implements CitizenService {
    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    public List<Citizen> getAllCitizens() {
        List<Citizen> citizens = citizenRepository.findAll();
        return citizens;
    }
    @Override
    public Citizen getCitizenById(Integer id) {
        return citizenRepository.findById(id).orElse(null);
    }

    // Implement other methods for CRUD operations
    @Override
    public Citizen createCitizen(Citizen citizen) {
        // Lưu apartment mới vào cơ sở dữ liệu
        return citizenRepository.save(citizen);
    }

    @Override
    public Citizen updateCitizen(Integer id, Citizen updatedCitizen) {
        Citizen existingCitizen = citizenRepository.findById(id).orElse(null);
        if (existingCitizen == null) {
            return null; // hoặc throw exception nếu không tìm thấy apartment với id tương ứng
        }
        existingCitizen.setName(updatedCitizen.getName());
        existingCitizen.setAge(updatedCitizen.getAge());
        existingCitizen.setDob(updatedCitizen.getDob());
        existingCitizen.setAddress(updatedCitizen.getAddress());
        existingCitizen.setEmail(updatedCitizen.getEmail());
        existingCitizen.setPhone(updatedCitizen.getPhone());
        existingCitizen.setNin(updatedCitizen.getNin());

        return citizenRepository.save(existingCitizen);
    }

    @Override
    public void deleteCitizen(Integer citizenId) {
        Citizen citizen = citizenRepository.findById(citizenId).orElse(null);
        if (citizen == null) {
            throw new NoSuchElementException("Citizen with ID " + citizenId + " does not exist");
        }
        citizenRepository.deleteById(citizenId);
    }
}
