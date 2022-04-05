package Commands;

import Collection.Vehicle;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

public class InfoCommand extends Command {

    {
        this.name = "Info command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        Format formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");

        System.out.println("$ ---------------------------------------------");
        System.out.println("$ Информация о коллекции типа Vehicle:");
        System.out.println("$ Дата инициализации: " + formatter.format(findLowerDate(vehicleSet)));
        System.out.println("$ Количество элементов в коллекции: " + vehicleSet.size());
        System.out.println("$ ---------------------------------------------");

    }

    /**
     * Нахождение самого раннего элемент в коллекции (считаем, что эта дата - дата создания коллекции)
     * @param vehicleSet - коллекция элементов
     * @return дата самого раннего элемента
     */
    private static Date findLowerDate (LinkedHashSet<Vehicle> vehicleSet) {

        Date date = new Date();

        for (Vehicle v : vehicleSet) {
            if (date.compareTo(v.getCreationDate()) > 0) {
                date = v.getCreationDate();
            }
        }

        return date;

    }

}
