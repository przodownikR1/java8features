package pl.java.scalatech.boxer;

import org.junit.Before;

import pl.java.scalatech.functional.bean.Boxer;
import pl.java.scalatech.functional.bean.Country;
import pl.java.scalatech.functional.bean.Weight;

public class LambdaFeatureTest {
    Country poland = Country.builder().name("Poland").build();
    Country usa = Country.builder().name("USA").build();
    Country ukraine = Country.builder().name("UKRAINE").build();
    Country germany = Country.builder().name("GERMANY").build();
    Country england = Country.builder().name("ENGLAND").build();
    Country philipines = Country.builder().name("PHILIPHINES").build();
  /*  Boxer andrzejGolota  = Boxer.builder().country(poland).draw(3).lost(8).win(43).name("Andrzej Golota").nick("golota").weight(Weight.Ciezka).build();
    Boxer tomaszAdamek  = Boxer.builder().country(poland).draw(0).lost(2).win(36).name("Tomasz Adamek").nick("goral").weight(Weight.Ciezka).build();
    Boxer arturSzpilka  = Boxer.builder().country(poland).draw(0).lost(1).win(25).name("Artur Szpilka").nick("szpila").weight(Weight.Ciezka).build();
    Boxer cygan  = Boxer.builder().country(poland).draw(0).lost(1).win(15).name("Dawid Kostecki").nick("gypsy").weight(Weight.PolCiezka).build();*/
    
    
    @Before
    private void init(){
       
        
    }
    
}
