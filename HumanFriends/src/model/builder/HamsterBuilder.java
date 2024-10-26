package model.builder;

import model.animal.pet.hamster.Hamster;
import model.animal.IdGenerator;

public class HamsterBuilder extends AnimalBuilder<HamsterBuilder> {
    private int timeOfFidindAnExit;

    public HamsterBuilder(IdGenerator idGenerator) {
        super(idGenerator);
    }

    public HamsterBuilder withTimeOfFidindAnExit(int timeOfFidindAnExit) {
        this.timeOfFidindAnExit = timeOfFidindAnExit;
        return this;
    }

    @Override
    protected HamsterBuilder self() {
        return this;
    }

    @Override
    public Hamster build() {
        return new Hamster(idGenerator, name, birthDate, timeOfFidindAnExit);
    }
}