package com.example.demo.domain.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer precio_total;
    private Double costo_de_envio;
    private String estado;

    @ManyToMany
    @JoinTable(
            name = "Registro_ventas",
            joinColumns = @JoinColumn(name = "ventas_id"),
            inverseJoinColumns = @JoinColumn(name = "comics_id")
    )
    private Set<Comic> comics = new HashSet<>();


}