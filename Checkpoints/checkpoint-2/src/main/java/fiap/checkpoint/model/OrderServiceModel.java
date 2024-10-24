package fiap.checkpoint.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class OrderServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;

    @ManyToOne
    private ReservationRoom reservationRoom;

    @OneToMany
    private List<ServiceModel> serviceModel;

    public OrderServiceModel() {
    }


    public OrderServiceModel(LocalDate date, ReservationRoom reservationRoom, List<ServiceModel> serviceModel) {
        this.date = date;
        this.reservationRoom = reservationRoom;
        this.serviceModel = serviceModel;
    }

    public OrderServiceModel(Long id, LocalDate date, ReservationRoom reservationRoom, List<ServiceModel> serviceModel) {
        this.id = id;
        this.date = date;
        this.reservationRoom = reservationRoom;
        this.serviceModel = serviceModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ReservationRoom getReservationRoom() {
        return reservationRoom;
    }

    public void setReservationRoom(ReservationRoom reservationRoom) {
        this.reservationRoom = reservationRoom;
    }

    public List<ServiceModel> getService() {
        return serviceModel;
    }

    public void setService(List<ServiceModel> serviceModel) {
        this.serviceModel = serviceModel;
    }
}
