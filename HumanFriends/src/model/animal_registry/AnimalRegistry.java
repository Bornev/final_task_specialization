package model.animal_registry;

import model.animal.Animal;

import java.io.Serializable;
import java.util.*;

public class AnimalRegistry implements Serializable {
    private Map<Class<? extends Animal>, List<Animal>> animalMap;

    public AnimalRegistry() {
        animalMap = new HashMap<>();
    }

    public void addAnimal(Animal animal) {
        Class<? extends Animal> type = animal.getType();
        List<Animal> animals = animalMap.computeIfAbsent(type, k -> new ArrayList<>());
        animals.add(animal);
    }

    public void trainAnimal(String name, String command) {
        findAnimalByName(name).forEach(animal -> animal.addCommand(command));
    }

    public void printAnimalCommands(String name) {
        findAnimalByName(name).forEach(animal -> System.out.println(animal.getCommands()));
    }

    public void printAllAnimals() {
        getAnimalsSortedById().forEach(System.out::println);
    }

    public boolean isAnimalExist(String name) {
        return findAnimalByName(name).size() > 0;
    }

    public List<Animal> getAnimalsSortedByBirthdate() {
        return sortAnimalsBy(new AnimalsComparatorByBirthDate());
    }

    public List<Animal> getAnimalsSortedById() {
        return sortAnimalsBy(new AnimalsComparatorById());
    }

    public int getMaxId() {
        return findAllAnimals().stream()
                .mapToInt(Animal::getId)
                .max()
                .orElse(0);
    }

    private List<Animal> findAllAnimals() {
        List<Animal> allAnimals = new ArrayList<>();
        animalMap.values().forEach(allAnimals::addAll);
        return allAnimals;
    }

    private List<Animal> findAnimalByName(String name) {
        return findAllAnimals().stream()
                .filter(animal -> animal.getName().equals(name))
                .toList();
    }

    private List<Animal> sortAnimalsBy(Comparator<Animal> comparator) {
        List<Animal> allAnimals = findAllAnimals();
        allAnimals.sort(comparator);
        return allAnimals;
    }

    public int totalCountOfAnimals() {
        return findAllAnimals().size();
    }

    public void deleteAnimal(String name) {
        boolean animalFound = false;
        // Перебираем каждую группу животных по типу
        for (List<Animal> animals : animalMap.values()) {
            // Удаляем животное с указанным именем, если оно найдено
            animalFound = animals.removeIf(animal -> animal.getName().equals(name)) || animalFound;
        }
    
        if (animalFound) {
            System.out.println("Животное с кличкой " + name + " успешно удалено.");
        } else {
            System.out.println("Животное с кличкой " + name + " не найдено.");
        }
    }
}