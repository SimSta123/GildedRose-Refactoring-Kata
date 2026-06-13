package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Item_tests {

    @Test
    void nameTest() {
        Item[] items = new Item[]{new Item("sword", 0, 0)};
        GildedRose app = new GildedRose(items);
        assertEquals("sword", app.items[0].name);
    }

    @Test
    void qualityLowerThanSellInOver3Updates() {
        Item[] items = new Item[]{new Item("sword", 3, 10)};
        GildedRose app = new GildedRose(items);
        for(int i = 3; i > 0; i--) {
            app.updateQuality();
            //System.out.println("QualityLower: "+ i + ", quality: " + app.items[0].quality);
        }
        assertEquals(7, app.items[0].quality);
    }

    @Test
    void qualityHigherThanSellInOver3Updates() {
        Item[] items = new Item[]{new Item("sword", 3, 2)};
        GildedRose app = new GildedRose(items);
        for(int i = 3; i > 0; i--) {
            app.updateQuality();
            //System.out.println("Quality higher: " + i + ", quality: " + app.items[0].quality);
        }
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void qualityEqualToSellInOver3Updates() {
        Item[] items = new Item[]{new Item("sword", 3, 3)};
        GildedRose app = new GildedRose(items);
        for(int i = 3; i > 0; i--) {
            app.updateQuality();
            //System.out.println("Quality higher: " + i + ", quality: " + app.items[0].quality);
        }
        assertEquals(0, app.items[0].quality);
    }
}
