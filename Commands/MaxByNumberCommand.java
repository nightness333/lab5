package Commands;

import Collection.Vehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class MaxByNumberCommand extends Command {

    {
        this.name = "Max by number of wheels command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        long max = -1L;

        for (Vehicle v : vehicleSet) {
            if (v.getNumberOfWheels() > max) {
                max = v.getNumberOfWheels();
            }
        }

        for (Vehicle v : vehicleSet) {
            if (v.getNumberOfWheels() == max) {
                System.out.println(v.toString());
            }
            break;
        }

    }

}
