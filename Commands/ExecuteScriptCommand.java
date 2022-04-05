package Commands;

import Collection.Vehicle;
import Utilities.CommandExecutor;
import Utilities.FileWorker;
import Utilities.ParseCommand;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ExecuteScriptCommand extends Command {

    {
        this.name = "Execute script command";
    }

    static FileWorker fileWorker = new FileWorker();
    static ParseCommand parseCommand = new ParseCommand();

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        File scriptFile;

        if (arguments == null) {
           scriptFile = fileWorker.getReadFile();
        } else {
            if (arguments.isEmpty()) {
                scriptFile = fileWorker.getReadFile();
            } else {
                String fileName = "";
                for (String s : arguments) {
                    fileName = fileName + s + " ";
                }
                scriptFile = new File(fileName.trim());
                if (!scriptFile.canRead()) {
                    System.out.println("$ Невозможно прочитать файл со скриптом");
                    scriptFile = fileWorker.getReadFile();
                }
            }
        }

        BufferedReader xmlBufferedReader = null;

        String pathToFile = scriptFile.getPath();

        String line;

        try {
            xmlBufferedReader = new BufferedReader(new FileReader(scriptFile));
        } catch (FileNotFoundException e) {
            System.out.println("$ Ошибка доступа к файлу со скриптом");
            return;
        }

        while (true) {

            line = null;

            try {
                line = xmlBufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("$ Ошибка при чтении файла со скриптом");
                line = null;
            }

            if (line == null) {
                break;
            }

            if (line.length() >= 14) {
                if (line.substring(0, 14).equals("execute_script")) {
                    String checkLine = line.substring(14).trim();
                    File checkFile = new File(checkLine);
                    if (!checkFile.exists()) {
                        System.out.println("$ Ошибка при выполнении скрипта из скрипта: несуществующий файл");
                        continue;
                    } else if (!checkFile.canRead()) {
                        System.out.println("$ Ошибка при выполнении скрипта из скрипта: нечитабельный файл");
                        continue;
                    }
                }
            }

            Command scriptCommand = parseCommand.parseCommand(line);

            String tmpPath = "";

            for (String i : scriptCommand.getArguments()) {
                tmpPath = tmpPath + i + " ";
            }

            if (scriptCommand.getName().equals(this.getName()) && tmpPath.trim().equals(pathToFile)){
                System.out.println("$ Бесконечный скрипт");
                continue;
            }

            String tmpLine = null;

            if (scriptCommand.getName().equals("Add command") || scriptCommand.getName().equals("Update command") ||
                    scriptCommand.getName().equals("Add if max command") || scriptCommand.getName().equals("Remove lower command")) {

                for (int i = 0; i < 4; i++) {
                    try {
                        tmpLine = xmlBufferedReader.readLine();
                    } catch (IOException e) {
                        System.out.println("$ Ошибка при чтении файла со скриптом");
                        return;
                    }
                    line = line + " " + tmpLine;
                }

                if (scriptCommand.getName().equals("Add command")) {
                    line = "script_add" + line.substring(3);
                } else if (scriptCommand.getName().equals("Update command")) {
                    line = "script_update" + line.substring(6);
                } else if (scriptCommand.getName().equals("Add if max command")) {
                    line = "script_add_if_max" + line.substring(10);
                } else if (scriptCommand.getName().equals("Remove lower command")) {
                    line = "script_remove_lower" + line.substring(12);
                }

                scriptCommand = parseCommand.parseCommand(line);
                CommandExecutor.execute(scriptCommand);

            } else {
                CommandExecutor.execute(scriptCommand);
            }

        }

        try {
            xmlBufferedReader.close();
        } catch (IOException e) {
            System.out.println("$ Ошибка при закрытии файла со скриптом");
        }

        System.out.println("$ Скрипт был исполнен успешно");

    }

}
