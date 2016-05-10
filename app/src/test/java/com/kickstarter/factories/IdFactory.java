package com.kickstarter.factories;

public final class IdFactory {
  private IdFactory() {}

  static int id = 1;

  public static synchronized int id() {
    return id++;
  }
}
