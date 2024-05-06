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
@Entity
@Table(name = "moa_apartments")
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id",updatable = false, nullable = false)
    private Integer apartmentId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "is_rented")
    private Boolean isRented;

    @Column(name = "is_using_service")
    private Boolean isUsingService;

    @Column(name = "state")
    private Integer state;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name = "building_id")
    private Integer buildingId;

//    @Override
//    public String toString() {
//        return "Apartment{" +
//                "apartmentId=" + apartmentId +
//                ", code='" + code + '\'' +
//                ", name='" + name + '\'' +
//                ", isRented=" + isRented +
//                ", isUsingService=" + isUsingService +
//                ", state=" + state +
//                ", description='" + description + '\'' +
//                '}';
//    }
    // Getters and setters
public Apartment() {
}

    public Apartment(Integer apartmentId, String code, String name, Boolean isRented, Boolean isUsingService, Integer state, String description, Integer price, Integer buildingId) {
        this.apartmentId = apartmentId;
        this.code = code;
        this.name = name;
        this.isRented = isRented;
        this.isUsingService = isUsingService;
        this.state = state;
        this.description = description;
        this.buildingId = buildingId;
    }

    // Getter and setter methods
    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsRented() {
        return isRented;
    }

    public void setIsRented(Boolean rented) {
        isRented = rented;
    }

    public Boolean getIsUsingService() {
        return isUsingService;
    }

    public void setIsUsingService(Boolean usingService) {
        isUsingService = usingService;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBuildingId() {return buildingId;}

    public void setBuildingId(Integer buildingId) { this.buildingId = buildingId;}
}