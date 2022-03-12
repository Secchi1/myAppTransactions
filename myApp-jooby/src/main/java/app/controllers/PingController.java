package app.controllers;

import io.jooby.annotations.GET;
import io.jooby.annotations.Path;

@Path("/ping")
public class PingController {

  @GET
  public String handlePing() {
    return "pong!";
  }
}
