package org.bedu.postwork.javase2project.repository;

// POSTWORK 02.

import org.bedu.postwork.javase2project.controller.CalculadorPromedioCurso;
import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// CHECKLIST: Postwork2 genera por lo menos 4 cursos con 20 estudiantes con calificaciones aleatorias.
public class Postwork2 {

    // CHECKLIST: Los cursos son promediados con hilos independientes con ExecutorService.
    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService pool = Executors.newCachedThreadPool();
        Curso[] cursos = new Curso[]{
                agregaCurso(random, "Minería de Datos", 1),
                agregaCurso(random, "Base de Datos", 2),
                agregaCurso(random, "Sistemas Operativos", 3),
                agregaCurso(random, "Historia de la Computación", 4)
        };
        for (Curso curso : cursos){
            pool.execute(new CalculadorPromedioCurso(curso));
        }
        pool.shutdown();
    }

    private static Curso agregaCurso(Random random, String nombreMateria, long idCurso){
        Curso curso_aux = new Curso();
        curso_aux.setId(idCurso);
        Materia materia_aux = new Materia();
        materia_aux.setNombre(nombreMateria);
        curso_aux.setMateria(materia_aux);

        Map<Estudiante, Integer> calificaciones = new HashMap<>();

        // CHECKLIST: Cantidad de Estudiantes.
        for (int i = 0; i < 50; i++){
            //******************* AQUÍ VOY
            Estudiante estudiante = new Estudiante();
            estudiante.setId((long)i);
            estudiante.setNombre_completo("Estudiante " + i);
            calificaciones.put(estudiante, random.nextInt(10));
        }
        curso_aux.setCalificaciones(calificaciones);
        return curso_aux;
    }
}
