package org.bguerra.hilos.ejemplossync;

import org.bguerra.hilos.ejemplossync.runnable.Consumidor;
import org.bguerra.hilos.ejemplossync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();
        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
