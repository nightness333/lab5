package Commands;

import Collection.Vehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ClearCommand extends Command {

    {
        this.name = "Clear command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        vehicleSet.clear();

        System.out.println("$ Коллекция была отчищена");

    }

}
