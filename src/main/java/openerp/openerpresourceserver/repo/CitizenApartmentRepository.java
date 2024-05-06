package openerp.openerpresourceserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import openerp.openerpresourceserver.entity.CitizenApartment;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface CitizenApartmentRepository extends JpaRepository<CitizenApartment, Integer> {
    int countByUserIdAndApartmentId(Integer userId, Integer apartmentId);
    List<CitizenApartment> findByStateNot(int state);

    boolean existsByApartmentIdAndState(Integer apartmentId, int state);
}