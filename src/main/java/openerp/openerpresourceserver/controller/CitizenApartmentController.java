package openerp.openerpresourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import openerp.openerpresourceserver.entity.CitizenApartment;
import openerp.openerpresourceserver.service.CitizenApartmentService;
import java.util.List;
@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/citizenapartments")
public class CitizenApartmentController {

    private CitizenApartmentService citizenApartmentService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllCitizenApartments() {
        List<CitizenApartment> citizenapartments = citizenApartmentService.getAllCitizenApartments();
        return ResponseEntity.ok().body(citizenapartments);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>  getCitizenApartmentById(@PathVariable Integer id) {
        CitizenApartment citizenapartment = citizenApartmentService.getCitizenApartmentById(id);
        return ResponseEntity.ok().body(citizenapartment);
    }

    @PostMapping("/create")
    public ResponseEntity<CitizenApartment> createCitizenApartment(@RequestBody CitizenApartment newApartment) {
        // Xác định ownerLevel
        int ownerLevel = citizenApartmentService.calculateOwnerLevel(newApartment.getUserId(), newApartment.getApartmentId());

        // Thiết lập state mặc định
        newApartment.setState(1);

        // Thiết lập ownerLevel
        newApartment.setOwnerLevel(ownerLevel);

        // Lưu citizen apartment mới vào cơ sở dữ liệu
        CitizenApartment createdApartment = citizenApartmentService.createCitizenApartment(newApartment);

        return ResponseEntity.ok().body(createdApartment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CitizenApartment> updateCitizenApartment(@PathVariable Integer id, @RequestBody CitizenApartment updatedApartment) {
        CitizenApartment updatedApartmentEntity = citizenApartmentService.updateCitizenApartment(id, updatedApartment);
        if (updatedApartmentEntity != null) {
            return ResponseEntity.ok().body(updatedApartmentEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCitizenApartment(@PathVariable Integer id) {
        citizenApartmentService.deleteCitizenApartment(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/changestate/{id}/{newState}")
    public ResponseEntity<CitizenApartment> changeApartmentState(@PathVariable Integer id, @PathVariable Integer newState) {
        CitizenApartment updatedCitizenApartment = citizenApartmentService.changeApartmentState(id, newState);
        if (updatedCitizenApartment != null) {
            return ResponseEntity.ok().body(updatedCitizenApartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getApartmentById(@PathVariable Integer id) {
//        Apartment apartment = apartmentService.getApartmentById(id);
//        return ResponseEntity.ok().body(apartment);
//    }
    // Other REST endpoints for CRUD operations
}
