package model.animal.pack_animal;

import model.animal.Animal;
import model.animal.IdGenerator;

import java.time.LocalDate;

public abstract class PackAnimal extends Animal {
    public PackAnimal(IdGenerator idGenerator, String name, LocalDate birthDate) {
        super(idGenerator, name, birthDate);
    }

    public abstract void carryLoad();
}