package openerp.openerpresourceserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "moa_citizenapartment")
public class CitizenApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer citizenApartmentId;

    private Integer userId;

    private Integer apartmentId;

    private Integer ownerLevel;

    private Date dayStart;

    private Date dayEnd;

    private Integer state; // 1 la dang con su dung , 2 la dang doi thanh ly hop dong,3 la da duoc dat coc , 0 là da hoan thanh hoac la da xoa

    private Integer cost;
    // Getter and setter methods
    public Integer getCitizenApartmentId() {
        return citizenApartmentId;
    }

    public void setCitizenApartmentId(Integer citizenApartmentId) {
        this.citizenApartmentId = citizenApartmentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Integer getOwnerLevel() {
        return ownerLevel;
    }

    public void setOwnerLevel(Integer ownerLevel) {
        this.ownerLevel = ownerLevel;
    }

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

}
