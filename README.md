# Ticket-analyzer
## Small-scale service
This service will read the file.json and calculate:
- Minimum flight time between One city and Second city for each carrier;
- The difference between the average price and the median for a flight between One city and Second city.
  You can run the service from the Linux command line. The results will be presented in text form.
### Tech Stack
```
    Java 11
    JUnit        
    Log4j 1.2.17
    SLF4J Log4j 1.7.30
    Checkstyle 3.2
    Jacoco 0.8.8   
```
### Install
Install on your computer [JDK](https://jdk.java.net/java-se-ri/11-MR3), [Maven](https://maven.apache.org/), [Git](https://git-scm.com/).</br>
```
sudo apt update
java -version
```
Command 'java' not found, but can be installed with:
```
apt install openjdk-11-jre-headless  # version 11.0.15+10-0ubuntu0.20.04.1, or
apt install default-jre              # version 2:1.11-72
```
as default:
```
sudo apt install default-jre
sudo apt install openjdk-11-jdk
```
### Start
```
java -jar /home/user/ticketAnalyzer-1.0-SNAPSHOT.jar - for Linux
java -jar C:\Users\user\ticketAnalyzer-1.0-SNAPSHOT.jar - for Windows
```
### View
It is look like that 
```
2024-09-02 11:55:58,842  INFO com.saccharine.ticketer.util.TicketsWrapper:getTickets:18 - Total number of tickets: 12
2024-09-02 11:55:58,844  INFO com.saccharine.ticketer.repository.TicketFileReader:readTickets:25 - The list of tickets has length is 12
2024-09-02 11:55:58,867  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 16: 20: 22: 10
2024-09-02 11:55:58,869  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 17: 20: 23: 50
2024-09-02 11:55:58,869  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 12: 10: 18: 10
2024-09-02 11:55:58,871  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 17: 0: 23: 30
2024-09-02 11:55:58,871  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 12: 10: 20: 15
2024-09-02 11:55:58,871  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 9: 40: 19: 25
2024-09-02 11:55:58,871  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 17: 10: 23: 45
2024-09-02 11:55:58,871  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 6: 10: 15: 25
2024-09-02 11:55:58,871  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 16: 50: 23: 35
2024-09-02 11:55:58,871  INFO com.saccharine.ticketer.util.FlightTimeCalculator:calculateFlightTime:15 - The results are 6: 10: 16: 15
2024-09-02 11:55:58,871  INFO com.saccharine.ticketer.service.TicketProcessor:processTickets:34 - the minimum flight time:
2024-09-02 11:55:58,879  INFO com.saccharine.ticketer.service.TicketProcessor:processTickets:36 - Carrier: SU, The flight time: 360 minutes
2024-09-02 11:55:58,879  INFO com.saccharine.ticketer.service.TicketProcessor:processTickets:36 - Carrier: S7, The flight time: 390 minutes
2024-09-02 11:55:58,879  INFO com.saccharine.ticketer.service.TicketProcessor:processTickets:36 - Carrier: TK, The flight time: 350 minutes
2024-09-02 11:55:58,880  INFO com.saccharine.ticketer.service.TicketProcessor:processTickets:36 - Carrier: BA, The flight time: 485 minutes
2024-09-02 11:55:58,890  INFO com.saccharine.ticketer.util.MedianCalculator:calculateMedian:14 - The median of 10 prices
2024-09-02 11:55:58,895  INFO com.saccharine.ticketer.service.TicketProcessor:processTickets:40 - The difference between the average price and the median: 460.0
2024-09-02 11:55:58,895  INFO com.saccharine.ticketer.TicketAnalyzer:main:20 - All tickets processed successfully
```
### For other sites
you can use it :)
```
javac -cp .:jackson-databind-2.13.3.jar Main.java TicketFileReader.java Ticket.java FlightTimeCalculator.java MedianCalculator.java TicketProcessor.java TicketsWrapper.java
java -cp .:jackson-databind-2.13.3.jar Main

```