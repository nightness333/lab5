package Commands;

import Collection.Vehicle;
import VehicleParsing.ParseVehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class AddIfMaxCommand extends Command {

    {
        this.name = "Add if max command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        String nameVehicle = null;

        if (!arguments.isEmpty()) {
            nameVehicle = arguments.get(0);
        }

        ParseVehicle parseVehicle = new ParseVehicle();
        Vehicle vehicle = parseVehicle.parseVehicle(nameVehicle);

        boolean flag = true;

        for (Vehicle v : vehicleSet) {
            if (vehicle.compareTo(v) != -1) {
                flag = false;
            }
        }

        if (flag) {
            vehicleSet.add(vehicle);
            System.out.println("$ Элемент был добавлен в коллекцию");
        } else {
            System.out.println("$ Элемент не был добавлен в коллекцию");
        }

    }

}
