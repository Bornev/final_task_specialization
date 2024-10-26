package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class CreateAnimal extends Button {
    public CreateAnimal(ConsoleUI consoleUI) {
        super("Зарегистрировать животное.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().createAnimal();
    }
}