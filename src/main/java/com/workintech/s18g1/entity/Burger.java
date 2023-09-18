package com.workintech.s18g1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "burger", schema = "spring")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Positive
    private long id;

    @Column(name="name")
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String name;

    @Column(name="price")
    @Min(value = 0)
    private double price;

    @Column(name="isVegan")
    private boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column(name="contents")
    @Size(min = 2, max = 50)
    @NotNull
    private String contents;
}
