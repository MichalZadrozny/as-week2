package pl.michalzadrozny.asweek2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.michalzadrozny.asweek2.model.Product;
import pl.michalzadrozny.asweek2.service.ShopService;

@SpringBootApplication
public class AsWeek2Application {

    ShopService shopService;

    @Autowired
    public AsWeek2Application(ShopService shopService) {
        this.shopService = shopService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AsWeek2Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void show() {
        Product[] array = new Product[5];

        for (int i = 0; i < 5; i++) {
            array[i] = new Product("Product" +(i+1));
            shopService.addToBucket(array[i]);

            System.out.println(array[i]);
        }

        shopService.pay();
    }

}
