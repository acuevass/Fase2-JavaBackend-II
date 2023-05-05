package org.bedu.postwork.javase2project.controller;

// POSTWORK 04.

import org.bedu.postwork.javase2project.repository.SolicitudEstudiante;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.bedu.postwork.javase2project.repository.InscripcionAlumnos_Rep.crearSolicitudes;

public class InscripcionAlumnos_Ctrl {
    public static void main(String[] args) {
        Random random = new Random();

        // CHECKLIST: InscripcionAlumnos notifica con un eventLoop y worker cada que un alumno se
        // inscribe a un curso y al maestro que se realizó la inscripción.
        ReceptorSolicitudes eventLoop = new ReceptorSolicitudes(solicitud -> {
            if (solicitud.getEstudiante() == null || solicitud.getCurso() == null) {
                System.out.println("Datos incompletos, solicitud rechazada.");
            }
            System.out.println("Se ha inscrito al estudiante " + solicitud.getEstudiante().getNombre_completo()
                    + " en la materia: " + solicitud.getCurso().getMateria().getNombre());
        });

        eventLoop.iniciar();
        SolicitudEstudiante[] solicitudes = crearSolicitudes();

        for (SolicitudEstudiante s : solicitudes) {
            eventLoop.registrarSolicitud(s);
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        eventLoop.detener();
    }

}
