package com.epam.task8.task8_4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

public class Runner extends RecursiveTask<Long> {
    private static final int SIZE_ARRAY = 1_000_000;
    private static final int NUM_THREADS = 16;
    long[] array;
    int from = 0;
    int to = SIZE_ARRAY;

    public Runner(long[] array, int from, int to) {
        this.from = from;
        this.to = to;
        this.array = array;
    }

    @Override
    protected Long compute() {
        if((to - from) < 20){
            long count = 0;
            for (int i = from; i < to; i++) {
                count += array[i];
            }
            return count;
        }
        else{
            int mid = (from + to) / 2;
            Runner firstRunner = new Runner(array, from, mid);
//            firstRunner.fork();
            Runner secondRunner = new Runner(array, mid, to);
            invokeAll(firstRunner, secondRunner);
//            long secondResult = secondRunner.compute();
            return firstRunner.join() + secondRunner.join();
//            return firstRunner.join() + secondResult;
        }
    }

    public static void main(String[] args) {
        long[] arrayForCount = new long[SIZE_ARRAY];
        arrayForCount = initArrayRandomNumber(arrayForCount, 0, 100);
        Runner runner = new Runner(arrayForCount, 0, 1_000_000);
        ForkJoinPool pool = new ForkJoinPool(NUM_THREADS);
        pool.invoke(runner);
        System.out.println("Result = " + runner.join());

//        long count = 0;
//        for (int i = 0; i < arrayForCount.length; i++) {
//            count += arrayForCount[i];
//        }
//        System.out.println(count);
    }

    public static long[] initArrayRandomNumber(long[] array, int minBorder, int maxBorder){
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(minBorder, maxBorder + 1);
        }
        return array;
    }
}