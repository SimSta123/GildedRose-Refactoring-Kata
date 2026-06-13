package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void normalItemSellInDecreases() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void normalItemQualityDegradesTwiceAfterSellDate() {
        Item[] items = new Item[]{new Item("foo", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    void normalItemQualityDoesNotBecomeNegativeAfterSellDate() {
        Item[] items = new Item[]{new Item("foo", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void normalItemNameDoesNotChange() {
        Item[] items = new Item[]{new Item("foo", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

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
