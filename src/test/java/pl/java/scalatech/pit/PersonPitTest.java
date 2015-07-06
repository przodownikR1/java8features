package pl.java.scalatech.pit;

import org.fest.assertions.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class PersonPitTest {
    @Test
    public void test() {
        Person person = new PersonFactory().createPerson();
        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        Assert.assertEquals("First", firstName);
        Assertions.assertThat(person.getDesc()).isEqualTo("immuture");

    }
}
