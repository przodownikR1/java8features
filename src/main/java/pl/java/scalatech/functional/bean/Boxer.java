package pl.java.scalatech.functional.bean;

import java.util.List;

import lombok.Builder;
import lombok.Data;

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
