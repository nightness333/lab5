package Commands;

import Collection.Vehicle;
import VehicleParsing.ParseVehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class RemoveLowerCommand extends Command {

    {
        this.name = "Remove lower command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        String nameVehicle = null;

        if (!arguments.isEmpty()) {
            nameVehicle = arguments.get(0);
        }

        ParseVehicle parseVehicle = new ParseVehicle();
        Vehicle vehicle = parseVehicle.parseVehicle(nameVehicle);

        for (Vehicle v : vehicleSet) {
            if (vehicle.compareTo(v) == -1) {
                vehicleSet.remove(v);
                System.out.println("$ Элемент был удален из коллекции");
            }
        }

    }

}
