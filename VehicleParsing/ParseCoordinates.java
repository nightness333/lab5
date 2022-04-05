package VehicleParsing;

import Collection.Coordinates;

import java.util.Scanner;

public class ParseCoordinates {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Ввод аргументов
     * @return корректные аргументы
     */
    public static Coordinates parseCoordinates() {

        Coordinates coordinates = new Coordinates();

        System.out.print("$ Введите коориданаты (напр. 65 75): ");

        String[] inputLine = scanner.nextLine().trim().split("[\\s]{1,}");

        if (inputLine.length < 2) {
            System.out.println("$ Недостаточно аргументов");
            coordinates = parseCoordinates();
        } else {
            String xLine = inputLine[0].trim();
            String yLine = inputLine[1].trim();
            try {
                coordinates.setX(Long.parseLong(xLine));
            } catch (NumberFormatException e) {
                System.out.println("$ Неправильный аргумент x");
                coordinates.setX(parseX());
            }
            try {
                coordinates.setY(Long.parseLong(yLine));
            } catch (NumberFormatException e) {
                System.out.println("$ Неправильный аргумент y");
                coordinates.setY(parseY());
            }
            if (coordinates.getX() > 454) {
                coordinates = parseCoordinates();
            }
        }

        return coordinates;

    }

    /**
     * Ввод координаты X
     * @return корректная координата X
     */
    private static Long parseX() {

        System.out.print("$ Введите координату x: ");

        String inputX = scanner.nextLine().trim();

        Long returnX;

        try {
            returnX = Long.parseLong(inputX);
        } catch (NumberFormatException e) {
            System.out.println("$ Неправильный ввод");
            returnX = parseX();
        }

        if (returnX > 454) {
            returnX = parseX();
        }

        return returnX;

    }

    /**
     * Ввод координаты Y
     * @return корректная координата Y
     */
    private static Long parseY() {

        System.out.print("$ Введите координату y: ");

        String inputY = scanner.nextLine().trim();

        Long returnY;

        try {
            returnY = Long.parseLong(inputY);
        } catch (NumberFormatException e) {
            System.out.println("$ Неправильный ввод");
            returnY = parseX();
        }

        return returnY;

    }

}
