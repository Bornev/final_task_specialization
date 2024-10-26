package model.builder;

import model.animal.Animal;
import model.animal.IdGenerator;

import java.time.LocalDate;

public abstract class AnimalBuilder<T extends AnimalBuilder<T>> {
    protected IdGenerator idGenerator;
    protected String name;
    protected LocalDate birthDate;

    public AnimalBuilder(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public T withName(String name) {
        this.name = name;
        return self();
    }

    public T withBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return self();
    }

    protected abstract T self();

    public abstract Animal build();
}