package com.melnyk.task6;

public class Task6 {


  public void startWithOneObject() throws InterruptedException {
    System.out.println("      ---Synchronized on one Object---");
    SynchronizedOnOneObject oneObject = new SynchronizedOnOneObject();
    startAndJoinThread(new Thread(oneObject::method1),
        new Thread(oneObject::method2),
        new Thread(oneObject::method3));
  }

  public void startWithDifferentObjects() throws InterruptedException {
    System.out.println("      ---Synchronized on different Object---");
    SynchronizedOnDifferentObject differentObjects = new SynchronizedOnDifferentObject();
    startAndJoinThread(new Thread(differentObjects::method1),
        new Thread(differentObjects::method2),
        new Thread(differentObjects::method3));
  }

  private void startAndJoinThread(Thread thread0, Thread thread1, Thread thread2)
      throws InterruptedException {
    thread0.start();
    thread1.start();
    thread2.start();

    thread0.join();
    thread1.join();
    thread2.join();
  }
}
