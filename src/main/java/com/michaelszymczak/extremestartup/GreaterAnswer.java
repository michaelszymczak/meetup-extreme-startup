package com.michaelszymczak.extremestartup;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreaterAnswer implements Answer {

  @Override
  public Optional<String> answer(String question)
  {
    Matcher graterMatcher = Pattern.compile(".*which of the following numbers is the largest: (\\d+), (\\d+)").matcher(question);
    if (graterMatcher.matches()) {
      return Optional.of(String.valueOf(Math.max(Integer.parseInt(graterMatcher.group(1)), Integer.parseInt(graterMatcher.group(2)))));
    }


    return Optional.empty();
  }
}
