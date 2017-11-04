package org.knuba.task22;


import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task22 {
    private static int N = 5;

    public static void main(String[] args) {
        int n = 3;
        ExecutorService executor = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
            Runnable worker = new Thread(() -> {
                ArrayList<String> words = new ArrayList<>();

                String strWord = "class";
                for (int i1 = 0; i1 < 4; i1++) {
                    words.add(strWord);
                }
                int wordsCount = 0;
                for (int k = 0; k < words.size(); k++) {
                    if (words.get(k).equalsIgnoreCase(strWord)) {
                        wordsCount = (k + 1);
                    }
                }
                System.out.println("Cлів \"class\" у потоці " +
                        Thread.currentThread().getName().toUpperCase() + " знайдено: "
                        + wordsCount);
            });
            executor.execute(worker);
        }
        executor.shutdown();
    }
}
