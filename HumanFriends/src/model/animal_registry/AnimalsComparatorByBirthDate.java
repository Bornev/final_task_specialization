package model.animal_registry;

import model.animal.Animal;

import java.util.Comparator;

public class AnimalsComparatorByBirthDate implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}