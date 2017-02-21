FOP Tests README

I have included two types of automated tests - java and python. 

I used Eclipse IDE with Selenium to write the java tests.

I used PyCharm to write the python tests.

Both java and python tests were written as if the Free Overdraft Protection feature 
was part of a website and webservice named http://www.fop.com .

To keep things simple for the java tests, I assume only 1 webpage that asks for 
a Customer Name and then prompts the user with questions that cover each part of the user story.

To keep things simple for the python tests, I assume a simple web service that 
returns http 200 responses for success and a json string for failures.

I wrote automated test cases for many (but not all) documented test cases.

Here’s installation/configuration/example procedures for each type of tests (since there is no real building necessary):

Java Tests

To install the Eclipse IDE for Windows:
https://developer.atlassian.com/docs/getting-started/set-up-the-atlassian-plugin-sdk-and-build-a-project/set-up-the-eclipse-ide-for-windows

To configure Eclipse with Selenium WebDriver:
http://toolsqa.com/selenium-webdriver/configure-eclipse-with-selenium-webdriver/

For a quick and super basic example of how I set up selenium tests with a webdriver:
https://wunder.io/blog/creating-and-running-a-simple-selenium-webdriver-test/2011-09-15

Import Tim’s tests into Eclipse to view them:
(right-click your project and select Import), then select these 2 files to import

  DecisionTable_FOPtests.java
  FOPtests.java

Python Tests

To Install PyCharm on Windows:
http://www.jetbrains.com/pycharm/

Creating, configuring, and running Python tests in PyCharm: 
https://confluence.jetbrains.com/display/PYH/Creating+and+running+a+Python+unit+test

To view Tim’s python tests in PyCharm:
Drag and drop these 2 files to import:

  DecisionTable_FOPTests.java
  FOPTests.java
