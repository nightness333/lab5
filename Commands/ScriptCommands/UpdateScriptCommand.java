package Commands.ScriptCommands;

import Collection.Vehicle;
import Commands.Command;
import VehicleParsing.ParseVehicle;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UpdateScriptCommand extends Command {

    {
        this.name = "Update command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        String nameVehicle = null;

        Long id;

        if (arguments.isEmpty()) {
            id = parseId();
        } else if (arguments.size() == 1) {
            try {
                id = Long.parseLong(arguments.get(0));
            } catch (NumberFormatException e) {
                id = parseId();
            }
        } else {
            try {
                id = Long.parseLong(arguments.get(0));
            } catch (NumberFormatException e) {
                id = parseId();
            }
            name = arguments.get(1);
        }

        ParseVehicle parseVehicle = new ParseVehicle();
        Vehicle vehicle = parseVehicle.parseVehicle(nameVehicle);

        boolean flag = true;

        for (Vehicle v : vehicleSet) {
            if (v.getId() == id) {
                vehicleSet.remove(v);
                vehicle.setId(id);
                vehicleSet.add(vehicle);
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("$ Объекта в коллекции под таким id не существует");
        }

    }

    private static Long parseId() {

        Long id;

        Scanner scanner = new Scanner(System.in);

        System.out.println("$ Введите id: ");

        try {
            id = Long.parseLong(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            id = parseId();
        }

        return id;

    }

}
