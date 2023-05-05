package org.bedu.postwork.javase2project.controller;

//POSTWORK 05.

import org.bedu.postwork.javase2project.model.Curso;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

// POSTWORK 05.
@Component
public class CalcularPromedioCursoRx {
    public Mono<Double> calcularPromedio(Curso curso){

        // CHECKLIST: CalcularPromedioCursoRx puede calcular los promedios
        // de un curso, utilizando Flux y Mono de publisher.

        // CHECKLIST: El código generado utiliza Streams paralelos y Programación reactiva.
        return Flux.fromStream(curso.getCalificaciones().values().parallelStream())
                .collect(Collectors.averagingDouble(i -> (double) i));

    }
}
