package openerp.openerpresourceserver.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import openerp.openerpresourceserver.service.CitizenService;
import openerp.openerpresourceserver.entity.Citizen;
import java.util.List;
@RestController
@AllArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/citizens")
public class CitizenController {

    private CitizenService citizenService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllCitizens() {
        List<Citizen> citizens = citizenService.getAllCitizens();
        return ResponseEntity.ok().body(citizens);
    }

    @GetMapping("/{id}")
    public Citizen getCitizen(@PathVariable Integer id) {
        return citizenService.getCitizenById(id);
    }

    // Other REST endpoints for CRUD operations
    @PostMapping("/create")
    public ResponseEntity<Citizen> createCitizen(@RequestBody Citizen citizen) {

        Citizen createdCitizen = citizenService.createCitizen(citizen);

        return ResponseEntity.ok().body(createdCitizen);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Citizen> updateCitizen(@PathVariable Integer id, @RequestBody Citizen updateCitizen) {
        Citizen updatedCitizen = citizenService.updateCitizen(id, updateCitizen);
        if (updatedCitizen != null) {
            return ResponseEntity.ok().body(updatedCitizen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCitizen(@PathVariable Integer id) {
        citizenService.deleteCitizen(id);
        return ResponseEntity.ok().build();
    }
}
