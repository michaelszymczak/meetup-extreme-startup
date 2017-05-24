package com.michaelszymczak.extremestartup;

import com.google.common.math.IntMath;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SquareAndQubeAnswer implements Answer {

  @Override
  public Optional<String> answer(String question)
  {
    Matcher graterMatcher = Pattern.compile(".*which of the following numbers is both a square and a cube: (.+)").matcher(question);
    if (graterMatcher.matches()) {
      String group = graterMatcher.group(1);
      String[] nums = group.split(", ");

      return Optional.of(String.valueOf(Arrays.stream(nums).mapToInt(Integer::valueOf)
              .filter(num -> {
                double dnum = num;
                double sqrt = Math.sqrt(dnum);
                double cbrt = Math.cbrt(dnum);
                return Math.floor(sqrt) == sqrt && Math.floor(cbrt) == cbrt;
              })
              .mapToObj(val -> String.valueOf(val))
              .collect(Collectors.joining(", "))));
    }


    return Optional.empty();
  }
}
