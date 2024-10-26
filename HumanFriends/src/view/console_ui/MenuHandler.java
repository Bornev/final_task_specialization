package view.console_ui;

import view.console_ui.buttons.*;

import java.util.ArrayList;
import java.util.List;

public class MenuHandler {
    private List<Button> buttons;

    public MenuHandler(ConsoleUI consoleUI) {
        buttons = new ArrayList<>();
        buttons.add(new CreateAnimal(consoleUI));
        buttons.add(new TrainAnimal(consoleUI));
        buttons.add(new PrintAnimalCommands(consoleUI));
        buttons.add(new SortAnimalsByBirtDate(consoleUI));
        buttons.add(new SortAnimalsById(consoleUI));
        buttons.add(new PrintAllAnimals(consoleUI));
        buttons.add(new ShowTotalAnimalsCount(consoleUI));
        buttons.add(new FinishWork(consoleUI));
    }

    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Пожалуйста, выберите опцию из меню.\nМеню:\n");
        for (int i = 0; i < buttons.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(buttons.get(i).getDescription())
                    .append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Button button = buttons.get(choice - 1);
        button.execute();
    }

    public int size() {
        return buttons.size();
    }
}