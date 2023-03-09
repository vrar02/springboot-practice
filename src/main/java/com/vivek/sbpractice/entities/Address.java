package com.vivek.sbpractice.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue
    private int id;

    private String city;

    private String country;

    private String state;

    @JsonBackReference
    @OneToOne(mappedBy = "address")
    private Employee employee;

}
