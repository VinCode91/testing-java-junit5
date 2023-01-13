package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {
    @Test
    void dependentAssertions() {
        Owner owner = new Owner(1l, "Jo", "SARR");
        owner.setCity("Thiès");
        owner.setTelephone("0120120123");

        assertAll("Properties Test",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Jo", owner.getFirstName(), "Le prénom ne correspond pas"),
                        () -> assertEquals("SARR", owner.getLastName())),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Thiès", owner.getCity()),
                        () -> assertEquals("0120120123", owner.getTelephone())));

        assertThat(owner.getCity(), is("Thiès"));
    }
}
