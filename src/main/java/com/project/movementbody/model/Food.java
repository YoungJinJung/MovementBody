package com.project.movementbody.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    @Id
    private String foodCode;
    private String foodName;
    private FoodCategory foodCategory;

    @Column(length = 100)
    private String foodDescription;

    private double foodCalorie;
    private double carbon;
    private double protein;
    private double fat;
    private double sodium;
    private double sugar;
}
