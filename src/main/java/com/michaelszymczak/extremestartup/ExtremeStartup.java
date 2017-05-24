package com.michaelszymczak.extremestartup;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.*;

public class ExtremeStartup {

  private static final Logger log = LoggerFactory.getLogger(ExtremeStartup.class);

  private final String teamName;

  public ExtremeStartup(String teamName) {
    this.teamName = teamName;
  }

  public String answer(String question) {
    String response = response(question);
    log.info("Response: " + response);
    return response;
  }

  private String response(String question) {
    log.info("Question: " + question);
    if (question == null)
      return teamName;
    //  curl http://localhost:1337/\?q=what%20is%20the%20sum%20of%204%20and%205
    return Stream.of(new SumAnswer(), new MultiplyAnswer(), new GreaterAnswer(),
        new PrimeAnswer(), new SquareAndQubeAnswer(), new MinusAnswer(), new PowerAnswer(),
            new MultiplyAndSumAnswer())
            .map(q -> q.answer(question))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst()
            .orElse(teamName);
  }

  public static void main(String[] args) {
    final ExtremeStartup server = new ExtremeStartup("charliemichael");
    port(1337);
    get("/", (Request request, Response response) -> server.answer(request.queryParams("q")));
  }

}
