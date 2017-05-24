package com.michaelszymczak.extremestartup;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinusAnswer implements Answer {

  @Override
  public Optional<String> answer(String question)
  {
    Matcher sumMatcher = Pattern.compile(".*what is (\\d+) minus (\\d+)").matcher(question);
    if (sumMatcher.matches()) {
      return Optional.of(String.valueOf(Integer.parseInt(sumMatcher.group(1)) - Integer.parseInt(sumMatcher.group(2))));
    }

    return Optional.empty();
  }
}
