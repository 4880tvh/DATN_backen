package openerp.openerpresourceserver.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import openerp.openerpresourceserver.service.CitizenService;
import openerp.openerpresourceserver.entity.Citizen;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletOutputStream;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.core.io.InputStreamResource;
import java.io.ByteArrayInputStream;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/citizens")
public class CitizenController {

    private final CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Citizen>> getAllCitizens() {
        List<Citizen> citizens = citizenService.getAllCitizens();
        return ResponseEntity.ok().body(citizens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Citizen> getCitizen(@PathVariable Integer id) {
        Citizen citizen = citizenService.getCitizenById(id);
        if (citizen != null) {
            return ResponseEntity.ok().body(citizen);
        } else {
            return ResponseEntity.notFound().build();
        }
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
