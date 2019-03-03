package com.melnyk.task4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Task4 {

  private final int N;

  public Task4(int N) {
    this.N = N;
  }

  public void startTask4() {
    FutureTask futureTask1 = new FutureTask(new CallableFibonacci(N));
    FutureTask futureTask2 = new FutureTask(new CallableFibonacci(N));
    FutureTask futureTask3 = new FutureTask(new CallableFibonacci(N));
    FutureTask futureTask4 = new FutureTask(new CallableFibonacci(N));

    new Thread(futureTask1).start();
    new Thread(futureTask2).start();
    new Thread(futureTask3).start();
    new Thread(futureTask4).start();

    try {
      System.out.println("1.Sum of " + N + " Fibonacci numbers = " + futureTask1.get());
      System.out.println("2.Sum of " + N + " Fibonacci numbers = " + futureTask2.get());
      System.out.println("3.Sum of " + N + " Fibonacci numbers = " + futureTask3.get());
      System.out.println("4.Sum of " + N + " Fibonacci numbers = " + futureTask4.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}
