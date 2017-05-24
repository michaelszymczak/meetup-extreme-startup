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
//    server.answer("which of the following numbers is the largest: 179, 48, 999, 10") == "999"
  }

}
