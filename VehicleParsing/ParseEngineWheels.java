package VehicleParsing;

import java.util.Scanner;

public class ParseEngineWheels {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Возвращает EnginePower и NumberOfWheels в формате строк
     * @return аргументы EnginePower и NumberOfWheels
     */
    public static String[] parseEngineWheels() {

        String[] returnEngineWheels = new String[2];

        System.out.print("$ Введите EnginePower и NumberOfWheels (напр 75.0 4): ");

        String[] inputLine = scanner.nextLine().trim().split("[\\s]{1,}");

        if (inputLine.length < 2) {
            System.out.println("$ Недостаточно аргументов");
            returnEngineWheels = parseEngineWheels();
        } else {
            String engineLine = inputLine[0].trim();
            String wheelsLine = inputLine[1].trim();
            returnEngineWheels[0] = engineLine;
            returnEngineWheels[1] = wheelsLine;
            try {
                Float.parseFloat(engineLine);
            } catch (NumberFormatException e) {
                returnEngineWheels[0] = parseEngine();
            }
            try {
                Long.parseLong(wheelsLine);
            } catch (NumberFormatException e) {
                returnEngineWheels[1] = parseWheels();
            }
        }

        return returnEngineWheels;

    }

    /**
     * Возвращает строчку с EnginePower
     * @return EnginePower в строковом формате
     */
    private static String parseEngine () {

        String returnString = null;

        System.out.print("$ Введите EnginePower (напр 75.0): ");

        String inputEngine = scanner.nextLine().trim();

        try {
            Float.parseFloat(inputEngine);
            returnString = inputEngine;
        } catch (NumberFormatException e) {
            returnString = parseEngine();
        }

        return returnString;

    }

    /**
     * Возращает строчку с NumberOfWheels
     * @return NumberOfWheels в строковом формате
     */
    private static String parseWheels () {

        String returnString = null;

        System.out.print("$ Введите NumberOfWheels (напр 4): ");

        String inputWheels = scanner.nextLine().trim();

        try {
            Long.parseLong(inputWheels);
            returnString = inputWheels;
        } catch (NumberFormatException e) {
            returnString = parseWheels();
        }

        return returnString;

    }

}
