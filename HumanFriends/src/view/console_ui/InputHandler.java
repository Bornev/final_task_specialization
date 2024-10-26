package view.console_ui;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class InputHandler {
    private static final String INVALID_FORMAT_MESSAGE = "Неверный формат. Пожалуйста, введите число.";
    private static final String INVALID_DATE_MESSAGE = "Неверный формат даты рождения. Пожалуйста, введите дату в формате ДД ММ ГГГГ:";
    private static final String INVALID_HUMPS_MESSAGE = "Некорректное количество горбов. Пожалуйста, введите 1 или 2.";
    private static final String INVALID_NUMBER_MESSAGE = "Некорректное значение для %s. Пожалуйста, введите положительное число.";
    private static final String WRONG_CHOICE_MESSAGE = "Неверный выбор. Пожалуйста, выберите тип животного из предложенного списка:";
    private static final String WRONG_DATE_MESSAGE = "Дата рождения не может быть позже текущей. Пожалуйста, введите корректную дату:";

    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine().trim();
    }

    public LocalDate getBirthDateInput() {
        while (true) {
            String input = getInput();
            try {
                LocalDate birthDate = parseDate(input);
                if (birthDate.isAfter(LocalDate.now())) {
                    System.out.println(WRONG_DATE_MESSAGE);
                } else {
                    return birthDate;
                }
            } catch (DateTimeException | NumberFormatException e) {
                System.out.println(INVALID_DATE_MESSAGE);
            }
        }
    }

    private LocalDate parseDate(String input) {
        String[] parts = input.split(" ");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);
        return LocalDate.of(year, month, day);
    }

    public boolean isValidMenuChoice(String choiceStr, int menuSize) {
        return isValidNumber(choiceStr, 1, menuSize);
    }

    private boolean isValidNumber(String choiceStr, int min, int max) {
        try {
            int choice = Integer.parseInt(choiceStr);
            return choice >= min && choice <= max;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getNumberInput(String value) {
        while (true) {
            String input = getInput();
            try {
                int number = Integer.parseInt(input);
                if (isValidNumberForValue(value, number)) {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_FORMAT_MESSAGE);
            }
        }
    }

    private boolean isValidNumberForValue(String value, int number) {
        if ("Горбы".equals(value)) {
            if (number == 1 || number == 2) {
                return true;
            } else {
                System.out.println(INVALID_HUMPS_MESSAGE);
            }
        } else if (number > 0) {
            return true;
        } else {
            System.out.println(String.format(INVALID_NUMBER_MESSAGE, value));
        }
        return false;
    }

    public String getAnimalTypeInput(List<String> animalTypes) {
        Set<String> animalSet = new HashSet<>();
        for (String animal : animalTypes) {
            animalSet.add(animal.toLowerCase());
        }
        System.out.println("Доступные типы животных: " + animalSet); // Проверка доступных значений
        
        while (true) {
            String animalType = getInput().toLowerCase();
            if (animalSet.contains(animalType)) {
                return capitalize(animalType);
            }
            System.out.println(WRONG_CHOICE_MESSAGE);
            for (String animal : animalTypes) {
                System.out.println("• " + animal);
            }
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}