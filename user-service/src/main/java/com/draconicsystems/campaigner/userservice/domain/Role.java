package com.draconicsystems.campaigner.userservice.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", updatable = false, nullable = false)
    private Long id;

    @NaturalId
    @Column(nullable = false)
    @NonNull
    private String name;

    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_id")
    private Set<Permission> permissions = new HashSet<>();
}
