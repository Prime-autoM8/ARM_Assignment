Feature: Send Mail to self
  This feature covers the process of sending and receiving emails.

  Scenario: Validate that user can send email to originating email
    Given User is on "https://www.gmail.com"
    When User Login using below credentials
      | username | seleniumautotest7@gmail.com|
      | password | Password1%                  |
    Then system grants user access successfully
    When User clicks on create new mail
    Then System displays new mail modal
    When User provides email details as stated below
      | recipient | seleniumautotest7@gmail.com   |
      | subject   | hi                            |
      | body      | Automation test               |
    And User clicks the send button
    Then user receives email successfully

#  • Login to your email
#  • Compose a new email (Subject: hi, Body: Automation test)
#  • Send email to yourself
#  • Assert that you received the email