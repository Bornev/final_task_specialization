package model.animal.pack_animal.donkey;

import model.animal.Animal;
import model.animal.IdGenerator;
import model.animal.pack_animal.PackAnimal;

import java.time.LocalDate;

public class Donkey extends PackAnimal {
    private int stamina;

    public Donkey(IdGenerator idGenerator, String name, LocalDate birthDate, int stamina) {
        super(idGenerator, name, birthDate);
        this.stamina = stamina;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public void makeSound() {
        System.out.println("Иа!");
    }

    @Override
    public void carryLoad() {
        System.out.println("Ослик тянет телегу.");
    }

    @Override
    public Class<? extends Animal> getType() {
        return Donkey.class;
    }

    @Override
    public String toString() {
        return String.format("%s\nВыносливость: %d\n", super.toString(), stamina);
    }
}