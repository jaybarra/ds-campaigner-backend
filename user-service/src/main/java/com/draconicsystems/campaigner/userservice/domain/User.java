package com.draconicsystems.campaigner.userservice.domain;

import lombok.Data;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long id;

    @NaturalId
    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String saltedPassword;

    @CreatedDate
    @Column(updatable = false)
    private Date createdOn = new Date();

    private Date lastLogin = new Date();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Set<Role> roles = new HashSet<>();
}
