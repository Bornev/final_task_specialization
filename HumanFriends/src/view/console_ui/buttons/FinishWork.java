package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class FinishWork extends Button {
    public FinishWork(ConsoleUI consoleUI) {
        super("Конец работы.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finishWork();
    }
}