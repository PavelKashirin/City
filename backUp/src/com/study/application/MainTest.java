package com.study.application;

import com.study.model.City;
import com.study.service.MenuService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Before
    public void setUp() {
        File file = new File("/Users/kasirinpavel/Desktop/backUp/src/TestCity.txt");

        MenuService.readData(file);
    }

    @Test
    public void getMostPopulationCity() {
        String expected = "[1] = 144246";
        Assert.assertEquals(expected, MenuService.getMostPopulationCity());
    }

    @Test
    public void getMostPopulationCity_NO_NULL() {
        Assert.assertNotNull(MenuService.getMostPopulationCity());
    }

    @Test
    public void getSortForDistrictAndNameCities() {
        List<City> expected = MenuService.getSortForDistrictAndNameCities();

        List<City> actual = new ArrayList<>();
        actual.add(new City("Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830));
        actual.add(new City("горно-Алтайск", "Алтай", "Сибирский", 56928, 1830));
        actual.add(new City("Майкоп", "Адыгея", "Южный", 144246, 1857));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSortForDistrictAndNameCities_NO_NULL() {
        Assert.assertNotNull(MenuService.getSortForDistrictAndNameCities());
    }

    @Test
    public void getSortNameCities() {
        List<City> expected = MenuService.getSortForDistrictAndNameCities();

        List<City> actual = new ArrayList<>();
        actual.add(new City("Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830));
        actual.add(new City("горно-Алтайск", "Алтай", "Сибирский", 56928, 1830));
        actual.add(new City("Майкоп", "Адыгея", "Южный", 144246, 1857));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSortNameCities_NO_NULL() {
        Assert.assertNotNull(MenuService.getSortNameCities());
    }

    @Test
    public void getAllCities() {
        List<City> result = new ArrayList<>();
        result.add(new City("Майкоп", "Адыгея", "Южный", 144246, 1857));
        result.add(new City("Горно-Алтайск", "Алтай", "Сибирский", 56928, 1830));
        result.add(new City("горно-Алтайск", "Алтай", "Сибирский", 56928, 1830));

        Assert.assertEquals(MenuService.getAllCities(), result);
    }

    @Test
    public void getAllCities_NO_NULL() {
        List<City> expected = MenuService.getAllCities();

        Assert.assertNotNull(expected);
    }

    @Test
    public void getListOfRegions() {
        String expected = MenuService.getListOfRegions();
        String actual = "Адыгея - 1\nАлтай - 2\n";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getListOfRegions_NO_NULL() {
        Assert.assertNotNull(MenuService.getListOfRegions());
    }
}