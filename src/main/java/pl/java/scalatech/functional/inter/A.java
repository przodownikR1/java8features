package pl.java.scalatech.functional.inter;

import java.math.BigDecimal;

public interface A {
  default String fooSum(BigDecimal x, BigDecimal y){
      return "sum : " + x.add(y);
  }
}
