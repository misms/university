package com.izzat.university.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    String id;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;

}
