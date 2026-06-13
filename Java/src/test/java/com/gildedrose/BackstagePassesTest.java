package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackstagePassesTest {
    @Test
    void backstagePassesRegisterTest() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(15, app.items[0].sellIn);
        assertEquals(20, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreaseTestOneDay() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void backstagePassesSellInDecreaseTestOneDay() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
    }

    @Test
    void backstagePassesSellInDecreaseTestMultipleDays() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        for(int i = 10; i > 0; i--) {
            app.updateQuality();
        }
        assertEquals(5, app.items[0].sellIn);
    }

    @Test
    void backstagePassesQualityZeroSellInNegativeTest() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 14, 20)};
        GildedRose app = new GildedRose(items);
        for(int sellIn = 15; sellIn > 0; sellIn--){
            app.updateQuality();
        }
        //sellIn < 0: quality = 0
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityZeroSellInZeroTest() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0)};
        GildedRose app = new GildedRose(items);
        for(int sellIn = 5; sellIn > 0; sellIn--){
            app.updateQuality();
        }
        //15 sellIn 1-5: +3
        assertEquals(15, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityZeroSellInZeroTest_2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0)};
        GildedRose app = new GildedRose(items);
        for(int sellIn = 5; sellIn > 0; sellIn--){
            app.updateQuality();
        }
        //10 Weil sellIn 6-10: +2
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityZeroSellInZeroTest_3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 30, 0)};
        GildedRose app = new GildedRose(items);
        for(int sellIn = 20; sellIn > 0; sellIn--){
            app.updateQuality();
        }
        //20 Weil sellIn > 10: +1
        assertEquals(20, app.items[0].quality);
    }

    @Test
    void backstagePassesMaxQuality() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 70, 0)};
        GildedRose app = new GildedRose(items);
        for(int sellIn = 70; sellIn > 0; sellIn--){
            app.updateQuality();
        }
        //Max quality ist 50
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassesMaxQuality_2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 35, 0)};
        GildedRose app = new GildedRose(items);
        for(int sellIn = 35; sellIn > 0; sellIn--){
            app.updateQuality();
        }
        //Max quality ist 50
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseByOneWhenMoreThanTenDaysLeft() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseByTwoWhenTenDaysLeft() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void backstagePassesIncreaseByThreeWhenFiveDaysLeft() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(23, app.items[0].quality);
    }

}

