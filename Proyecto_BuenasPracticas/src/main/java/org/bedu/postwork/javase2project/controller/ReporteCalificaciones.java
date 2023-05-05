package org.bedu.postwork.javase2project.controller;

// // POSTWORK 03.


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ReporteCalificaciones {
    @Data
    @RequiredArgsConstructor
    static class Reporte{
        private final String nombreEstudiante;
        private final Integer calificacion;
    }

    // CHECKLIST: ReporteCalificaciones puede generar la lista de calificaciones.
    private List<Reporte> generaLista(Map<Estudiante, Integer> calificaciones, Comparator<Reporte> comparator){
        return calificaciones.entrySet().stream()
                .map(e -> new Reporte(e.getKey().getNombre_completo(),e.getValue()))
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    // CHECKLIST: ReporteCalificaciones puede ordenar cursos y calificaciones.
    public List<Reporte> ordenaLista(Curso curso){
        return generaLista(curso.getCalificaciones(),
                (rep1, rep2 )-> rep1.getNombreEstudiante().compareTo(rep2.getNombreEstudiante()));
    }

    public List<Reporte> calificacion(Curso curso){
        return generaLista(curso.getCalificaciones(),
                (resp1, resp2 )-> resp2.getCalificacion().compareTo(resp1.getCalificacion()));
    }
}
