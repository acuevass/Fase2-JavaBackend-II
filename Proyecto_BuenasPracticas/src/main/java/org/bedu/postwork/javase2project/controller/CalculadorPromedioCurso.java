package org.bedu.postwork.javase2project.controller;

// POSTWORK 02.

import org.bedu.postwork.javase2project.model.Curso;

// CHECKLIST: CalculadorPromedioCurso es un runnable y su constructor recibe un curso.
public class CalculadorPromedioCurso implements Runnable {
    private Curso curso;
    private double promedio;

    public CalculadorPromedioCurso(Curso curso){
        this.curso = curso;
    }

    // CHECKLIST: CalculadorPromedioCurso calcula el promedio de las calificaciones e imprime el resultado.
    @Override
    public void run(){
        int numAlumnos = 0;
        for (Integer i : curso.getCalificaciones().values()){
            promedio += i;
            numAlumnos++;
        }
        promedio /= numAlumnos;

        System.out.println("Promedio del curso: " + curso.getId() + " - " + curso.getMateria().getNombre() + " = " + promedio);

    }
}
