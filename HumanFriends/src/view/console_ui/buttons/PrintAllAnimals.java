package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class PrintAllAnimals extends Button {
    public PrintAllAnimals(ConsoleUI consoleUI) {
        super("Показать всех животных.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().printAllAnimals();
    }
}