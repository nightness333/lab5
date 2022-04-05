package Utilities;

import Collection.Coordinates;
import Collection.FuelType;
import Collection.Vehicle;
import Collection.VehicleType;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;

public class ParseXML {

    /**
     * Парсинг коллекции из файла
     * @param mainFile - файл, который будем парсить
     * @return коллекцию, полученную в результате парсинга
     * @throws IOException
     * @throws ParseException
     * @throws NumberFormatException
     */
    public LinkedHashSet<Vehicle> parseXML (File mainFile) throws IOException, ParseException, NumberFormatException {
        String line;
        Vehicle tmpVehicle;
        ArrayList<String> vehicleArray = new ArrayList<String>();
        BufferedReader xmlBufferedReader = new BufferedReader(new FileReader(mainFile));
        LinkedHashSet<Vehicle> vehicleCollection = new LinkedHashSet<Vehicle>();
        while ((line = xmlBufferedReader.readLine()) != null) {
            line = line.trim();
            if ((!line.equals("<Collection>")) && (!line.equals("<Vehicle>")) && (!line.equals("<Coordinates>")) &&
                    (!line.equals("</Collection>")) && (!line.equals("</Vehicle>")) && (!line.equals("</Coordinates>"))) {
                vehicleArray.add(line);
            } else if (line.equals("</Vehicle>")) {
                tmpVehicle = xmlVehicleBuilder(vehicleArray);
                vehicleArray.clear();
                if (tmpVehicle != null) {
                    vehicleCollection.add(tmpVehicle);
                }
            }
        }
        return vehicleCollection;
    }

    /**
     * Парсинг аргументов из их строчных представлений
     * @param vehicleArray - массив строчных аргументов
     * @return готовый Vehicle с данными аргументами
     * @throws ParseException
     * @throws NumberFormatException
     */
    private Vehicle xmlVehicleBuilder(ArrayList<String> vehicleArray) throws ParseException, NumberFormatException {
        Vehicle tmpVehicle = new Vehicle();
        Coordinates tmpCoordinates = new Coordinates();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a");
        for (String vehicleString : vehicleArray) {
            vehicleString = vehicleString.trim();
            if (vehicleString.substring(0, 4).equals("<id>")) {
                tmpVehicle.setId(Long.parseLong(vehicleString.substring(5, vehicleString.length() - 5)));
            } else if (vehicleString.substring(0, 6).equals("<name>")) {
                tmpVehicle.setName(vehicleString.substring(6, vehicleString.length() - 7));
            } else if (vehicleString.substring(0, 3).equals("<x>")) {
                tmpCoordinates.setX(Long.parseLong(vehicleString.substring(3, vehicleString.length() - 4)));
            } else if (vehicleString.substring(0, 3).equals("<y>")) {
                tmpCoordinates.setY(Long.parseLong(vehicleString.substring(3, vehicleString.length() - 4)));
            } else if (vehicleString.substring(0, 14).equals("<creationDate>")) {
                String str = vehicleString.substring(14, vehicleString.length() - 15);
                Date date = formatter.parse(str);
                tmpVehicle.setCreationDate(date);
            } else if (vehicleString.substring(0, 13).equals("<enginePower>")) {
                tmpVehicle.setEnginePower(Float.parseFloat(vehicleString.substring(13, vehicleString.length() - 14)));
            } else if (vehicleString.substring(0, 16).equals("<numberOfWheels>")) {
                tmpVehicle.setNumberOfWheels(Long.parseLong(vehicleString.substring(16, vehicleString.length() - 17)));
            } else if (vehicleString.substring(0, 13).equals("<vehicleType>")) {
                tmpVehicle.setType(VehicleType.valueOf(vehicleString.substring(13, vehicleString.length() - 14)));
            } else if (vehicleString.substring(0, 10).equals("<fuelType>")) {
                tmpVehicle.setFuelType(FuelType.valueOf(vehicleString.substring(10, vehicleString.length() - 11)));
            }
        }
        tmpVehicle.setCoordinates(tmpCoordinates);

        if (tmpVehicle.getId() == null || tmpVehicle.getId() <= 0) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в ID");
        } else if (tmpVehicle.getName() == null || tmpVehicle.getName().equals("")) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в Name");
        } else if (tmpVehicle.getCoordinates() == null) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в Coordinates");
        } else if (tmpVehicle.getCreationDate() == null) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в CreationDate");
        } else if (tmpVehicle.getEnginePower() == null || tmpVehicle.getEnginePower() <= 0.0) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в EnginePower");
        } else if (tmpVehicle.getNumberOfWheels() == null || tmpVehicle.getNumberOfWheels() <= 0) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в NumberOfWheels");
        } else if (tmpVehicle.getFuelType() == null) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в FuelType");
        } else if (tmpVehicle.getType() == null) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в VehicleType");
        } else if (tmpVehicle.getCoordinates().getX() == null || tmpVehicle.getCoordinates().getX() > 454) {
            System.out.println("$ Ошибка при парсинге XML: в одном из элементов ошибка в Coordinates.x");
        } else {
            System.out.println("$ Парсинг элемента из XML прошел успешно");
            return tmpVehicle;
        }
        return null;
    }

}
