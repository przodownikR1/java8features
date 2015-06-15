package pl.java.scalatech.functional.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private Long id;
    private String name;
}
