package Commands;

import Collection.Vehicle;
import Collection.VehicleType;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FilterByTypeCommand extends Command {

    {
        this.name = "Filter by type command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        VehicleType type = null;

        if (!arguments.isEmpty()){
            if (arguments.get(0).equals("PLANE") || arguments.get(0).equals("1")) {
                type = VehicleType.PLANE;
            } else if (arguments.get(0).equals("HELICOPTER") || arguments.get(0).equals("2")) {
                type = VehicleType.HELICOPTER;
            } else if (arguments.get(0).equals("HOVERBOARD") || arguments.get(0).equals("3")) {
                type = VehicleType.HOVERBOARD;
            } else {
                System.out.println("$ Аргументы команды неверны");
                type = getType();
            }
        } else {
            type = getType();
        }

        for (Vehicle v : vehicleSet) {
            if (v.getType() == type) {
                System.out.println(v.toString());
            }
        }

    }

    public VehicleType getType() {

        VehicleType tmpType;

        Scanner scanner = new Scanner(System.in);

        System.out.print("$ Введите тип (1 - PLANE, 2 - HELICOPTER, 3 - HOVERBOARD): ");

        String numberInput = scanner.nextLine().trim();

        if (numberInput.equals("1")) {
            tmpType = VehicleType.PLANE;
        } else if (numberInput.equals("2")) {
            tmpType = VehicleType.HELICOPTER;
        } else if (numberInput.equals("3")) {
            tmpType = VehicleType.HOVERBOARD;
        } else {
            System.out.println("$ Ввод неверный");
            tmpType = getType();
        }

        return tmpType;

    }

}
