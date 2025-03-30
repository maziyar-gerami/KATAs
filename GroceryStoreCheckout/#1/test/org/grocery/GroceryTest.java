package org.grocery;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GroceryTest {

    @Test
    public void testGrocery_whenItemsWithoutDiscount() {
        List<Grocery.Item> items = List.of(new Grocery.Item("Apple", 1, null),
                new Grocery.Item("Banana", 2, null),
                new Grocery.Item("Milk", 7, 0));

        Grocery grocery = new Grocery(items, 10);
        assertEquals(9.0, grocery.checkout(), 0);
    }

    @Test
    public void testGrocery_whenItemsWithDiscount() {
        List<Grocery.Item> items = List.of(new Grocery.Item("Apple", 1, null),
                new Grocery.Item("Banana", 2, 50),
                new Grocery.Item("Milk", 7, 0));

        Grocery grocery = new Grocery(items, 10);
        assertEquals(8.1, grocery.checkout(), 0);
    }
}
