package org.knuba.task23;

import java.util.ArrayList;

public class Task23 {


    public static void main(String[] args) {
        int queueSize = 5;
        ArrayList<String> queue = new ArrayList<>(queueSize);

        Thread a = new Thread(() -> {
            int i = 244;
            while (true) {
                try {
                    Thread.sleep(100);
                    i = addToQueue(queueSize, queue, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }, "A");

        Thread b = new Thread(() -> {
            int i = 999;
            while (true) {
                try {
                    Thread.sleep(100);
                    i = addToQueue(queueSize, queue, i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B");

        Thread c = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    System.out.println("\nпотік " + Thread.currentThread().getName() + " видаляє з черги");
                    try {
                        queue.remove(0);
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Oб'єкти, що залишились у черзі: ");
                    for (int i = 0; i < queue.size(); i++) {
                        System.out.println("i = " + i + " " + queue.get(i));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C");

        a.start();
        b.start();
        c.start();
    }

    private static int addToQueue(int queueSize, ArrayList<String> queue, int i) {
        if (queue.size() < queueSize) {
            System.out.println("\nпотік " + Thread.currentThread().getName() + " додає у чергу");
            queue.add("Oб'єкт #" + i + " потоку " + Thread.currentThread().getName());
            i++;
        }
        return i;
    }
}
