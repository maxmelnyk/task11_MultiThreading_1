package com.melnyk.task4;

import com.melnyk.task2.Fibonacci;
import java.util.concurrent.Callable;

public class CallableFibonacci implements Callable {

  private final int N;

  public CallableFibonacci(int N) {
    this.N = N;
  }

  @Override
  public Object call() {
    return new Fibonacci(N).getFibonacciNumbers().stream()
        .mapToInt(Integer::intValue).sum();
  }
}
