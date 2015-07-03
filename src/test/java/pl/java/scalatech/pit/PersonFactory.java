package pl.java.scalatech.pit;

public class PersonFactory {
    public Person createPerson() {
        Person person = new Person();
        person.setFirstName("First");
        person.setLastName("Last");
        return person;
    }
}
