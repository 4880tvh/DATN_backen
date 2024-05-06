package openerp.openerpresourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import openerp.openerpresourceserver.service.ApartmentService;
import openerp.openerpresourceserver.entity.Apartment;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/apartments")
public class ApartmentController {

    private ApartmentService apartmentService;
    @GetMapping("/get-all")
    public ResponseEntity<?> getAllApartments() {
        List<Apartment> apartments = apartmentService.getAllApartments();
        return ResponseEntity.ok().body(apartments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApartmentById(@PathVariable Integer id) {
        Apartment apartment = apartmentService.getApartmentById(id);
        return ResponseEntity.ok().body(apartment);
    }

    @PostMapping("/create")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment) {
        // Lưu citizen apartment mới vào cơ sở dữ liệu
        Apartment createdApartment = apartmentService.createApartment(apartment);

        return ResponseEntity.ok().body(createdApartment);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Apartment> updateApartment(@PathVariable Integer id, @RequestBody Apartment updateApartment) {
        Apartment updatedApartment = apartmentService.updateApartment(id, updateApartment);
        if (updatedApartment != null) {
            return ResponseEntity.ok().body(updatedApartment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable Integer id) {
        apartmentService.deleteApartment(id);
        return ResponseEntity.ok().build();
    }
    // Other REST endpoints for CRUD operations
    @PostMapping("/update-state")
    public ResponseEntity<String> updateApartmentState() {
        apartmentService.updateApartmentState();
        return new ResponseEntity<>("Apartment states updated successfully", HttpStatus.OK);
    }
}
