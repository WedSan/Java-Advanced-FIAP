package fiap.checkpoint.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer number;

    private String type;

    @ManyToOne
    private Hotel hotel;

    @ManyToMany
    @JoinTable(name = "room_reservation_room",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "reservation_room_id"))
    private List<ReservationRoom> reservationRooms;

    public Room() {

    }

    public Room(Integer number, String type, Hotel hotel) {
        this.number = number;
        this.type = type;
        this.hotel = hotel;
    }

    public Room(Integer number, Long id, String type, Hotel hotel) {
        this.number = number;
        this.id = id;
        this.type = type;
        this.hotel = hotel;
    }

    public Room(List<ReservationRoom> reservationRooms, Hotel hotel, String type, Integer number, Long id) {
        this.reservationRooms = reservationRooms;
        this.hotel = hotel;
        this.type = type;
        this.number = number;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<ReservationRoom> getReservationRooms() {
        return reservationRooms;
    }

    public void setReservationRooms(List<ReservationRoom> reservationRooms) {
        this.reservationRooms = reservationRooms;
    }
}
