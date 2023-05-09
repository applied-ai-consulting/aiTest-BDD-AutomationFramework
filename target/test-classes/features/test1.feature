Feature: Test chatgpt

  @Test
  Scenario: verify Text
    When Search things
    Then validate TEXT

  @Test
  Scenario: click on Text
    When Search things
    When click on Text
    Then validate current page Title

  @Test
  Scenario: click on Menu button
    When Search things
    When click on Text
    Then click on OpenAI and validate it





