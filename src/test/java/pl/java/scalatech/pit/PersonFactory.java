package pl.java.scalatech.pit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonFactory {
    public Person createPerson() {
        Person person = new Person();
        person.setFirstName("First");
        person.setLastName("Last");
        person.setAge(10);
        if (person.getAge() > 18) {
            person.setDesc("adult");
            log.info("adult");
        } else {
            log.info("immature");
            person.setDesc("immuture");
        }
        return person;
    }

}
