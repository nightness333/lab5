package VehicleParsing;

import Collection.Vehicle;

import java.util.Date;
import java.util.UUID;

public class ParseVehicle {

    /**
     * Составляет Vehicle из составных элементов
     * @param name - имя, если изначально задано
     * @return готовый Vehicle из заданных параметров
     */
    public Vehicle parseVehicle(String name) {

        Vehicle returnVehicle = new Vehicle();

        if (name == null) {
            name = ParseName.parseName();
            returnVehicle.setName(name);
        } else {
            returnVehicle.setName(name);
        }

        Long id = (long) ((Math.random() * (10000000 - 1)) + 1);
        returnVehicle.setId(id);

        returnVehicle.setCoordinates(ParseCoordinates.parseCoordinates());

        Date date = new Date();
        returnVehicle.setCreationDate(date);

        String[] engineWheels = ParseEngineWheels.parseEngineWheels();

        while (Float.parseFloat(engineWheels[0]) <= 0 || Long.parseLong(engineWheels[1]) <= 0) {
            engineWheels = ParseEngineWheels.parseEngineWheels();
        }

        returnVehicle.setEnginePower(Float.parseFloat(engineWheels[0]));
        returnVehicle.setNumberOfWheels(Long.parseLong(engineWheels[1]));

        returnVehicle.setType(ParseVehicleType.parseVehicleType());

        returnVehicle.setFuelType(ParseFuelType.parseFuelType());

        return returnVehicle;

    }

}
