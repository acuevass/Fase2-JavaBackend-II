package org.bedu.postwork.javase2project.controller;

// POSTWORK 04.


import org.bedu.postwork.javase2project.repository.SolicitudEstudiante;

// CHECKLIST: NotificadorInscripcion es una interfaz y tiene un método para notificar.
public interface NotificadorInscripcion {
    void notificar_a_Maestro(SolicitudEstudiante estudiante);
}
