package Commands;

import Collection.Vehicle;

import java.util.LinkedHashSet;

public class ShowCommand extends Command {

    {
        this.name = "Show command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        for (Vehicle v : vehicleSet) {
            System.out.println(v.toString());
        }

    }

}
