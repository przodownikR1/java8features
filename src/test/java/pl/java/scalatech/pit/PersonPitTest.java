package pl.java.scalatech.pit;

import org.junit.Assert;
import org.junit.Test;

public class PersonPitTest {
    @Test
    public void test() {
        Person person = new PersonFactory().createPerson();
        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        Assert.assertEquals("First", firstName);

    }

}
