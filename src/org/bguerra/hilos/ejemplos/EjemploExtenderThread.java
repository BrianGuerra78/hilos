package org.bguerra.hilos.ejemplos;

import org.bguerra.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("Jhon Doe");
        hilo.start();
        //Thread.sleep(100);
        Thread hilo2 = new NombreThread("Carlos");
        hilo2.start();

        NombreThread hilo3 = new NombreThread("Pepe");
        hilo3.start();
        System.out.println(hilo.getState());
    }
}