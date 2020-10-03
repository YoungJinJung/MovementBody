package com.project.movementbody.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBodyInformation {
    @Id//Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//auto_increment

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;//DB는 Object를 저장할 수 있다. FK, 자바는 오브젝트를 저장할 수 있다.

    private double height;
    private double weight;
    private int age;
    private double bodyFatMass;//체지방량
    private double muscleMass;//골격근량
    private int basalMetabolicRate;//기초대사량
    private int activity;//활동량

    @CreationTimestamp
    private LocalDateTime createDate;
}
