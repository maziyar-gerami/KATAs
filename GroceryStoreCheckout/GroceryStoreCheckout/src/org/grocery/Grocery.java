package org.grocery;

import java.util.List;

class Grocery {

    List<Item> items;
    int tax;

    public Grocery(List<Item> items, int tax) {
        this.items = items;
        this.tax = tax;
    }

    public double checkout() {
        int sum = items.stream()
                .map(e ->
                        (e.discount != null)
                                ? e.price - e.price * e.discount()/100
                                : e.price
                ).mapToInt(Integer::intValue).sum();
        return sum - (double) (sum * tax) / 100;
    }

    public record Item(String name, int price, Integer discount) {
    }
}
