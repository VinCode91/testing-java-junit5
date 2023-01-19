package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.ModelVetMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest implements ControllerTests {

    VetController vetController;
    VetService vetMapService;

    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        vetController = new VetController(vetMapService);
    }

    @DisplayName(value = "Test addition of new vets")
    @Test
    void listVets() {
        ModelVetMapImpl model = new ModelVetMapImpl();
        assertAll("Preliminary tests",
                () -> assertEquals("vets/index", vetController.listVets(model)),
                () -> assertEquals(1, model.getMapVets().size()),
                () -> assertEquals(0, model.getMapVets().get("vets").size()));

        vetMapService.save(new Vet(1l, "Jo", "SARR", new HashSet<>()));
        vetMapService.save(new Vet(2l, "Aloys", "SARR", new HashSet<>()));
        vetController.listVets(model);
        assertAll("Checking Model DisplayVet",
                () -> assertEquals(2, vetMapService.findAll().size(), "Vets absents de vetService"),
                () -> assertEquals(1, model.getMapVets().size(), "Nombre de vets incorrect"),
                () -> assertEquals(2, model.getMapVets().get("vets").size())
                //() -> assertEquals("Jo", model.getMapVets().get("vets").get(1).getFirstName(), "Prénom vet 1 incorrect"),
                //() -> assertEquals("Aloys", model.getMapVets().get("vets").get(0).getFirstName(), "Prénom vet 2 incorrect")
        );

    }
}
