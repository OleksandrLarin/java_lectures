package lecture25.jpa.model.entities;

import lecture25.jpa.model.Status;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "car_rent")
public class CarRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "car_number")
    private String carNumber;
    @Column(name = "driver_licence_id")
    private String driverLicenceId;
    @Column(name = "status")
    private Status rentStatus;
    @Column(name = "start_rent_date")
    private LocalDate startRentDate;
    @Column(name = "end_rent_date")
    private LocalDate endRentDate;
    @OneToOne
    private RentPrice rentPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getDriverLicenceId() {
        return driverLicenceId;
    }

    public void setDriverLicenceId(String driverLicenceId) {
        this.driverLicenceId = driverLicenceId;
    }

    public Status getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(Status rentStatus) {
        this.rentStatus = rentStatus;
    }

    public LocalDate getStartRentDate() {
        return startRentDate;
    }

    public void setStartRentDate(LocalDate startRentDate) {
        this.startRentDate = startRentDate;
    }

    public LocalDate getEndRentDate() {
        return endRentDate;
    }

    public void setEndRentDate(LocalDate endRentDate) {
        this.endRentDate = endRentDate;
    }

    public RentPrice getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(RentPrice rentPrice) {
        this.rentPrice = rentPrice;
    }
}
