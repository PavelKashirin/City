package com.study.service;

import com.study.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MenuService {

    /**
     * Этот метод используется для отображения данных справочника городов, согласно выбранного
     * пункта меню.
     *
     * @param list Это список получаемый из методов: getSortForDistrictAndNameCities(),
     *             getSortNameCities(), getAllCities().
     */
    private static void printList(List<?> list) {
        list.forEach(System.out::println);
    }

    /**
     * Этот метод определяет индекс и количество жителей города с максимальной численностью населения.
     *
     * @return - возвращает строку с индексом города с максимальной численностью и значение количества жителей.
     */

    public static String getMostPopulationCity() {
        int index = 0; //индекс города с максимальной численностью
        int count = 0; //счётчик городов
        int mostPopulation = 0; //максимальная численность населения города
        for (City city : getAllCities()) {
            count++;
            int temp = city.getPopulation();
            if (temp > mostPopulation) { //если численность текущего города выше максимальной численности
                mostPopulation = temp; // то присвоить значение текущего города переменной максимальной численности,
                index = count; // а значение текущего города индексу города максимальной численности
            }
        }

        return "[" + index + "]" + " = " + mostPopulation; //формирование строки
    }

    /**
     * Этот метод сортирует список городов справочника согласно пункту 3 меню.
     *
     * @return - возращает список городов отсортированный в алфавитном порядке по федеральному округу и
     * наименованию города внутри федерального округа с учётом регистра
     */

    public static List<City> getSortForDistrictAndNameCities() {
        List<City> result = new ArrayList<>(getAllCities());
        /*Сортировка по названию федерального округа и по наименованию внутри федерального округа
        с учётом регистра*/
        result.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        return result;
    }

    /**
     * Это метод реализующий меню приложения в консоли:
     * "1 - write all cities" - отображает все данные, всего списка городов по порядку справочника.
     * "2 - sort for Name" - отображает все данные, всего списка городов отсортированные по наименованию в
     * алфавитном порядке без учёта регистра.
     * "3 - sort for District and Name" - отображает все данные, всего списка городов отсортированные
     * в алфавитном порядке по федеральному округу и наименованию города внутри федерального округа с учётом
     * регистра.
     * "4 - get most population city" - отображает индекс и количество жителей города с наибольшей численностью
     * населения.
     * "5 - get list regions" - отображает список регионов и количество городов в регионе.
     * "6 - exit" - завершение работы приложения.
     */

    public static void listenIn() {
        boolean running = true; // выключатель приложения

        Scanner scanner = new Scanner(System.in);
        while (running) {
            // формирование меню
            System.out.println("1 - write all cities\n2 - sort for Name\n" +
                    "3 - sort for District and Name\n4 - get most population city\n" +
                    "5 - get list regions\n6 - exit");
            System.out.print("Write sign: ");

            int temp = 0;

            try {
                temp = Integer.parseInt(scanner.next()); // если вводят невалидные значения
            } catch (Exception e) {
                System.out.println("\nWrong sign try again\n");
            }

            if (temp == 1) { //отображение всего списка городов в порядке справочника
                printList(getAllCities());
                System.out.println();
                continue;
            }
            if (temp == 2) { //отображение отсортированного по наименованию города списка без учёта регистра
                printList(getSortNameCities());
                System.out.println();
                continue;
            }
            //отображение отсортированного по названию федерального округа и наименованию города
            // с учётом регистра списка
            if (temp == 3) {
                printList(getSortForDistrictAndNameCities());
                System.out.println();
                continue;
            }
            if (temp == 4) {// отображение индекса и населения города с максимальным населением
                System.out.println(getMostPopulationCity());
                System.out.println();
                continue;
            }
            if (temp == 5) {// отображение списка областей и количества городов в них
                System.out.println(getListOfRegions());
                continue;
            }
            if (temp == 6)//выход из приложения
                running = false;
        }
    }

    /**
     * Этот метод сортирует список городов согласно пункту 2 меню.
     *
     * @return - возвращает список городов отсортированных по наименованию без учёта регистра.
     */

    public static List<City> getSortNameCities() {
        List<City> result = new ArrayList<>(getAllCities());
        result.sort((n1, n2) -> n1.getName().compareToIgnoreCase(n2.getName())); //сортировка без учёта регистра
        return result;
    }

    /**
     * Этот метод возвращает список городов справочника.
     *
     * @return - возвращает список всех городов справочника в порядке согласно номера записи.
     */

    public static List<City> getAllCities() {
        return new ArrayList<>(City.getCities().values());
    }

    /**
     * Этот метод определяет количество городов в каждой области.
     *
     * @return - возвращает строку, в которой отображается имена областей и соответствующее количество городов.
     */

    public static String getListOfRegions() {
        /* создание объекта для подсчёта количества городов в области ключ -  имя области,
        значение - количество городов */
        Map<String, Integer> regions = new HashMap<>();
        Object[] cities = getAllCities().toArray(); //создание массива объектов City
        for (Object o : cities) {
            City city = (City) o;
            String temp = city.getRegion();
            if (regions.containsKey(temp)) { // если в контейнере уже есть ключ с названием области, то
                regions.put(temp, regions.get(city.getRegion()) + 1); // увеличить значение на 1
            } else {
                // если ключа с таким именем нет, то добавить ключ с названием области и значение равное 1
                regions.put(city.getRegion(), 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        regions.forEach((x, y) -> sb.append(x).append(" - ").append(y).append("\n"));
        return sb.toString();
    }

    /**
     * Это метод считывает считывает данные справочника и заполняет Map cities данными.
     */

    public static void readData() {
        File file = new File("/Users/kasirinpavel/Desktop/Projects/src/City.txt");

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(";"); //символ разделителя

            while (scanner.hasNext()) {
                //считывание значений параметров объекта City и индекса записи справочника
                int index = scanner.nextInt();
                String name = scanner.next();
                String region = scanner.next();
                String district = scanner.next();
                int population = scanner.nextInt();
                int foundation = scanner.nextInt();
                scanner.nextLine();
                //добавление индекса записи и объекта City
                City.getCities().put(index, new City(name, region, district, population, foundation));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }

    /**
     * Это метод считывает считывает данные справочника и заполняет Map cities данными.
     * @param fromFile файл, из которого считываются данные.
     */

    public static void readData(File fromFile) {

        try (Scanner scanner = new Scanner(fromFile)) {
            scanner.useDelimiter(";"); //символ разделителя

            while (scanner.hasNext()) {
                //считывание значений параметров объекта City и индекса записи справочника
                int index = scanner.nextInt();
                String name = scanner.next();
                String region = scanner.next();
                String district = scanner.next();
                int population = scanner.nextInt();
                int foundation = scanner.nextInt();
                scanner.nextLine();
                //добавление индекса записи и объекта City
                City.getCities().put(index, new City(name, region, district, population, foundation));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}
