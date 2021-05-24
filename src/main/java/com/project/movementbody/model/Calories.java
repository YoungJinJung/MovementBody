package com.project.movementbody.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private double totalCalorie;
    @Column(nullable = false)
    private double carbonCalorie;
    @Column(nullable = false)
    private double proteinCalorie;
    @Column(nullable = false)
    private double fatCalorie;
}
