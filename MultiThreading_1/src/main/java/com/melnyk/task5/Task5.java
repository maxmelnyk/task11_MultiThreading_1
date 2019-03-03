package com.melnyk.task5;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task5 {

  public void startTask5() {

    Random random = new Random();
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
    System.out.println("Enter number of tasks:");
    Scanner scanner = new Scanner(System.in);
    int numberOfTasks = scanner.nextInt();
    for (int i = 0; i < numberOfTasks; i++) {
      final int delay = random.nextInt(10) + 1;
      executor.schedule(
          () -> System.out.println(Thread.currentThread().getName() + " sleep "
              + delay + " seconds"), delay, TimeUnit.SECONDS);
    }
    executor.shutdown();
  }
}
