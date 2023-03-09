package com.vivek.sbpractice.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="emp_id")
    private int id;

    @Column(name="emp_name")
    private String name;

    @Column(name="emp_company")
    private String company;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

}
