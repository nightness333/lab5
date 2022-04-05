package Utilities;

import Collection.Vehicle;
import Commands.Command;

import java.io.File;
import java.util.LinkedHashSet;

public class CommandExecutor {

    static File mainFile;
    static LinkedHashSet<Vehicle> vehicleSet;

    /**
     * Главный метод, исполняющий команды
     * @param command - команда, которую мы хотим выполнить
     */
    public static void execute (Command command) {
        command.execute(vehicleSet);
    }

    public static File getMainFile() {
        return mainFile;
    }

    public static void setMainFile(File mainFile) {
        CommandExecutor.mainFile = mainFile;
    }

    public static LinkedHashSet<Vehicle> getVehicleSet() {
        return vehicleSet;
    }

    public static void setVehicleSet(LinkedHashSet<Vehicle> vehicleSet) {
        CommandExecutor.vehicleSet = vehicleSet;
    }
}
