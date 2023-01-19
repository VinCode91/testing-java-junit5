package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {
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

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "Framework", "Beginner", "Hello there !"})
    void testValueSource(String val){
        System.out.println(val);
        System.out.println("Check exec");
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType type) {
        System.out.println(type);
    }

    @DisplayName("CSV input test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource(value = {"Sénégal; Dakar; 12000000", "France; Paris; 66000000",
            "Japon; Tokyo; 340000000"}, delimiter = ';')
    void csvInputTest(String country, String capital, int population) {
        System.out.println(country + "\n \t-capitale : " + capital + "\n \t-population : " + population);
    }

    @DisplayName("CSV from file test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(delimiter = ';', resources = "/input.csv", numLinesToSkip = 1)
    void csvFromFileTest(String country, String capital, int population) {
        System.out.println(country + "\n \t-capitale : " + capital + "\n \t-population : " + population);
    }
    @DisplayName("Method Provider test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void fromMethodTest(String country, String capital, int population) {
        System.out.println(country + "\n \t-capitale : " + capital + "\n \t-population : " + population);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(
                Arguments.of("Sénégal", "Dakar", 12000000),
                Arguments.of("Burkina Faso", "Ouagadougou", 25000000),
                Arguments.of("Bénin", "Cotonou", 6000000)
        );
    }

    @DisplayName("Custom Provider test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void fromCustomProviderTest(String country, String capital, int population) {
        System.out.println(country + "\n \t-capitale : " + capital + "\n \t-population : " + population);
    }
}
