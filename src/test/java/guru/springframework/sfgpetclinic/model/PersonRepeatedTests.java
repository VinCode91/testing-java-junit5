package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelRepeatedTests;
import org.junit.jupiter.api.*;

public class PersonRepeatedTests implements ModelRepeatedTests {
    @RepeatedTest(value = 8, name = "{displayName} : {currentRepetition} / {totalRepetitions}")
    @DisplayName("Repeated test")
    void myRepeatedTest() {
    }

    @RepeatedTest(value = 5, name = "{displayName} repetition")
    @DisplayName("Dependency Injection Test")
    void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo, TestReporter reporter){
        System.out.println(testInfo.getDisplayName() + " " + repetitionInfo.getCurrentRepetition());
        //reporter.publishEntry("Get down !");
    }

    @RepeatedTest(value = 9, name = "Mugiwara crew has now {currentRepetition} members")
    @DisplayName("Assignment DI : recruit pirate crew")
    void recruitPirateCrewTest(){
    }
}
