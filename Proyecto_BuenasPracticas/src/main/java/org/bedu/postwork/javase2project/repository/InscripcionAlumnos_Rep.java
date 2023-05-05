package org.bedu.postwork.javase2project.repository;

// POSTWORK 04.

import java.util.Random;

import org.bedu.postwork.javase2project.model.Curso;
import org.bedu.postwork.javase2project.model.Estudiante;
import org.bedu.postwork.javase2project.model.Materia;


public class InscripcionAlumnos_Rep {

    // CHECKLIST: InscripcionAlumnos genera y agrega por lo menos cuatro cursos y veinte estudiantes.
    public static SolicitudEstudiante[] crearSolicitudes() {
        Random rnd = new Random();
        Curso[] cursos = new Curso[]{
                crearCurso(rnd, "Minería de Datos", 1),
                crearCurso(rnd, "Base de Datos", 2),
                crearCurso(rnd, "Sistemas Operativos", 3),
                crearCurso(rnd, "Historia de la Computación", 4)
        };

        SolicitudEstudiante[] solicitudes = new SolicitudEstudiante[20];
        for (int i = 0; i < 20; i++) {
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre_completo("Estudiante " + i);
            estudiante.setId((long)i);

            solicitudes[i] = new SolicitudEstudiante(estudiante, cursos[rnd.nextInt(cursos.length)]);
        }
        return solicitudes;
    }

    private static Curso crearCurso(Random rnd, String nombreMateria, long idCurso) {
        Curso curso_aux = new Curso();
        curso_aux.setId(idCurso);
        Materia materia_aux = new Materia();
        materia_aux.setNombre(nombreMateria);
        curso_aux.setMateria(materia_aux);
        return curso_aux;
    }

}
