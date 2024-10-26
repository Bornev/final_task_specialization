package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class SortAnimalsByBirtDate extends Button {
    public SortAnimalsByBirtDate(ConsoleUI consoleUI) {
        super("Сортировка животных по дате рождения.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAnimalsSortedByBirthdate();
    }
}