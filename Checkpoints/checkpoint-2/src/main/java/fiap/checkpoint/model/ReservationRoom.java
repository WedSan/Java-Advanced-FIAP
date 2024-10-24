package fiap.checkpoint.model;

import fiap.checkpoint.model.exception.RoomReservationDateException;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class ReservationRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Room> rooms;

    @OneToMany(mappedBy = "reservationRoom")
    private List<OrderServiceModel> orderServiceModel;

    public ReservationRoom() {
    }

    public ReservationRoom(LocalDate checkInDate, LocalDate checkOutDate, Client client, List<Room> rooms) {
        validateDate(checkInDate, checkOutDate);
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.client = client;
        this.rooms = rooms;
    }

    public ReservationRoom(Long id, LocalDate checkInDate,
                           LocalDate checkOutDate,
                           Client client,
                           List<Room> rooms,
                           List<OrderServiceModel> orderServiceModel) {
        validateDate(checkInDate, checkOutDate);
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.client = client;
        this.rooms = rooms;
        this.orderServiceModel = orderServiceModel;
    }

    private void validateDate(LocalDate checkInDate, LocalDate checkOutDate){
        if(checkInDate.isAfter(checkOutDate)){
            throw new RoomReservationDateException();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<OrderServiceModel> getOrderService() {
        return orderServiceModel;
    }

    public void setOrderService(List<OrderServiceModel> orderServiceModel) {
        this.orderServiceModel = orderServiceModel;
    }

}
