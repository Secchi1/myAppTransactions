package app.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PingControllerTest {
  @Test
  public void whenPingThenPong() {
    PingController ping = new PingController();
    assertEquals("pong", ping.handlePing());
  }
}
