package Commands;

import Collection.Vehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public abstract class Command {

    protected String name = "Неопределенная команда";

    protected ArrayList<String> arguments;

    public abstract void execute(LinkedHashSet<Vehicle> vehicleSet);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getArguments() {
        return arguments;
    }

    public void setArguments(ArrayList<String> arguments) {
        this.arguments = arguments;
    }

}
