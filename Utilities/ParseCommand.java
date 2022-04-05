package Utilities;

import Commands.*;
import Commands.ScriptCommands.AddIfMaxScriptCommand;
import Commands.ScriptCommands.AddScriptCommand;
import Commands.ScriptCommands.RemoveLowerScriptCommand;
import Commands.ScriptCommands.UpdateScriptCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class ParseCommand {

    /**
     * Получение команды из строки
     * @param inputLine - изначальная строка
     * @return команда, полученная из строки
     */

    static HashMap<String, Command> commandHashMap = new HashMap<>();

    static {
        commandHashMap.put("help", new HelpCommand());
        commandHashMap.put("info", new InfoCommand());
        commandHashMap.put("show", new ShowCommand());
        commandHashMap.put("add", new AddCommand());
        commandHashMap.put("update", new UpdateCommand());
        commandHashMap.put("remove_by_id", new RemoveCommand());
        commandHashMap.put("clear", new ClearCommand());
        commandHashMap.put("save", new SaveCommand());
        commandHashMap.put("execute_script", new ExecuteScriptCommand());
        commandHashMap.put("exit", new ExitCommand());
        commandHashMap.put("add_if_max", new AddIfMaxCommand());
        commandHashMap.put("remove_lower", new RemoveLowerCommand());
        commandHashMap.put("history", new HistoryCommand());
        commandHashMap.put("max_by_number_of_wheels", new MaxByNumberCommand());
        commandHashMap.put("filter_by_type", new FilterByTypeCommand());
        commandHashMap.put("print_field_descending_fuel_type", new PrintDescendingCommand());
        commandHashMap.put("script_add_if_max", new AddIfMaxScriptCommand());
        commandHashMap.put("script_add", new AddScriptCommand());
        commandHashMap.put("script_remove_lower", new RemoveLowerScriptCommand());
        commandHashMap.put("script_update", new UpdateScriptCommand());
        commandHashMap.put("null", new NullCommand());
    }


    public Command parseCommand(String inputLine) {

        Command returnCommand = null;

        inputLine = inputLine.trim();


        String[] commandSplit = inputLine.split(" ", 2);

        String commandName = commandSplit[0];

        returnCommand = commandHashMap.get(commandName);

        if (returnCommand == null) {
            returnCommand = commandHashMap.get("null");
        }

        if (commandSplit.length > 1) {
            String argumentsLine = commandSplit[1];
            argumentsLine = argumentsLine.replaceAll("[\\s]{2,}", " ").trim();
            ArrayList<String> argumentsList = new ArrayList<String>(Arrays.asList(argumentsLine.split(" ")));
            returnCommand.setArguments(argumentsList);
        } else {
            ArrayList<String> argumentsList = new ArrayList<String>();
            returnCommand.setArguments(argumentsList);
        }

        HistoryWorker.addToHistory(returnCommand);

        return returnCommand;

    }
}
