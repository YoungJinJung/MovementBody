package com.project.movementbody.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    private String memberId;

    @Column(nullable = false, length = 100, unique = true)
    private String memberName;

    @Column(nullable = true, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private int gender;

    @Column(nullable = false)
    private double height;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private int exerciseCode;
}
