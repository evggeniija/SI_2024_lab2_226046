package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {


    private List<Item> createList(Item... elems) {
        return new ArrayList<>(Arrays.asList(elems));
    }
    @Test
    void EveryBranchTest()
    {
        RuntimeException ex;
        //Test sluchaj 1:
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 600));
        assertTrue(ex.getMessage().contains("allItems list can't be null!")); //null
        //Test sluchaj 2:
        assertTrue(SILab2.checkCart(createList(),600));
        //Test sluchaj 3:
        Item itemOne = new Item("itemOne","2803", 280, 50);
        Item itemWNull = new Item("null", "2sh7", 156, 18);
        //Item noname = new Item("", "42a5c6", 300, 0);
        List<Item> items = createList(itemOne, itemWNull);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, 600));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
        //Test sluchaj 4:
        Item itemOne1 = new Item("itemOne1","365", 228, 20);
        Item itemTwo1 = new Item("itemTwo1", "null", 90, 9);
        List<Item> items1 = createList(itemOne1,itemTwo1);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items1, 600));
        //Test sluchaj 5:
        Item itemOne2 = new Item("itemOne2","02132", 495, 13);
        Item itemTwo2 = new Item("itemTwo2", "4589", 157, 0);
        List<Item> items2 = createList(itemOne2,itemTwo2);
        assertFalse(SILab2.checkCart(items2,600));
    }
    @Test
    void MultipleConditionsTest() {
        // Sluchaj: T T T
        List<Item> items4 = createList(new Item("one","0723", 300, 0.19f));
        assertTrue(SILab2.checkCart(items4, 490));
        // Sluchaj: T  T  F
        List<Item> items3 = createList(new Item("two","551724", 500, 0.25f));
        assertFalse(SILab2.checkCart(items3, 90));
        // Sluchaj: T F X
        List<Item> items2 = createList(new Item("three","33", 350, 0.0f));
        assertFalse(SILab2.checkCart(items2, 250));
        // Sluchaj: F X  X
        List<Item> items1 = createList(new Item("four","63521", 290, 0.0f));
        assertFalse(SILab2.checkCart(items1, 180));
    }


}