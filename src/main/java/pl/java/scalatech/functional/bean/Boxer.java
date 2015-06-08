package pl.java.scalatech.functional.bean;

import java.util.List;

import lombok.Data;
import lombok.experimental.Builder;

@Data
@Builder
public class Boxer {
  private Long id;  
  private String name;
  private String nick;
  private Weight weight;
  private Country country;
  private List<Boxer> opponent;
  private int lost;
  private int win;
  private int draw;
  
}
