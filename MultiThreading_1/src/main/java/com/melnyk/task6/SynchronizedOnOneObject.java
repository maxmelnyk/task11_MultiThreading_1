package com.melnyk.task6;

public class SynchronizedOnOneObject {

  private final Object object = new Object();

  public void method1() {
    synchronized (object) {
      System.out.println(Thread.currentThread().getName() + " method1 is running");
      System.out.println(Thread.currentThread().getName() + " method1 finished");
    }
  }

  public void method2() {
    synchronized (object) {
      System.out.println(Thread.currentThread().getName() + " method2 is running");
      System.out.println(Thread.currentThread().getName() + " method2 finished");
    }
  }

  public void method3() {
    synchronized (object) {
      System.out.println(Thread.currentThread().getName() + " method3 is running");
      System.out.println(Thread.currentThread().getName() + " method3 finished");
    }
  }
}
