package com.michaelszymczak.extremestartup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    log.info("Question: " + question);
    if (question == null)
      return teamName;
    //  curl http://localhost:1337/\?q=what%20is%20the%20sum%20of%204%20and%205
    Matcher sumMatcher = Pattern.compile(".*what is the sum of (\\d+) and (\\d+)").matcher(question);
    if (sumMatcher.matches()) {
      return String.valueOf(Integer.parseInt(sumMatcher.group(1)) + Integer.parseInt(sumMatcher.group(2)));
    }
    return teamName;
  }

  public static void main(String[] args) {
    final ExtremeStartup server = new ExtremeStartup("team name");
    port(1337);
    get("/", (Request request, Response response) -> server.answer(request.queryParams("q")));
  }

}
