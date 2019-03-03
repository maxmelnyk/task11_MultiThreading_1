package com.melnyk.task7;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Task7 {

  private PipedWriter pipedWriter = new PipedWriter();
  private PipedReader pipedReader = new PipedReader();

  public void startTask7() throws IOException {
    pipedWriter.connect(pipedReader);

    Thread writeThread = new Thread(this::writeSomething);
    Thread readThread = new Thread(this::readSomething);

    writeThread.start();
    readThread.start();

    try {
      writeThread.join();
      readThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void writeSomething() {
    Scanner myLine = new Scanner(System.in);
    String text;
    for (; ; ) {
      System.out.print("Write: ");
      text = myLine.nextLine();
      try {
        pipedWriter.write(text);
        Thread.sleep(1000);
      } catch (IOException | InterruptedException e) {
        e.printStackTrace();
      }
      if (text.equals("exit")) {
        System.exit(0);
      }
    }
  }

  private void readSomething() {
    int position;
    char[] buffer = new char[1000];
    char[] newBuffer;
    try {
      position = pipedReader.read(buffer);
      while (position != -1) {
        newBuffer = Arrays.copyOf(buffer, position);
        System.out.println("Read: " + new String(newBuffer));
        position = pipedReader.read(buffer);
      }
      pipedReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
