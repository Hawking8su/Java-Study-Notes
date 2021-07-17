# Java Basic Tricks



## How to time java execution speed

Date: 2021-07-18

Reference: https://stackoverflow.com/questions/2572868/how-to-time-java-program-execution-speed

```java
final long startTime = System.currentTimeMillis();
for (int i = 0; i < length; i++) {
  // Do something
}
final long endTime = System.currentTimeMillis();

System.out.println("Total execution time: " + (endTime - startTime));
```

