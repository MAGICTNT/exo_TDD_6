package fr.maxime.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class ShopTest {
    private Shop shop;
    private Product product;
    private String TYPE_NORMAL = "normal";
    private String TYPE_BRIE = "brie";
    private String TYPE_DAIRY = "dairy";
    private String NAME_NORMAL = "Normal Product";
    private String NAME_BRIE = "Brie";
    private String NAME_DAIRY = "Dairy Product";


    @Test
    public void testUpdateNormalProductBeforeSellInDate() {
        int sellIn = 10;
        int sellInExpected = 9;
        int quantity = 20;
        int quantityExpected = 19;

        product = new Product(TYPE_NORMAL, NAME_NORMAL, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));


        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateNormalProductOnSellInDate() {
        int sellIn = 0;
        int sellInExpected = -1;
        int quantity = 20;
        int quantityExpected = 18;

        product = new Product(TYPE_NORMAL, NAME_NORMAL, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));


        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateNormalProductAfterSellInDate() {
        int sellIn = -1;
        int sellInExpected = -2;
        int quantity = 20;
        int quantityExpected = 18;

        product = new Product(TYPE_NORMAL, NAME_NORMAL, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));


        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateNormalProductQualityNeverNegative() {
        int sellIn = 10;
        int sellInExpected = 9;
        int quantity = 0;
        int quantityExpected = 0;

        product = new Product(TYPE_NORMAL, NAME_NORMAL, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));


        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateBrieProductBeforeSellInDate() {
        int sellIn = 10;
        int sellInExpected = 9;
        int quantity = 10;
        int quantityExpected = 11;

        product = new Product(TYPE_BRIE, NAME_BRIE, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));

        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateBrieProductOnSellInDate() {
        int sellIn = 0;
        int sellInExpected = -1;
        int quantity = 10;
        int quantityExpected = 12;

        product = new Product(TYPE_BRIE, NAME_BRIE, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));

        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateBrieProductQualityMaxAt50() {
        int sellIn = 10;
        int sellInExpected = 9;
        int quantity = 50;
        int quantityExpected = 50;

        product = new Product(TYPE_BRIE, NAME_BRIE, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));

        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateDairyProductBeforeSellInDate() {
        int sellIn = 10;
        int sellInExpected = 9;
        int quantity = 20;
        int quantityExpected = 18;

        product = new Product(TYPE_DAIRY, NAME_DAIRY, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));

        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateDairyProductOnSellInDate() {
        int sellIn = 0;
        int sellInExpected = -1;
        int quantity = 20;
        int quantityExpected = 16;

        product = new Product(TYPE_DAIRY, NAME_DAIRY, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));

        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateDairyProductAfterSellInDate() {
        int sellIn = -1;
        int sellInExpected = -2;
        int quantity = 20;
        int quantityExpected = 16;

        product = new Product(TYPE_DAIRY, NAME_DAIRY, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));

        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }

    @Test
    public void testUpdateDairyProductQualityNeverNegative() {
        int sellIn = 10;
        int sellInExpected = 9;
        int quantity = 1;
        int quantityExpected = 0;

        product = new Product(TYPE_DAIRY, NAME_DAIRY, sellIn, quantity);
        shop = new Shop(Arrays.asList(product));

        shop.update(product);

        assertEquals(sellInExpected, product.getSellIn());
        assertEquals(quantityExpected, product.getQuality());
    }
}
