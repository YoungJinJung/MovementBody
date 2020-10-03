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
    private int foodCode;

    private FoodCategory foodCategory;

    @Column(length = 100)
    private String foodDescription;

    private int foodCalorie;
    private int carbon;
    private int protein;
    private int fat;
    private int sodium;
    private int sugar;
}
