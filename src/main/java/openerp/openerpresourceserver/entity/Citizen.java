package openerp.openerpresourceserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Date;
@Entity
@Table(name = "moa_citizens")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String name;
    private Integer age;
    private Date dob;
    private String address;
    private String email;
    private String phone;
    private String nin;
    private Integer apartmentCode;

    // Getters and setters
    // Getter for userId
    public Integer getUserId() {
        return userId;
    }

    // Setter for userId
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public Integer getAge() {
        return age;
    }

    // Setter for age
    public void setAge(Integer age) {
        this.age = age;
    }

    // Getter for dob
    public Date getDob() {
        return dob;
    }

    // Setter for dob
    public void setDob(Date dob) {
        this.dob = dob;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for nin
    public String getNin() {
        return nin;
    }

    // Setter for nin
    public void setNin(String nin) {
        this.nin = nin;
    }

    // Getter for apartmentCode
    public Integer getApartmentCode() {
        return apartmentCode;
    }

    // Setter for apartmentCode
    public void setApartmentCode(Integer apartmentCode) {
        this.apartmentCode = apartmentCode;
    }
}