package pl.java.scalatech.referenceType;

import java.math.BigDecimal;

import pl.java.scalatech.refMet.UserSpec;

interface UserCreator<P extends UserSpec> {
    P create(String name, BigDecimal salary);
}