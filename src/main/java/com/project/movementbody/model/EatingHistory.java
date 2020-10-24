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
public class EatingHistory {
    @Id//Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//auto_increment

    @OneToOne(fetch = FetchType.EAGER) // Many = History, One = User
    @JoinColumn(name = "memberId")
    private Member member;//DB는 Object를 저장할 수 있다. FK, 자바는 오브젝트를 저장할 수 있다.

    private TimeCode timeCode;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "foodCode")
    private Food food;

    private LocalDateTime eatingDate;

    @CreationTimestamp
    private LocalDateTime registerDate;
}
