package pl.java.scalatech.language_feature.nullhandler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
class Address {
    private String city;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private String name;
    private Address address;

}
