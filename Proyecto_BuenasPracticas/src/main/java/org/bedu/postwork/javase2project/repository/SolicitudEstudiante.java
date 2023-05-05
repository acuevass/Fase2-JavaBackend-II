package org.bedu.postwork.javase2project.repository;

// POSTWORK 04

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;

// CHECKLIST: SolicitudEstudiante recibe Estudiante y Curso en su constructor,
// además tiene sus get() y set().
public class SolicitudEstudiante {

    // Atributos.
    private Estudiante estudiante;
    private Curso curso;

    // Constructor.
    public SolicitudEstudiante(Estudiante estudiante, Curso curso){
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
