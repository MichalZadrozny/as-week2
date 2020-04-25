package pl.michalzadrozny.asweek2.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.michalzadrozny.asweek2.BasicValues;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Profile("Pro")
@Service
public class ShopServicePro extends ShopServicePlus {

    public ShopServicePro(BasicValues basicValues) {
        super(basicValues);
    }

    public BigDecimal applyDiscount(BigDecimal price) {

        logger.info("Before applying "+basicValues.getDiscount()+"% discount: " +price);
        price = price.subtract(price.divide(basicValues.getDiscount())).setScale(2, RoundingMode.HALF_UP);
        logger.info("After applying "+basicValues.getDiscount()+"% discount: " +price);

        return price;
    }


    public void pay() {
        System.out.println("Do zapłaty po doliczeniu podatku vat " + basicValues.getTax() + "% i zastosowaniu zniżki " + basicValues.getDiscount() + "% : " + applyDiscount(applyTax(sumTheBucket())));
    }


}
