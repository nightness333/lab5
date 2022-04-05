package Commands;

import Collection.Vehicle;
import Utilities.HistoryWorker;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class HistoryCommand extends Command {

    {
        this.name = "History command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        HistoryWorker.showHistory();

    }

}
