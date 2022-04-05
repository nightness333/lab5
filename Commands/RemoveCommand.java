package Commands;

import Collection.Vehicle;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveCommand extends Command {

    {
        this.name = "Remove command";
    }

    public void execute(LinkedHashSet<Vehicle> vehicleSet) {

        Long id = null;

        if (!arguments.isEmpty()) {
            try {
                id = Long.parseLong(arguments.get(0));
            } catch (NumberFormatException e) {
                id = getId();
            }
        } else {
            id = getId();
        }


        boolean flag = true;

        for (Vehicle v : vehicleSet) {
            if (v.getId().equals(id)) {
                vehicleSet.remove(v);
                System.out.println("$ Элемент был удален из коллекции");
                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("$ Элемента с таким id не существует");
        }

    }

    /**
     * Ввод правильного id
     * @return id верного формата
     */
    private Long getId() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("$ Введите id: ");

        Long id;

        try {
            id = Long.parseLong(scanner.nextLine().trim());
        } catch (java.util.InputMismatchException e) {
            System.out.println("$ Ввод неверный");
            id = getId();
        }

        return id;

    }

}
