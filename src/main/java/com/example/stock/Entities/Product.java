package com.example.stock.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "le nom ne peut être vide")
    private String name;
    @NotNull(message = "la description ne peut être vide")
    private String description;
    @NotNull(message = "l'image ne peut être vide")
    private String image;
    @NotNull(message = "le prix ne peut être vide")
    private double price;
}
