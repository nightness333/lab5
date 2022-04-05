package VehicleParsing;

import Collection.Coordinates;
import Collection.FuelType;
import Collection.Vehicle;
import Collection.VehicleType;

import java.util.ArrayList;
import java.util.Date;

public class ParseVehicleScripted {

    /**
     * Возвращает Vehicle заданный в ходе работы скрипта
     * @param arguments - поля в формате строк
     * @return готовый Vehicle
     */
    public Vehicle parseVehicle(ArrayList<String> arguments) {

        Vehicle newVehicle = new Vehicle();

        if (arguments.isEmpty()) {
            System.out.println("$ Ошибка при выполнении скрипта: нет аргументов для создания Vehicle");
            return null;
        } else if (arguments.size() < 7) {
            System.out.println("$ Ошибка при выполнении скрипта: недостаточно аргументов для создания Vehicle");
            return null;
        } else {
            String newName = arguments.get(0);
            String newX = arguments.get(1);
            String newY = arguments.get(2);
            String newEnginePower = arguments.get(3);
            String newNumberOfWheels = arguments.get(4);
            String newVehicleType = arguments.get(5);
            String newFuelType = arguments.get(6);

            Date date = new Date();
            newVehicle.setCreationDate(date);

            newVehicle.setId((long) ((Math.random() * (10000000 - 1)) + 1));

            newVehicle.setName(newName);

            try {
                Coordinates coordinates = new Coordinates();
                coordinates.setX(Long.parseLong(newX));
                coordinates.setY(Long.parseLong(newY));
                if (coordinates.getX() > 454) {
                    return null;
                }
                newVehicle.setCoordinates(coordinates);
            } catch (NumberFormatException e) {
                System.out.println("$ Ошибка при выполнении скрипта: неправильные координаты Vehicle");
                return null;
            }

            try {
                newVehicle.setEnginePower(Float.parseFloat(newEnginePower));
                if (newVehicle.getEnginePower() <= 0) {
                    return null;
                }
            } catch (NumberFormatException e) {
                System.out.println("$ Ошибка при выполнении скрипта: неправильный EnginePower");
                return null;
            }

            try {
                newVehicle.setNumberOfWheels(Long.parseLong(newNumberOfWheels));
                if (newVehicle.getNumberOfWheels() <= 0) {
                    return null;
                }
            } catch (NumberFormatException e) {
                System.out.println("$ Ошибка при выполнении скрипта: неправильный NumberOfWheels");
                return null;
            }

            if (newVehicleType.equals("1")) {
                newVehicle.setType(VehicleType.PLANE);
            } else if (newVehicleType.equals("2")) {
                newVehicle.setType(VehicleType.HELICOPTER);
            } else if (newVehicleType.equals("3")) {
                newVehicle.setType(VehicleType.HOVERBOARD);
            } else {
                System.out.println("$ Ошибка при выполнении скрипта: неправильный VehicleType");
                return null;
            }

            if (newFuelType.equals("1")) {
                newVehicle.setFuelType(FuelType.GASOLINE);
            } else if (newFuelType.equals("2")) {
                newVehicle.setFuelType(FuelType.NUCLEAR);
            } else if (newFuelType.equals("3")) {
                newVehicle.setFuelType(FuelType.PLASMA);
            } else if (newFuelType.equals("4")) {
                newVehicle.setFuelType(FuelType.ANTIMATTER);
            } else {
                System.out.println("$ Ошибка при выполнении скрипта: неправильный FuelType");
                return null;
            }

        }

        return newVehicle;

    }

}
