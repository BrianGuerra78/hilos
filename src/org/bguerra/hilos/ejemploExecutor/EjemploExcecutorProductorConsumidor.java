package org.bguerra.hilos.ejemploExecutor;

import org.bguerra.hilos.ejemplossync.Panaderia;
import org.bguerra.hilos.ejemplossync.runnable.Consumidor;
import org.bguerra.hilos.ejemplossync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExcecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        //ExecutorService executor = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);
        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");

    }
}
