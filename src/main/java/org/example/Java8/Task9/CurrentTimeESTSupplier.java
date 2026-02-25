package org.example.Java8.Task9;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class CurrentTimeESTSupplier {
    public static void main(String[] args) {
        Supplier<String> currentTimeEST = () -> {
            ZonedDateTime estTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
            return estTime.format(DateTimeFormatter.ofPattern("HH:mm:ss z"));
        };

        // Example usage
        System.out.println("Current Time in EST: " + currentTimeEST.get());
    }
}
