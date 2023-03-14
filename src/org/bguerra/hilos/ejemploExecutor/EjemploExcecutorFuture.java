package org.bguerra.hilos.ejemploExecutor;

import java.util.concurrent.*;

public class EjemploExcecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
            return "Algun resultado importante de la tarea";
        };
        Future<String> resultado = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del metodo main 1");

        //System.out.println(resultado.isDone());
        while (!resultado.isDone()) {
            System.out.println("Ejecutando tarea...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        System.out.println("Obtenemos resultado de la tarea: " + resultado.get());
        System.out.println("Finaliza la tarea: " + resultado.isDone());

    }
}
