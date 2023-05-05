package org.bedu.postwork.javase2project.controller;

// POSTWORK 03.

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


import static org.assertj.core.api.Assertions.*; // Para habilitar assertThat.

class ReporteCalificacionesTest {
    private static final Curso CURSO = new Curso();
    private static final Estudiante ESTUDIANTE1 = new Estudiante();
    private static final Estudiante ESTUDIANTE2 = new Estudiante();
    private static final Estudiante ESTUDIANTE3 = new Estudiante();
    private static final Estudiante ESTUDIANTE4 = new Estudiante();

    private static final Materia MATERIA = new Materia();

    private static ReporteCalificaciones.Reporte reporte1;
    private static ReporteCalificaciones.Reporte reporte2;
    private static ReporteCalificaciones.Reporte reporte3;
    private static ReporteCalificaciones.Reporte reporte4;
    static {
        MATERIA.setNombre("Arquitectura de Base de Datos");

        ESTUDIANTE1.setNombre_completo("Alfredo");
        ESTUDIANTE2.setNombre_completo("Alejandra");
        ESTUDIANTE3.setNombre_completo("Zeus");
        ESTUDIANTE4.setNombre_completo("Afrodita");

        CURSO.setCiclo("2023");
        CURSO.setMateria(MATERIA);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();
        calificaciones.put(ESTUDIANTE1, 9);
        calificaciones.put(ESTUDIANTE2, 10);
        calificaciones.put(ESTUDIANTE3, 7);
        calificaciones.put(ESTUDIANTE4,8);

        CURSO.setCalificaciones(calificaciones);

        reporte1 = new ReporteCalificaciones.Reporte("Alfredo", 9);
        reporte2 = new ReporteCalificaciones.Reporte("Alejandra", 10);
        reporte3 = new ReporteCalificaciones.Reporte("Zeus", 7);
        reporte4 = new ReporteCalificaciones.Reporte("Afrodita", 8);

    }

    // CHECKLIST: ReporteCalificacionesTest ejecuta las funciones de ReporteCalificaciones
    // para generar y ordenar los datos.
    @Test
    @DisplayName("Postwork 03: Ordena alfabéticamente")
    void ordenaLista() {
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        assertThat(reporteCalificaciones.ordenaLista(CURSO)).containsExactly(reporte4, reporte2, reporte1, reporte3);
    }

    @Test
    void calificacion() {
        ReporteCalificaciones reporteCalificaciones = new ReporteCalificaciones();

        assertThat(reporteCalificaciones.calificacion(CURSO)).containsExactly(reporte2, reporte1, reporte4, reporte3);
    }
}