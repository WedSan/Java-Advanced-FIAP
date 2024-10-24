package fiap.checkpoint.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String document;

    @OneToMany(mappedBy = "client")
    private List<ReservationRoom> reservationRoom;

    public Client() {
    }

    public Client(String name, String email, String document) {
        this.name = name;
        this.email = email;
        this.document = document;
    }

    public Client(Long id, String name, String email, String document, List<ReservationRoom> reservationRoom) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.document = document;
        this.reservationRoom = reservationRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public List<ReservationRoom> getReservationRoom() {
        return reservationRoom;
    }

    public void setReservationRoom(List<ReservationRoom> reservationRoom) {
        this.reservationRoom = reservationRoom;
    }
}
