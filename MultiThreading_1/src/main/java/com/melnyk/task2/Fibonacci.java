package com.melnyk.task2;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

  private int size;

  public Fibonacci(final int N) {
    size = N;
  }

  public List<Integer> getFibonacciNumbers() {
    List<Integer> fibonacciNumbers = new ArrayList<>();
    int previous = 0;
    int current = 1;
    int next;
    for (int i = 0; i < size; i++) {
      fibonacciNumbers.add(current);
      next = previous + current;
      previous = current;
      current = next;
    }
    return fibonacciNumbers;
  }

  public void showFibonacciNumbers(int paused) {
    getFibonacciNumbers().forEach(x -> {
      try {
        Thread.sleep(paused);
        System.out.println(Thread.currentThread().getName() + ": " + x + " ");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }
}
