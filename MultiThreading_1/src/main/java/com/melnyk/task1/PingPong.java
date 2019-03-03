package com.melnyk.task1;

import java.util.Random;

public class PingPong {

  private final Object ball = new Object();

  private boolean hitTheBall = true;

  private Random random = new Random();

  public void startGame() {
    Thread player1 = new Thread(() -> {
      Thread.currentThread().setName("Player1");
      step();
    });

    Thread player2 = new Thread(() -> {
      Thread.currentThread().setName("Player2");
      step();
    });

    player1.start();
    player2.start();
  }

  private void step() {
    while (hitTheBall) {
      synchronized (ball) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        hitTheBall = random.nextBoolean() || random.nextBoolean();
        if (hitTheBall) {
          System.out.println(Thread.currentThread().getName() + " hit the ball");
          ball.notify();
          try {
            ball.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        } else {
          System.out.println(Thread.currentThread().getName() + " doesn't hit the ball");
          System.exit(0);
        }
      }
    }
  }
}