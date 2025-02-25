package com.schoolproject.hotel.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_USER_PFP")
public class UserClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public UserClientEntity() {
    }

    public UserClientEntity(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
