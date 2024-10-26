package view.console_ui;

import presenter.Presenter;
import view.View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private String path = "src/model/writer/serialized_files/animal_registry.ser";
    private List<String> animalTypes;
    private MenuHandler menuHandler;
    private Presenter presenter;
    private InputHandler inputHandler;
    private boolean work;

    public ConsoleUI() {
        inputHandler = new InputHandler(new Scanner(System.in));
        presenter = new Presenter(this);
        menuHandler = new MenuHandler(this);
        work = true;
        animalTypes = presenter.animalTypes();
        presenter.setPath(path);
    }

    @Override
    public void startWork() {
        greetings();
        presenter.readAnimalData();
        selectItemFromMenu();
    }

    private void greetings() {
        System.out.println("Добро пожаловать в программу реестра животных!");
    }

    private void selectItemFromMenu() {
        while (work) {
            System.out.println(menuHandler.getMenu());
            String choiceStr = inputHandler.getInput();
            if (inputHandler.isValidMenuChoice(choiceStr, menuHandler.size())) {
                int choice = Integer.parseInt(choiceStr);
                menuHandler.execute(choice);
            } else {
                System.out.println("\"Введен недопустимый пункт меню.\nПожалуйста, введите корректный номер из меню: от 1 до " + menuHandler.size());
            }
        }
    }

    public void createAnimal() {
        System.out.println("Пожалуйста, выберите животное, которое хотите создать:");
        for (String animalType : animalTypes) {
            System.out.println("• " + animalType);
        }
        String animalType = inputHandler.getAnimalTypeInput(animalTypes); // Ожидание корректного ввода
    
        String name = getName(animalType);
        LocalDate birthDate = getBirthDate(name);
    
        switch (animalType.toLowerCase()) {
            case "собака":
                createDog(name, birthDate);
                break;
            case "кошка":
                createCat(name, birthDate);
                break;
            case "хомяк":
                createHamster(name, birthDate);
                break;
            case "верблюд":
                createCamel(name, birthDate);
                break;
            case "лошадь":
                createHorse(name, birthDate);
                break;
            case "осел":
                createDonkey(name, birthDate);
                break;
            default:
                System.out.println("Неизвестный тип животного.");
        }
    }

    private String getName(String animalType) {
        System.out.println("Введите кличку " + animalType.toLowerCase() + ":");
        return inputHandler.getInput();
    }

    private LocalDate getBirthDate(String name) {
        System.out.println("Введите дату рождения " + name + "через пробелы в формате ДД ММ ГГГГ:");
        return inputHandler.getBirthDateInput();
    }

    private void createDog(String name, LocalDate birthDate) {
        System.out.println("Введите породу собаки:");
        String breed = inputHandler.getInput();
        presenter.createDog(name, birthDate, breed);
    }

    private void createCat(String name, LocalDate birthDate) {
        System.out.println("Введите окрас кошки:");
        String color = inputHandler.getInput();
        presenter.createCat(name, birthDate, color);
    }

    private void createHamster(String name, LocalDate birthDate) {
        System.out.println("Введите время нахождения выхода из лабиринтаа хомяком:");
        int timeOfFidindAnExit = inputHandler.getNumberInput("Время нахождения выхода из лабиринта");
        presenter.createHamster(name, birthDate, timeOfFidindAnExit);
    }

    private void createCamel(String name, LocalDate birthDate) {
        System.out.println("Введите количество горбов (1 или 2):");
        int numberOfHumps = inputHandler.getNumberInput("горбов");
        presenter.createCamel(name, birthDate, numberOfHumps);
    }

    private void createHorse(String name, LocalDate birthDate) {
        System.out.println("Введите вес переносимого лошадью груза:");
        int weight = inputHandler.getNumberInput("вес");
        presenter.createHorse(name, birthDate, weight);
    }

    private void createDonkey(String name, LocalDate birthDate) {
        System.out.println("Введите выносливость осла:");
        int stamina = inputHandler.getNumberInput("выносливость");
        presenter.createDonkey(name, birthDate, stamina);
    }

    public void trainAnimal() {
        while (true) {
            System.out.println("Пожалуйста, введите кличку животного:");
            String name = inputHandler.getInput();
            if (presenter.isAnimalExist(name)) {
                System.out.println("Пожалуйста, введите команду:");
                String command = inputHandler.getInput();
                presenter.trainAnimal(name, command);
                System.out.println("Животное с кличкой " + name + " выучило команду: " + command + ".\n");
                return;
            } else {
                System.out.println("Животное с кличкой " + name + " не найдено.");
            }
        }
    }

    public void printAnimalCommands() {
        while (true) {
            System.out.println("Пожалуйста, введите кличку животного:");
            String name = inputHandler.getInput();
            if (presenter.isAnimalExist(name)) {
                System.out.println("Команды для " + name + ": ");
                presenter.printAnimalCommands(name);
                return;
            } else {
                System.out.println("Животное с кличкой " + name + " не найдено.");
            }
        }
    }

    public void getAnimalsSortedByBirthdate() {
        System.out.println("Животные, отсортированные по дате рождения:");
        presenter.getAnimalsSortedByBirthdate();
    }

    public void getAnimalsSortedById() {
        System.out.println("Животные, отсортированные по ID:");
        presenter.getAnimalsSortedById();
    }

    public void printAllAnimals() {
        presenter.printAllAnimals();
    }

    public void totalCountOfAnimals() {
        System.out.println("Общее количество зарегистрированных животных: " + presenter.totalCountOfAnimals() + ".\n");
    }

    @Override
    public void finishWork() {
        work = false;
        System.out.println("До свидания!");
        presenter.saveAnimalData();
    }
}