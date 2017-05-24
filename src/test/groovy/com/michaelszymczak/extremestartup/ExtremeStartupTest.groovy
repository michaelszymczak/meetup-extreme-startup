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
    server.answer("what is the sum of 4 and 12") == "16"
  }
}
