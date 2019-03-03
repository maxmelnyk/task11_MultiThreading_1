package com.melnyk.task3;

import com.melnyk.task2.Fibonacci;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciExecutors {

  private Fibonacci task2;

  public FibonacciExecutors(int N) {
    task2 = new Fibonacci(N);
  }

  public void startExecutors() {
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    singleThreadExecutor.execute(() -> {
      System.out.println(Thread.currentThread().getName());
      task2.showFibonacciNumbers(100);
    });
    singleThreadExecutor.shutdown();

    ExecutorService fixedThreadPool= Executors.newFixedThreadPool(5);
    fixedThreadPool.submit(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName());
        task2.showFibonacciNumbers(1000);
      }
    });
    fixedThreadPool.shutdown();

    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    cachedThreadPool.submit(() -> {
      System.out.println(Thread.currentThread().getName());
      task2.showFibonacciNumbers(300);
    });
    cachedThreadPool.shutdown();
  }

}
