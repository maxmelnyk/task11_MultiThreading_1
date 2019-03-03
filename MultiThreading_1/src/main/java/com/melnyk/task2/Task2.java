package com.melnyk.task2;

public class Task2 {

  private Fibonacci fibonacci;

  public Task2(int N) {
    fibonacci = new Fibonacci(N);
  }

  public void startTask() {
    for (int i = 1; i <= 3; i++) {
      int paused = 500*i;
      new Thread(() -> {
        System.out.println(Thread.currentThread().getName());
        fibonacci.showFibonacciNumbers(paused);
      }).start();
    }
  }
}
