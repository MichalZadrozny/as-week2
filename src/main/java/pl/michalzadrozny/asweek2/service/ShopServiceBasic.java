package pl.michalzadrozny.asweek2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.michalzadrozny.asweek2.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Profile("Basic")
@Service
public class ShopServiceBasic implements ShopService {

    private List<Product> listOfProducts;
    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    public ShopServiceBasic() {
        this.listOfProducts = new ArrayList<>();
    }

    public void addToBucket(Product product) {
        listOfProducts.add(product);
    }

    public BigDecimal sumTheBucket() {
        BigDecimal sum = new BigDecimal(0);

        for (Product product : listOfProducts) {
            sum = sum.add(product.getPrice());

            logger.info("Price of "+product.getName()+": "+product.getPrice());
        }
        logger.info("Sum: "+sum);

        return sum;
    }

    public void pay() {
        System.out.println("Do zapłaty: " + sumTheBucket());
    }

}
