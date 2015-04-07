package pl.java.scalatech.functional.bean;

import lombok.Data;
import lombok.experimental.Builder;

@Data
@Builder
public class Country {
  private Long id;  
  private String name;
}
