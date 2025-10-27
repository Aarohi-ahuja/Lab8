package com.example.lab8;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList mockCityList() {
        return new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void hasCityTest() {
        CustomList list = mockCityList();
        City e = new City("Estevan", "SK");
        assertFalse(list.hasCity(e));

        list.addCity(e);
        assertTrue(list.hasCity(e));
    }

    @Test
    public void deleteCity_removesCity() {
        CustomList list = mockCityList();
        City e = new City("Estevan", "SK");
        City r = new City("Regina", "SK");

        list.addCity(e);
        list.addCity(r);
        assertEquals(2, list.getCount());

        list.deleteCity(e);
        assertEquals(1, list.getCount());
        assertFalse(list.hasCity(e));
        assertTrue(list.hasCity(r));
    }

    @Test(expected = IllegalArgumentException.class)
    public void deleteCity_throwsIfMissing() {
        CustomList list = mockCityList();
        City e = new City("Estevan", "SK");

        list.deleteCity(e);
    }
    @Test
    public void addCity_incrementsCount() {
        CustomList list = new CustomList(null, new ArrayList<City>());
        int before = list.getCount();

        list.addCity(new City("Estevan", "SK"));

        assertEquals(before + 1, list.getCount());
    }
    @Test
    public void getCount_returnsSize() {
        CustomList list = new CustomList(null, new ArrayList<City>());
        assertEquals(0, list.getCount());

        list.addCity(new City("Estevan", "SK"));
        list.addCity(new City("Regina", "SK"));
        assertEquals(2, list.getCount());
    }


}
