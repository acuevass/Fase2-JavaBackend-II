package org.bedu.postwork.javase2project.model;

// POSTWORK 01.

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "materias")
public class Materia {

    // Atributos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    // Setters & Getters.
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Equals / Hash.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia materia)) return false;
        return Objects.equals(getId(), materia.getId()) &&
                Objects.equals(getNombre(), materia.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre());
    }
}
