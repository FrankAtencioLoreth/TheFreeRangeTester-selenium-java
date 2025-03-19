# TheFreeRangeTester-selenium-java

This repository contains a Selenium-based automation testing framework developed in Java. It leverages tools like Cucumber for Behavior Driven Development (BDD) and WebDriverManager for managing browser drivers.

## Features

- **Selenium Integration**: Facilitates browser automation for web application testing.
- **Cucumber Support**: Enables writing test cases in a BDD style using Gherkin syntax.
- **WebDriverManager**: Simplifies browser driver management by automating driver downloads and setup.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed.
- **Gradle**: This project uses Gradle for build automation. If you don't have Gradle installed, you can use the provided Gradle wrapper scripts (`gradlew` for Unix-based systems and `gradlew.bat` for Windows).

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/FrankAtencioLoreth/TheFreeRangeTester-selenium-java.git
2. Navigate to the Project Directory:
    ```bash 
    cd TheFreeRangeTester-selenium-java
3. Build the Project:
    ```bash
    ./gradlew clean build
## Running Tests
To execute the tests:

- Using the Gradle Wrapper
    ```bash
    ./gradlew clean test
- To execute an especific test using tags:
    ```bash
    ./gradlew clean test -Dcucumber.filter.tags="@tagname"

## Reports
 - See Cucumber reports oficial page and create an account and follow instructions: https://reports.cucumber.io/

## Dependencies
The project relies on several key dependencies:

- Selenium Java: Provides the Selenium API for browser automation.
- WebDriverManager: Manages browser drivers automatically.
- TestNG: A testing framework inspired by JUnit but introducing some new functionalities.
- Cucumber Java: Supports BDD by allowing the writing of tests in Gherkin syntax.
- Cucumber JUnit: Integrates Cucumber with JUnit for test execution.

- These dependencies are defined in the build.gradle file:
    ```bash
    
    dependencies {
        testImplementation 'org.junit.jupiter:junit-jupiter:5.9.1'
        implementation 'org.seleniumhq.selenium:selenium-java:4.18.1'
        implementation 'io.github.bonigarcia:webdrivermanager:5.6.4'
        testImplementation 'org.testng:testng:7.8.0'
        implementation 'io.cucumber:cucumber-java:7.14.1'
        testImplementation 'io.cucumber:cucumber-junit:7.14.1'
    }
For more details, refer to the build.gradle file.
