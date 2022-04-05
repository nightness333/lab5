package Commands;

import Collection.Vehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class PrintDescendingCommand extends Command {

    {
        this.name = "Print field descending fuel type command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        TreeSet<Vehicle> tree_set = new TreeSet<>(vehicleSet);

        for (Vehicle i : tree_set) {
            System.out.println(i.getFuelType());
        }

    }

}
