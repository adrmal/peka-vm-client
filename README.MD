## PEKA VM Client

PEKA VM Client is a Java library, that allows you to easily access data from REST API provided by Urban Transport Authority in Poznań (Zarząd Transportu Miejskiego w Poznaniu) for PEKA Virtual Monitor. 

The library includes:
- stop points,
- bus and tram lines,
- real departure times based on current position of buses and trams,
- messages on current traffic incidents, etc.

#### REST API documentation

REST API consumed by this library doesn't have any official documentation, but there is unofficial one, which is available [here](https://github.com/xavery/peka-vm-api).

### Download

```xml
<dependency>
   <groupId>com.github.adrmal</groupId>
   <artifactId>peka-vm-client</artifactId>
   <version>1.0.0</version>
</dependency>
```

### Example usage

```java
List<StopPoint> stopPoints = Peka.getStopPoints("Most");

List<Bollard> bollards = Peka.getBollardsByStreet("Naramowicka");

List<DepartureTime> departureTimes = Peka.getTimesByBollard("GABA01");
```

### Very short documentation

The main class of the library is ```Peka```, which has following static methods:

```java
List<StopPoint> getStopPoints(String stopPointPattern)
```

```java
List<Bollard> getBollardsByStopPoint(String stopPointName)
```

```java
List<Bollard> getBollardsByStreet(String streetName)
```

```java
List<DirectionWithBollards> getDirectionsWithBollardsByLine(String lineNumber)
```

```java
List<Line> getLines(String linePattern)
```

```java
List<Street> getStreets(String streetPattern)
```

```java
List<DepartureTime> getTimesByBollard(String bollardTag)
```

```java
List<DepartureTime> getTimesByStopPoint(String stopPointName)
```

```java
long getServerTime()
```

```java
List<Message> getMessagesForBollard(String bollardTag)
```
