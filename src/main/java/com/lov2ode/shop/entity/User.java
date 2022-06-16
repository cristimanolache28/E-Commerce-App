package com.lov2ode.shop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private boolean enable;

    // stores image file name
    private String photo;

    // create intermediate table
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles", // table name
            joinColumns = @JoinColumn(name = "user_id"), // foreign key referencing back the entity table
            inverseJoinColumns = @JoinColumn(name = "role_id") // foreign key referencing the target entity
    )
    // I am using a collection for implementing many-to-many between user and role
    private Set<Role> roles = new HashSet<>();

}
