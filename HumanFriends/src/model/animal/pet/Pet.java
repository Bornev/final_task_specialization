package model.animal.pet;

import model.animal.Animal;
import model.animal.IdGenerator;

import java.time.LocalDate;

public abstract class Pet extends Animal {
    public Pet(IdGenerator idGenerator, String name, LocalDate birthDate) {
        super(idGenerator, name, birthDate);
    }

    public abstract void play();
}