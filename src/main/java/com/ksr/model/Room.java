package com.ksr.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "owner")
    private String owner;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "room", targetEntity = RoomShare.class)
    @JsonManagedReference
    private Set<RoomShare> roomShares;

    public Room(String city, String owner) {
        this.city = city;
        this.owner = owner;
    }
}
