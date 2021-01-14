package com.project.movementbody.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

//    @OneToOne(fetch = FetchType.EAGER) // Many = History, One = User
//    @JoinColumn(name = "memberId")
//    @ManyToOne
//    @JoinColumn(name="memeberId")
//    private Member member;
    private String memberId;
    private TimeCode timeCode;

//    @OneToOne(fetch = FetchType.EAGER)
//    @ManyToOne
//    @JoinColumn(name = "foodCode")
    private String foodCode;
//    private Food food;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss" , timezone = "Asia/Seoul")
    private LocalDateTime eatingDate;

    @CreationTimestamp
    private LocalDateTime registerDate;
}
