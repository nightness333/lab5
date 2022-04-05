package Utilities;

import Collection.Vehicle;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FileWorker {

    /**
     * Работа по получению файла и его парсинге
     * @param fileName - имя файла, изначально введеннего при запуске программы
     */
    public void fileWorker(String fileName) {

        File mainFile = new File(fileName);

        if (!fileCheck(mainFile)) {
            mainFile = getFile();
        }

        ParseXML parseXML = new ParseXML();
        LinkedHashSet<Vehicle> parsedXML;

        try {
            parsedXML = parseXML.parseXML(mainFile);
        } catch (IOException | ParseException | NumberFormatException e) {
            System.out.println("$ Ошибка при парсинге XML-файла");
            parsedXML = parseFile();
        }

        System.out.println("$ Парсинг XML-файла прошел успешно");

        CommandExecutor.setMainFile(mainFile);
        CommandExecutor.setVehicleSet(parsedXML);

    }

    /**
     * Получение коллекции из введенного файла
     * @return коллекция типа Vehicle
     */
    private LinkedHashSet<Vehicle> parseFile() {

        File tmpFile = inputFile();

        ParseXML parseXML = new ParseXML();

        LinkedHashSet<Vehicle> parsedXML;

        try {
            parsedXML = parseXML.parseXML(tmpFile);
        } catch (IOException | ParseException | NumberFormatException e) {
            System.out.println("$ Ошибка при парсинге XML-файла");
            parsedXML = parseFile();
        }

        return parsedXML;

    }

    /**
     * Получение доступного для чтения и записи файла
     * @return возвращает доступный для чтения/записи файл
     */
    public File getFile() {

        File tmpFile = inputFile();
        if (!fileCheck(tmpFile)) {
            tmpFile = getFile();
        }

        return tmpFile;

    }

    public File getReadFile() {

        File tmpFile = inputFile();
        if (!readCheck(tmpFile)) {
            tmpFile = getReadFile();
        }

        return tmpFile;

    }

    public boolean readCheck(File file) {

        boolean flag = true;

        if (!file.exists()) {
            System.out.println("$ Данного файла не существует");
            flag = false;
        }
        if (!file.canRead()) {
            System.out.println("$ Данный файл недоступен для чтения");
            flag = false;
        }

        return flag;

    }

    /**
     * Проверка доступности файла
     * @param file - файл, который мы хотим проверить
     * @return возвращает True, если файл доступен, иначе False
     */
    private boolean fileCheck(File file) {

        boolean flag = true;

        if (!file.exists()) {
            System.out.println("$ Данного файла не существует");
            flag = false;
        }
        if (!file.canRead()) {
            System.out.println("$ Данный файл недоступен для чтения");
            flag = false;
        }
        if (!file.canWrite()) {
            System.out.println("$ Данный файл недоступен для записи");
            flag = false;
        }

        return flag;

    }

    /**
     * Ввод имени файла
     * @return возвращает файл с введенным именем
     */
    private File inputFile() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("$ Введите новый путь к файлу (exit - выйти из программы): ");
        String fileName = scanner.nextLine();
        if (fileName.equals("exit")) {
            System.exit(0);
        }
        File newFile = new File(fileName);
        return newFile;

    }

}
