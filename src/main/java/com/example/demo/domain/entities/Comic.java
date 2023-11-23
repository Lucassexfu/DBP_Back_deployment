package com.example.demo.domain.entities;

import java.util.HashSet;
import java.util.List;
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
@Table(name = "comic")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;
    private String nombre;
    private String fecha_de_publicación;
    @Column(length = 5000)
    private String descripcion;
    private List<String> imagenes_description;
    private Integer precio;
    private Integer likes;
    private Integer dislikes;
    private String genero;


    @ElementCollection
    @CollectionTable(name = "comic_generos", joinColumns = @JoinColumn(name = "comic_id"))
    @Column(name = "genero")
    private Set<String> generos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    
    @OneToMany(mappedBy = "comic", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comentarios> comentarios = new HashSet<>();
    
    @ManyToMany(mappedBy = "comics", cascade = CascadeType.ALL)
    private Set<Venta> vendido = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "comic_id")
    private List<Temporada> temporadas;
    


}