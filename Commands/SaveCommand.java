package Commands;

import Collection.Vehicle;
import Utilities.CommandExecutor;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;

public class SaveCommand extends Command {

    {
        this.name = "Save command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {
        try {
            File mainFile = CommandExecutor.getMainFile();
            if(mainFile.delete()){
                mainFile.createNewFile();
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(mainFile));
            osw.write("<Collection>\n");
            for (Vehicle i : vehicleSet) {
                osw.write("    <Vehicle>\n");
                osw.write("        <id>" + i.getId().toString() + "</id>\n");
                osw.write("        <name>" + i.getName() + "</name>\n");
                osw.write("        <Coordinates>\n");
                osw.write("            <x>" + i.getCoordinates().getX().toString() + "</x>\n");
                osw.write("            <y>" + i.getCoordinates().getY() + "</y>\n");
                osw.write("        </Coordinates>\n");
                Format formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
                String date = formatter.format(i.getCreationDate());
                osw.write("        <creationDate>" + date + "</creationDate>\n");
                osw.write("        <enginePower>" + i.getEnginePower().toString() + "</enginePower>\n");
                osw.write("        <numberOfWheels>" + i.getNumberOfWheels().toString() + "</numberOfWheels>\n");
                osw.write("        <vehicleType>" + i.getType().toString() + "</vehicleType>\n");
                osw.write("        <fuelType>" + i.getFuelType().toString() + "</fuelType>\n");
                osw.write("    </Vehicle>\n");
            }
            osw.write("</Collection>");
            osw.close();
            System.out.println("$ Сохранение коллекции выполнено успешно");
        } catch (FileNotFoundException e) {
            System.out.println("$ Данного файла не существует");
        } catch (IOException e) {
            System.out.println("$ Ошибка записи в файл");
        }
    }

}
