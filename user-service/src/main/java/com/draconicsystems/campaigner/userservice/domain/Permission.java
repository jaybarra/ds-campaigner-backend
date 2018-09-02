package com.draconicsystems.campaigner.userservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@Entity
@Immutable
@RequiredArgsConstructor
@NoArgsConstructor
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id", updatable = false, nullable = false)
    private Long id;

    @NaturalId
    @NonNull
    @Column(nullable = false, unique = true)
    private String name;
    @NonNull
    private String description;
}
