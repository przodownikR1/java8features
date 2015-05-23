package pl.java.scalatech.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Address{
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
