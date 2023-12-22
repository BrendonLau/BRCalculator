# Bitrate Calculator

The Bitrate Calculator is a Java application that calculates the Rx (receive) and Tx (transmit) bitrates for network interfaces based on input data provided in JSON format. 
It is designed to work with devices having one or more network interfaces, and it uses the BigDecimal class for precision in bitrate calculations.

## Features

- Parses JSON data representing network devices with multiple network interfaces.
- Calculates Rx and Tx bitrates using the provided polling rate.
- Utilizes BigDecimal for accurate and precise bitrate calculations.


## Project Structure

The project is organized into the following directories:

- `calculator`: Contains the BitrateCalculator class responsible for calculating Rx and Tx bitrates.
- `common`: Includes classes for representing bitrates, devices, and network interfaces.
- `parser`: Contains the Parsable interface to Parse different structure and devices, AristaParser class for parsing JSON data into Device objects.
- `test`: Includes integration tests for the BitrateCalculator and parser.

## Usage

1. Modify the JSON input data in the `BitrateCalculatorIntegrationTest.java` or `Main.java` class to simulate different devices and network interfaces.

The project includes integration tests that simulate the calculation of Rx and Tx bitrates for network interfaces with various input data.
