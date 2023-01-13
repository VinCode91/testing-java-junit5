package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertions() {
        //given
        Person person = new Person(1l, "Jo", "SARR");

        //then
        assertAll("Tests Props Set",
                () -> assertEquals("Jo", person.getFirstName()),
                () -> assertEquals("SARR", person.getLastName()));
    }

    @Test
    void groupedAssertionsMsgs() {
        //given
        Person person = new Person(1l, "Jo", "SARR");

        //then
        assertAll("Tests Props Set",
                () -> assertEquals("Joe", person.getFirstName(), "first name failed"),
                () -> assertEquals("SAR", person.getLastName(), "Last name failed"));
        //All assertions are tested, even if the first fails
    }
}
