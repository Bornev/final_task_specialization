package model.animal.pet.dog;

import model.animal.Animal;
import model.animal.IdGenerator;
import model.animal.pet.Pet;

import java.time.LocalDate;

public class Dog extends Pet {
    private String breed;

    public Dog(IdGenerator idGenerator, String name, LocalDate birthDate, String breed) {
        super(idGenerator, name, birthDate);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }

    @Override
    public void play() {
        System.out.println("Собака играет в апорт.");
    }

    @Override
    public Class<? extends Animal> getType() {
        return Dog.class;
    }

    @Override
    public String toString() {
        return String.format("%s\nПорода: %s\n", super.toString(), breed);
    }
}