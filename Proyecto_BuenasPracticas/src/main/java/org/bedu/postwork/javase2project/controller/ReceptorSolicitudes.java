package org.bedu.postwork.javase2project.controller;

// POSTWORK 04

import org.bedu.postwork.javase2project.repository.SolicitudEstudiante;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ReceptorSolicitudes implements Runnable{
    private boolean enEjecucion = false;
    private Queue<SolicitudEstudiante> solicitudEstudiantes = new LinkedList<>();
    private final NotificadorInscripcion worker;

    public ReceptorSolicitudes(NotificadorInscripcion worker){
        this.worker = worker;
    }

    // Procesa y espera solicitudes.
    @Override
    public void run(){
        try {
            while (enEjecucion || solicitudEstudiantes.isEmpty()) {
                SolicitudEstudiante solicitud = solicitudEstudiantes.poll();

                if (solicitud == null){
                    System.out.println("Esperando solicitudes,...");
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                }
                worker.notificar_a_Maestro(solicitud);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // CHECKLIST: ReceptorSolicitudes puede agregar solicitudes a una lista,
    // retornar el estado de la ejecución así como iniciar y detener la ejecución.

    // Inicia ejecución.
    public void iniciar(){
        this.enEjecucion = true;
        new Thread(this).start();
    }

    // Detiene ejecución.
    public void detener(){
        this.enEjecucion = false;
    }

    // Adiciona solicitudes.
    public void registrarSolicitud(SolicitudEstudiante solicitud){
        solicitudEstudiantes.add(solicitud);
    }

    // Regresa si está en ejecución.
    public boolean estaEnEjecucion(){
        return enEjecucion;
    }
}
