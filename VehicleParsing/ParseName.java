package VehicleParsing;

import java.util.Scanner;

public class ParseName {

    static Scanner scanner = new Scanner(System.in);

    /**
     * Возвращает строку имени
     * @return name
     */
    public static String parseName() {

        System.out.print("$ Введите имя объекта: ");

        String nameInput = scanner.nextLine().trim();

        if (nameInput == null) {
            nameInput = parseName();
        } else if (nameInput.isEmpty()) {
            nameInput = parseName();
        }

        return nameInput;

    }

}
