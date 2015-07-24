package pl.java.scalatech.formatter;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

@Slf4j
public class BigDecimalTest {
    @Test
    public void shouldFormatterWork() {
        double decimal = 7.27467;
        log.info("The test number: {}", decimal);
        int decimalPlaces = 3; // the scale for the decimal

        BigDecimal bd = new BigDecimal(decimal);

        // set the scale and round up if >= 0.5
        bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        double bigDecimal = bd.doubleValue();
        log.info("BigDecimal rounded in 3rd decimal: {}", bigDecimal);

        DecimalFormat numFormat;
        String number;

        // 2 digits before decimal point and then 2 digits (rounded)
        numFormat = new DecimalFormat("000.##");
        number = numFormat.format(-15.567);
        log.info("1. DecimalFormat with .: {}", number);

        // string '$' in front of the number
        numFormat = new DecimalFormat("'$'00.####");
        number = numFormat.format(15.567);
        log.info("2. DecimalFormat with '$': {}", number);

        // use of , to group numbers
        numFormat = new DecimalFormat("#,###,###");
        number = numFormat.format(1556789);
        log.info("3. DecimalFormat with ,: {}", number);

        // use of % for percentage
        numFormat = new DecimalFormat("%");
        number = numFormat.format(0.15);
        log.info("4. DecimalFormat with percentage: {}", number);

        // 2 digits before decimal point and 2 digits after
        numFormat = new DecimalFormat("00.00");
        number = numFormat.format(-15.567);
        log.info("5. DecimalFormat with 4 digits: {}", number);

        // left part of decimal number
        numFormat = new DecimalFormat("##");
        number = numFormat.format(156.567);
        log.info("6. DecimalFormat with no decimal part: {}", number);

        // 5 or less digits in the decimal part
        numFormat = new DecimalFormat(".#####");
        number = numFormat.format(1890.567);
        log.info("7. DecimalFormat with 5 or less digits (in decimal part): {}", number);

        // string 'JCG' in front of the number
        numFormat = new DecimalFormat("'JCG'000.#");
        number = numFormat.format(15.567);
        log.info("8. DecimalFormat with 'JCG': {} ", number);
    }

}
