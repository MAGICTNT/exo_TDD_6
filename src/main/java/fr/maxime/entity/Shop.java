package fr.maxime.entity;

import java.util.List;

public class Shop {
    private List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public void update(Product product) {
        // Règle 1: je decrement sellIn
        product.setSellIn(product.getSellIn() - 1);

        // Règle 2: modifie la qualite
        switch (product.getType()) {
            case "normal": // si c'est autre chose du coup
                updateNormalProduct(product);
                break;
            case "brie": // si c'est du brie
                updateBrieProduct(product);
                break;
            case "dairy": // si c'est du lait
                updateDairyProduct(product);
                break;
            default:
                throw new IllegalArgumentException("Unknown product type: " + product.getType());
        }

        // je control que sa ne soit jamais negatif
        if (product.getQuality() < 0) {
            product.setQuality(0);
        }

        // je control le la qualité ne depasse pas 50
        if (product.getQuality() > 50) {
            product.setQuality(50);
        }
    }

    private void updateNormalProduct(Product product) {
        if (product.getSellIn() < 0) {
            product.setQuality(product.getQuality() - 2);
        } else {
            product.setQuality(product.getQuality() - 1);
        }
    }

    private void updateBrieProduct(Product product) {
        if (product.getSellIn() < 0) {
            product.setQuality(product.getQuality() + 2);
        } else {
            product.setQuality(product.getQuality() + 1);
        }
    }

    private void updateDairyProduct(Product product) {
        if (product.getSellIn() < 0) {
            product.setQuality(product.getQuality() - 4);
        } else {
            product.setQuality(product.getQuality() - 2);
        }
    }
}
