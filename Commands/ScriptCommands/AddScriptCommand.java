package Commands.ScriptCommands;

import Collection.Vehicle;
import Commands.Command;
import VehicleParsing.ParseVehicleScripted;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class AddScriptCommand extends Command {

    {
        this.name = "Add command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        ParseVehicleScripted parseVehicle = new ParseVehicleScripted();
        Vehicle vehicle = parseVehicle.parseVehicle(arguments);

        if(vehicle == null) {
            System.out.println("$ Возникла ошибка при выполнении команды add при выполнении execute_script");
            return;
        }

        vehicleSet.add(vehicle);

    }

}
