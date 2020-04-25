package pl.michalzadrozny.asweek2;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Getter
@Component
public class BasicValues {

    @Value("${value.vat}")
    private BigDecimal tax;
    @Value("${value.discount}")
    private BigDecimal discount;

}
