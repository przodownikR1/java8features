package pl.java.scalatech.optional.monad;

import java.util.Optional;

import lombok.Getter;

class Car {
        @Getter
        private Optional<Insurance> insurance = Optional.of(new Insurance());
        
    }

    