package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class PrintAnimalCommands extends Button {
    public PrintAnimalCommands(ConsoleUI consoleUI) {
        super("Показать выученные команды выбранного животного.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().printAnimalCommands();
    }
}