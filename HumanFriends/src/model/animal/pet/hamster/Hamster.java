package model.animal.pet.hamster;

import model.animal.Animal;
import model.animal.IdGenerator;
import model.animal.pet.Pet;

import java.time.LocalDate;

public class Hamster extends Pet {
    private int timeOfFidindAnExit;

    public Hamster(IdGenerator idGenerator, String name, LocalDate birthDate, int timeOfFidindAnExit) {
        super(idGenerator, name, birthDate);
        this.timeOfFidindAnExit = timeOfFidindAnExit;
    }

    public int getTimeOfFidindAnExit() {
        return timeOfFidindAnExit;
    }

    public void setTimeOfFidindAnExit(int timeOfFidindAnExit) {
        this.timeOfFidindAnExit = timeOfFidindAnExit;
    }

    @Override
    public void makeSound() {
        System.out.println("Пи-пи!");
    }

    @Override
    public void play() {
        System.out.println("Хомяк бегает по лабиринту.");
    }

    @Override
    public Class<? extends Animal> getType() {
        return Hamster.class;
    }

    @Override
    public String toString() {
        return String.format("%s\nВремя нахождения выхода из лабиринта: %d\n", super.toString(), timeOfFidindAnExit);
    }
}