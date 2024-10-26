package model.animal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements Serializable {
    private int id;
    private String name;
    private LocalDate birthDate;
    private List<String> commands;

    public Animal(IdGenerator idGenerator, String name, LocalDate birthDate) {
        this.id = idGenerator.getCurrentId();
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public abstract void makeSound();

    public abstract Class<? extends Animal> getType();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Animal other = (Animal) obj;
        return id == other.id &&
                name.equals(other.name) &&
                birthDate.equals(other.birthDate);
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(id);
        result = 31 * result + name.hashCode();
        result = 31 * result + birthDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("Вид животного: %s\nID: %d\nКличка: %s\nДата рождения: %s\nкоманды: %s",
                getClass().getSimpleName(), id, name, birthDate, commands);
    }
}