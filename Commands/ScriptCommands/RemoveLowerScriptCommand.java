package Commands.ScriptCommands;

import Collection.Vehicle;
import Commands.Command;
import VehicleParsing.ParseVehicle;
import VehicleParsing.ParseVehicleScripted;

import java.util.LinkedHashSet;

public class RemoveLowerScriptCommand extends Command {

    {
        this.name = "Remove lower command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        ParseVehicleScripted parseVehicle = new ParseVehicleScripted();
        Vehicle vehicle = parseVehicle.parseVehicle(arguments);

        if (vehicle == null) {
            System.out.println("$ Возникла ошибка при выполнении команды remove lower при выполнении execute_script");
            return;
        }

        for (Vehicle v : vehicleSet) {
            if (vehicle.compareTo(v) == -1) {
                vehicleSet.remove(v);
            }
        }

    }

}
