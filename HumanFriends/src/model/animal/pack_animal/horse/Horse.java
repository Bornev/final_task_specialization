package model.animal.pack_animal.horse;

import model.animal.Animal;
import model.animal.IdGenerator;
import model.animal.pack_animal.PackAnimal;

import java.time.LocalDate;

public class Horse extends PackAnimal {
    private int weight;

    public Horse(IdGenerator idGenerator, String name, LocalDate birthDate, int weight) {
        super(idGenerator, name, birthDate);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void makeSound() {
        System.out.println("Иго-го!");
    }

    @Override
    public void carryLoad() {
        System.out.println("Лошадь несет груз.");
    }

    @Override
    public Class<? extends Animal> getType() {
        return Horse.class;
    }

    @Override
    public String toString() {
        return String.format("%s\nВес: %d\n", super.toString(), weight);
    }
}