package Utilities;

import Commands.Command;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Shell {

    static Scanner scanner = new Scanner(System.in);
    static ParseCommand parseCommand = new ParseCommand();
    static CommandExecutor commandExecutor = new CommandExecutor();

    /**
     * Интерактивный режим
     */
    public void shell() {

        String inputLine = scanner.nextLine();

        Command command = parseCommand.parseCommand(inputLine);

        commandExecutor.execute(command);

        shell();

    }

}
