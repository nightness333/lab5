package Commands;

import Collection.Vehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ExitCommand extends Command {

    {
        this.name = "Exit command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        System.out.println("$ Программа выключена без сохранения");
        System.exit(066);

    }

}
