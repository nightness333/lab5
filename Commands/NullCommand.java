package Commands;

import Collection.Vehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class NullCommand extends Command {

    {
        this.name = "Null command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {
        System.out.println("$ Такой команды не существует");
    }

}
