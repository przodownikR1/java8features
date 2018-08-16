package pl.java.scalatech.language_feature.monad;

import java.util.Optional;

import lombok.Getter;

class Car {
    @Getter
    private Optional<Insurance> insurance = Optional.of(new Insurance());

}
