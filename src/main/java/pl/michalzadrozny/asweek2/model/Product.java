package pl.michalzadrozny.asweek2.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public class Product {

    private String name;
    private BigDecimal price;

    public Product(String name) {
        this.name = name;
        this.price = BigDecimal.valueOf(Math.random()).multiply(new BigDecimal(250)).add(new BigDecimal(50)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return name + ": " + price +"zł";
    }
}
