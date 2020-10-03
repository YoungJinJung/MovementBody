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
public class User {
    @Id//Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//auto_increment

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @CreationTimestamp
    private LocalDateTime createDate;
}
