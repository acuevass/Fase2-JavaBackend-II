package org.bedu.postwork.javase2project.model;

// POSTWORK 01.

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
    // Atributos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "nombre_completo")
    private String nombre_completo;

    // Setters y Getters.
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre_completo() {
        return nombre_completo;
    }
    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    // Equals & Hash.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante that)) return false;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getNombre_completo(), that.getNombre_completo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre_completo());
    }
}
