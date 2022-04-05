package Commands.ScriptCommands;

import Collection.Vehicle;
import Commands.Command;
import VehicleParsing.ParseVehicle;
import VehicleParsing.ParseVehicleScripted;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class AddIfMaxScriptCommand extends Command {

    {
        this.name = "Add if max command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        ParseVehicleScripted parseVehicle = new ParseVehicleScripted();
        Vehicle vehicle = parseVehicle.parseVehicle(arguments);

        if (vehicle == null) {
            System.out.println("$ Возникла ошибка при выполнении команды add if max при выполнении execute_script");
            return;
        }

        boolean flag = true;

        for (Vehicle v : vehicleSet) {
            if (vehicle.compareTo(v) != -1) {
                flag = false;
            }
        }

        if (flag) {
            vehicleSet.add(vehicle);
        }

    }

}
