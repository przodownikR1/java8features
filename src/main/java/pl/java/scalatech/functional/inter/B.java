package pl.java.scalatech.functional.inter;

import java.math.BigDecimal;

public interface B {
    default String fooSum(BigDecimal x, BigDecimal y){
        return "result : " + x.add(y);
    }
}
