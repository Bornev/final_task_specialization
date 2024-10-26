package model.animal_registry;

import model.animal.Animal;

import java.util.Comparator;

public class AnimalsComparatorById implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}