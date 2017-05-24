package com.michaelszymczak.extremestartup;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiplyAndSumAnswer implements Answer {

  @Override
  public Optional<String> answer(String question)
  {
    Matcher multiplyMatcher = Pattern.compile(".*what is (\\d+) multiplied by (\\d+) plus (\\d+)").matcher(question);
    if (multiplyMatcher.matches()) {
      return Optional.of(String.valueOf(Integer.parseInt(multiplyMatcher.group(1))
              * Integer.parseInt(multiplyMatcher.group(2))
              + Integer.parseInt(multiplyMatcher.group(3))
      ));
    }

    return Optional.empty();
  }
}
