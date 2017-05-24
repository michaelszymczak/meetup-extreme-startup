package com.michaelszymczak.extremestartup;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PowerAnswer implements Answer {

  @Override
  public Optional<String> answer(String question)
  {
    Matcher sumMatcher = Pattern.compile(".*what is (\\d+) to the power of (\\d+)").matcher(question);
    if (sumMatcher.matches()) {
      return Optional.of(String.valueOf(
              (int) power(sumMatcher)));
    }

    return Optional.empty();
  }

  private double power(Matcher sumMatcher) {
    return Math.pow(Integer.parseInt(sumMatcher.group(1)), Integer.parseInt(sumMatcher.group(2)));
  }
}
