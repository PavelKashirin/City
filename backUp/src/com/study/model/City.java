package com.study.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Это модель города, используется как значение в Map cities в классе Main.
 */
public class City {
    private final String name; //Наименование города
    private final String region; //Регион
    private final String district; //Федеральный округ
    private final int population; //Количество жителей;
    private final int foundation; //Дата основания или первое упоминание

    /**
     * Это объект Мар хранящий информацию справочника городов, где ключ - это порядковый номер справочника,
     * а значение это объект City.
     */

    private static final Map<Integer, City> cities = new HashMap<>();

    public static Map<Integer, City> getCities() {
        return cities;
    }

    public City(String name, String region, String district, int population, int foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && foundation == city.foundation && Objects.equals(name, city.name) && Objects.equals(region, city.region) && Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, district, population, foundation);
    }
}
