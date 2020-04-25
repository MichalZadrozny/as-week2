package pl.michalzadrozny.asweek2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.michalzadrozny.asweek2.BasicValues;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Profile("Plus")
@Service
public class ShopServicePlus extends ShopServiceBasic {

    protected BasicValues basicValues;

    @Autowired
    public ShopServicePlus(BasicValues basicValues) {
        this.basicValues = basicValues;
    }

    public BigDecimal applyTax(BigDecimal price) {
        logger.info("Before applying "+basicValues.getTax()+"% tax: " +price);
        price = price.add(price.multiply(basicValues.getTax().divide(new BigDecimal(100)))).setScale(2, RoundingMode.HALF_UP);
        logger.info("After applying "+basicValues.getTax()+"% tax: " +price);
        return price;
    }

    public void pay() {
        System.out.println("Do zapłaty po doliczeniu podatku vat " + basicValues.getTax() + "%: " + applyTax(sumTheBucket()));
    }

}
