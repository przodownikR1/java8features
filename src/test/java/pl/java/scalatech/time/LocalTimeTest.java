package pl.java.scalatech.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;

public class LocalTimeTest {
    @Test
    public void shouldTimeWork() {
        ZoneId london = ZoneId.of("Europe/London");
        LocalDate july4 = LocalDate.of(2016, Month.MARCH, 4);
        LocalTime early = LocalTime.parse("08:30");
        
        ZonedDateTime flightDeparture = ZonedDateTime.of(july4, early, london);
        System.out.println("flightDeparture :  " + flightDeparture);
        
        LocalTime from = LocalTime.from(flightDeparture);
        System.out.println("localdate : " + from);
        ZonedDateTime touchDown = ZonedDateTime.of(july4, LocalTime.of(11, 30), ZoneId.of("Europe/Stockholm"));
        
        Duration flightLength = Duration.between(flightDeparture, touchDown);
        
        System.out.println("flightLength   : " +flightLength);
        
        
        ZonedDateTime now = ZonedDateTime.now();
        Duration timeHere = Duration.between(touchDown, now);
        System.out.println("timeHere :  "+ timeHere.toDays());
    }
}
