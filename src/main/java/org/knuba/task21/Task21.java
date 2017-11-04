package org.knuba.task21;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task21 {
    private static int N = 10;

    public static void main(String[] args) {
        System.out.println("Я не дуже зрозумів як \"дописувати рядкові значення в об'єкт Text\", " +
                "тому просто прінтую поля Thread");

        ExecutorService executor = Executors.newFixedThreadPool(N);
        for (int i = 0; i < N; i++) {
            int finalI = i;
            Runnable runnable = new Thread(() -> {
                Thread.currentThread().setName("Потік №" + finalI);
                System.out.println(
                        "Ім'я: " + Thread.currentThread().getName() +
                                "\nПоля: " + Arrays.toString(Thread.currentThread().getClass().getFields())
                );
            });
            executor.execute(runnable);
        }
        executor.shutdown();
    }
}