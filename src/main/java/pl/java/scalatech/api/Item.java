package pl.java.scalatech.api;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Builder
@Getter
public class Item {
    private final String name;
    private final int quantity;
    private final BigDecimal price;

}
