package com.springboot.advanced_jpa.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer price;
    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
