package Commands;

import Collection.Vehicle;
import VehicleParsing.ParseVehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class AddCommand extends Command {

    {
        this.name = "Add command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        String nameVehicle = null;

        if (!arguments.isEmpty()) {
            nameVehicle = arguments.get(0);
        }

        ParseVehicle parseVehicle = new ParseVehicle();
        Vehicle vehicle = parseVehicle.parseVehicle(nameVehicle);

        vehicleSet.add(vehicle);

        System.out.println("$ Элемент был добавлен в коллекцию");

    }

}
