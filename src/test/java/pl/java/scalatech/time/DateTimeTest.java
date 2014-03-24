package pl.java.scalatech.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import org.fest.assertions.Assertions;
import org.junit.Test;

/**
 * @author Sławomir Borowiec
 *         Module name : java8features
 *         Creating time : 24 mar 2014 13:24:36
 */
public class DateTimeTest {

    private LocalDate getBirthDate() {
        return LocalDate.of(1979, Month.MAY, 3);
    }

    private LocalTime getBirthDateTime() {
        return LocalTime.of(23, 34);
    }
    
    private LocalDateTime getBirthDateAccuracy(){
        return LocalDateTime.of(1979, Month.MAY, 3, 23, 34);
    }
    

    private LocalDateTime getBirthDateAccuracyTwoWay(){
        return LocalDateTime.of(getBirthDate(),getBirthDateTime());
    }
    
    
    
    @Test
    public void shouldMyBirthDateCreate() {
        LocalDate myBirthDate = getBirthDate();
        Assertions.assertThat(myBirthDate.getDayOfMonth()).isEqualTo(3);
        Assertions.assertThat(myBirthDate.getMonth()).isEqualTo(Month.MAY);

    }

    @Test
    public void shouldMyBirthTimeCreate() {
        LocalTime myBirthDateTime = getBirthDateTime();
        Assertions.assertThat(myBirthDateTime.getHour()).isEqualTo(23);
        Assertions.assertThat(myBirthDateTime.getMinute()).isEqualTo(34);
    }
    @Test
    public void shouldMyBirthLocalDateTime() {
        LocalDateTime myBirthDateTime = getBirthDateAccuracy();
        
        Assertions.assertThat(myBirthDateTime.getDayOfMonth()).isEqualTo(3);
        Assertions.assertThat(myBirthDateTime.getMonth()).isEqualTo(Month.MAY);
        Assertions.assertThat(myBirthDateTime.getHour()).isEqualTo(23);
        Assertions.assertThat(myBirthDateTime.getMinute()).isEqualTo(34);
        Assertions.assertThat(myBirthDateTime).isEqualTo(getBirthDateAccuracyTwoWay());
    }
}
