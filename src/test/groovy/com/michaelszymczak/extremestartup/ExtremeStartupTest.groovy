package com.michaelszymczak.extremestartup

import spock.lang.Specification

class ExtremeStartupTest extends Specification {

  private final ExtremeStartup server = new ExtremeStartup("spark team");

  def "should_accept_missing_input"() {
    expect:
    server.answer(null) == "spark team"
  }

  def "should_answer_name"() {
    expect:
    server.answer("what is your name") == "spark team"
  }

  def "should_add_numbers"() {
    expect:
    server.answer("what is 5 plus 12") == "17"
  }

  def "should_multiply_numbers"() {
    expect:
    server.answer("what is 3 multiplied by 2") == "6"
  }

  def "should_biggest_numbers"() {
    expect:
    server.answer("which of the following numbers is the largest: 179, 48") == "179"
    server.answer("which of the following numbers is the largest: 179, 48, 999, 10") == "999"
  }

  def "should_primes_numbers"() {
    expect:
    server.answer("which of the following numbers are primes: 178, 11, 999, 10") == "11"
    server.answer("which of the following numbers are primes: 7, 11, 999, 10") == "7, 11"
  }
  def "square_and_qube"() {
    expect:
    server.answer("which of the following numbers is both a square and a cube: 1, 64, 2") == "1, 64"
    server.answer("which of the following numbers is both a square and a cube: 4") == ""
  }

  def "minus_numbers"() {
    expect:
    server.answer("what is 10 minus 9") == "1"
  }
  def "power"() {
    expect:
    server.answer("what is 2 to the power of 3") == "8"
  }


  def "multiply and sum"() {
    expect:
    server.answer("what is 2 multiplied by 3 plus 4") == "10"
  }
}
