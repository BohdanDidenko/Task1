package com.epam.task8.task8_3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {


    public void run(){
        testHashMap();
        testConcurrentHashMap();
    }

    private void testHashMap() {
        Map<Integer, Integer> map = new HashMap();
        Thread[] threadsWrite = new Thread[10000];
        Thread[] threadsRead = new Thread[10000];
        for (int i = 0; i < threadsWrite.length; i++) {
            int j = i;
            threadsWrite[i] = new Thread(() -> {
//                synchronized (map) {
                    map.put(j, j);
//                }
            });
            threadsRead[i] = new Thread(() -> {
//                synchronized (map) {
                    map.get(j);
//                }
            });
        }

        long start = System.nanoTime();
        for (int i = 0; i < threadsWrite.length; i++) {
            threadsRead[i].start();
            threadsWrite[i].start();
        }
        for (int i = 0; i < threadsWrite.length; i++) {
            try {
                threadsRead[i].join();
                threadsWrite[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();
        System.out.println("Time = " + (end - start) / 1_000_000_000.0);
    }



    private void testConcurrentHashMap() {
        Map<Integer, Integer> map = new HashMap();
        Thread[] threadsWrite = new Thread[10000];
        Thread[] threadsRead = new Thread[10000];
        for (int i = 0; i < threadsWrite.length; i++) {
            int j = i;
            threadsWrite[i] = new Thread(() -> map.put(j, j));
            threadsRead[i] = new Thread(() -> map.get(j));
        }

        long start = System.nanoTime();
        for (int i = 0; i < threadsWrite.length; i++) {
            threadsRead[i].start();
            threadsWrite[i].start();
        }
        for (int i = 0; i < threadsWrite.length; i++) {
            try {
                threadsRead[i].join();
                threadsWrite[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.nanoTime();
        System.out.println("Time = " + (end - start) / 1_000_000_000.0);
    }
}
