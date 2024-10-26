package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class SortAnimalsById extends Button {
    public SortAnimalsById(ConsoleUI consoleUI) {
        super("Отсортировать животных по ID.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAnimalsSortedById();
    }
}