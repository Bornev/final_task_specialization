package model.builder;

import model.animal.pack_animal.horse.Horse;
import model.animal.IdGenerator;

public class HorseBuilder extends AnimalBuilder<HorseBuilder> {
    private int weight;

    public HorseBuilder(IdGenerator idGenerator) {
        super(idGenerator);
    }

    public HorseBuilder withWeight(int weight) {
        this.weight = weight;
        return this;
    }

    @Override
    protected HorseBuilder self() {
        return this;
    }

    @Override
    public Horse build() {
        return new Horse(idGenerator, name, birthDate, weight);
    }
}