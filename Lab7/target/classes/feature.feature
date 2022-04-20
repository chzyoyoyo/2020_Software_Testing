Feature: Input double
  Input two Double and return their Quotient

  Scenario: 8.1 divide by 0.9 equal 9
    Given two double
    When I ask their quotient
    Then I should be told 9


  Scenario: 8.1 divide by 0 exception
    Given two double inputB = zero
    When I ask their quotient
    Then throw exception
