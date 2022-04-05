package Utilities;

import Commands.Command;

public class HistoryWorker {

    /** Массив для истории команд */
    private static Command[] historyCommands = new Command[10];

    /**
     * Добавление команды в историю
     * @param command - добавляемая команда
     */
    public static void addToHistory (Command command) {

        for (int i = 8; i >= 0; i--) {
            historyCommands[i+1] = historyCommands[i];
        }

        historyCommands[0] = command;

    }

    /**
     * Показать историю
     */
    public static void showHistory () {
        for (int i = 0; i < 10; i++) {
            if (historyCommands[i] != null) {
                System.out.println(i+1 + ". " + historyCommands[i].getName());
            }
        }
    }

    public static Command[] getHistoryCommands() {
        return historyCommands;
    }
}
