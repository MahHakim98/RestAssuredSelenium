# Amazon Automation Project

## Overview
This Selenium-based automation project automates product selection and checkout on Amazon Egypt.

## Prerequisites
- Java (JDK 11 or later)
- IntelliJ IDEA / Eclipse
- Maven
- Selenium WebDriver
- Git installed on your system

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone https://github.com/MahHakim98/RestAssuredSelenium
   ```
2. Open the project in IntelliJ.
3. Install dependencies using Maven:
   ```sh
   mvn clean install
   ```
4. Run the test cases from `testcases` package.

## Running the Automation Tests
- Execute the test cases using:
   ```sh
   mvn test
   ```
- Reports will be available in `target/surefire-reports`.

## Notes
- Ensure **WebDriver** is correctly configured for Chrome or Firefox.
- Modify **config.properties** to set browser, URL, and credentials.

