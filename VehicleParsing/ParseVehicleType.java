package VehicleParsing;

import Collection.VehicleType;

import java.util.Scanner;

public class ParseVehicleType {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Возвращает VehicleType
     * @return VehicleType
     */
    public static VehicleType parseVehicleType() {

        VehicleType tmpType;

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
            tmpType = parseVehicleType();
        }

        return tmpType;

    }

}
