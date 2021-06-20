package com.project.movementbody.model;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "member_memberId")
    private Member member;//DB는 Object를 저장할 수 있다. FK, 자바는 오브젝트를 저장할 수 있다.

    private TimeCode timeCode;

    @ManyToMany
    @JoinTable(
            name = "EatingHistory_Food",
            joinColumns = @JoinColumn(name = "eatingHistory_id"),
            inverseJoinColumns = @JoinColumn(name = "food_foodCode")
    )
    private List<Food> foodList;

    @Column(nullable = false)
    private long eatingDate;

    @CreationTimestamp
    private LocalDateTime registerDate = LocalDateTime.now();
}
