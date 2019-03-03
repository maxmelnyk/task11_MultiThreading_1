package com.melnyk.task6;

public class SynchronizedOnDifferentObject {

  private final Object object1 = new Object();
  private final Object object2 = new Object();
  private final Object object3 = new Object();

  public void method1() {
    synchronized (object1) {
      System.out.println(Thread.currentThread().getName() + " method1 is running");
      System.out.println(Thread.currentThread().getName() + " method1 finished");
    }
  }

  public void method2() {
    synchronized (object2) {
      System.out.println(Thread.currentThread().getName() + " method2 is running");
      System.out.println(Thread.currentThread().getName() + " method2 finished");
    }
  }

  public void method3() {
    synchronized (object3) {
      System.out.println(Thread.currentThread().getName() + " method3 is running");
      System.out.println(Thread.currentThread().getName() + " method3 finished");
    }
  }
}
