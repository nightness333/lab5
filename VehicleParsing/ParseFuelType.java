package VehicleParsing;

import Collection.FuelType;

import java.util.Scanner;

public class ParseFuelType {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Возвращает FuelType
     * @return FuelType
     */
    public static FuelType parseFuelType() {

        FuelType tmpType;

        System.out.print("$ Введите тип (1 - GASOLINE, 2 - NUCLEAR, 3 - PLASMA, 4 - ANTIMATTER): ");

        String numberInput = scanner.nextLine().trim();

        if (numberInput.equals("1")) {
            tmpType = FuelType.GASOLINE;
        } else if (numberInput.equals("2")) {
            tmpType = FuelType.NUCLEAR;
        } else if (numberInput.equals("3")) {
            tmpType = FuelType.PLASMA;
        } else if (numberInput.equals("4")) {
            tmpType = FuelType.ANTIMATTER;
        } else {
            System.out.println("$ Ввод неверный");
            tmpType = parseFuelType();
        }

        return tmpType;

    }

}
