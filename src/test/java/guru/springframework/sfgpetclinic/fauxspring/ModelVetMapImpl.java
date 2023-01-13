package guru.springframework.sfgpetclinic.fauxspring;

import guru.springframework.sfgpetclinic.model.Vet;

import java.util.*;

public class ModelVetMapImpl implements Model {
    private Map<String, List<Vet>> mapVets = new HashMap<>();

    public Map<String, List<Vet>> getMapVets() {
        return mapVets;
    }

    @Override
    public void addAttribute(String key, Object o) {
        if (o instanceof Collection) {
            if (!mapVets.containsKey(key))
                mapVets.put(key, new ArrayList<>());
            mapVets.get(key).addAll((Collection<? extends Vet>) o);
        }
    }

    @Override
    public void addAttribute(Object o) {

    }
}
