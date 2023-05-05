package org.bedu.postwork.javase2project.controller;

// POSTWORK 05.

import org.bedu.postwork.javase2project.controller.CalcularPromedioCursoRx;
import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class CalcularPromedioCursoRxTest {

    private static final Curso CURSO = new Curso();

    static {
        Estudiante estudiante_1 = new Estudiante();
        estudiante_1.setNombre_completo("Estudiante No.1");
        Estudiante estudiante_2 = new Estudiante();
        estudiante_2.setNombre_completo("Estudiante No.2");
        Estudiante estudiante_3 = new Estudiante();
        estudiante_3.setNombre_completo("Estudiante No.3");
        Estudiante estudiante_4 = new Estudiante();
        estudiante_4.setNombre_completo("Estudiante No.4");

        Materia materia = new Materia();
        Curso curso = new Curso();

        CURSO.setCiclo("2023");
        CURSO.setMateria(materia);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(estudiante_1, 10);
        calificaciones.put(estudiante_2, 8);
        calificaciones.put(estudiante_3, 7);
        calificaciones.put(estudiante_4, 9);

        CURSO.setCalificaciones(calificaciones);

    }

    // CHECKLIST: CalcularPromedioCursoRxTest generá por lo menos tres estudiantes y una materia y un curso.
    @Test
    @DisplayName("Postwork 05: Calcula promedio.")
    void calcularPromedio() {
        CalcularPromedioCursoRx promedio = new CalcularPromedioCursoRx();

        // CHECKLIST: CalcularPromedioCursoRxTest calcula el promedio de un
        // curso ejecutando el método generado en el paso tres con la ayuda de publisher.
        promedio.calcularPromedio(CURSO).subscribe(p -> assertThat(p)
                .isEqualTo(8.5, within(0.02)));
    }
}