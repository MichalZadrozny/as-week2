package pl.michalzadrozny.asweek2.service;

import pl.michalzadrozny.asweek2.model.Product;

import java.math.BigDecimal;

public interface ShopService {

    void addToBucket(Product product);

    BigDecimal sumTheBucket();

    void pay();

}
