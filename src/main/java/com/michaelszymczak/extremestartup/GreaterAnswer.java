package com.michaelszymczak.extremestartup;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GreaterAnswer implements Answer {

  @Override
  public Optional<String> answer(String question)
  {
    Matcher graterMatcher = Pattern.compile(".*which of the following numbers is the largest: (.+)").matcher(question);
    if (graterMatcher.matches()) {
      String group = graterMatcher.group(1);
      String[] nums = group.split(", ");
      return Optional.of(String.valueOf(Arrays.stream(nums).mapToInt(Integer::valueOf).max().orElse(0)));
//      Stream
//      return Optional.of(String.valueOf(Math.max(Integer.parseInt(graterMatcher.group(1)), Integer.parseInt(graterMatcher.group(2)))));
    }


    return Optional.empty();
  }
}
