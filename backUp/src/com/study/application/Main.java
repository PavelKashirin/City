package com.study.application;

import com.study.service.MenuService;


/**
 * <h1>Разминочное задание</h1>
 * Программа Main реализует приложение, которое через консоль запрашивает
 * ввод данных согласно предыдущего меню.
 * <p/>
 * После ввода данных и нажатия Enter программа выводит данные справочника городов,
 * согласно меню.
 *
 * @ author Pavel Kashirin
 * @ версия 1.0
 * @ от 2021-05-18
 */
public class Main {

    /**
     * Это основной метод, внутри метода создается объект файл, который передается
     * параметром методу readData(file), далее вызывается метод readData(file)
     * и listenIn().
     *
     * @param args Не используется.
     */
    public static void main(String[] args) {

        MenuService.readData(); //Считывание данных справочника городов из текстового файла
        MenuService.listenIn(); // Запуск метода реализующего меню приложения
    }
}
