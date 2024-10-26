package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class ShowTotalAnimalsCount extends Button {
    public ShowTotalAnimalsCount(ConsoleUI consoleUI) {
        super("Показать общее количество зарегистрированных животных", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().totalCountOfAnimals();
    }
}