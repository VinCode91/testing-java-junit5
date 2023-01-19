package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTests {

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
                () -> assertEquals("Jo", person.getFirstName(), "first name failed"),
                () -> assertEquals("SARR", person.getLastName(), "Last name failed"));
        //All assertions are tested, even if the first fails
    }
}
