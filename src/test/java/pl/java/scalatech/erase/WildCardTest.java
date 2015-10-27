package pl.java.scalatech.erase;

import java.util.ArrayList;

import org.junit.Test;

import com.google.common.collect.Lists;

public class WildCardTest {
@Test
public void shouldWildCardWork1() {
    ArrayList<?> mysteryList = Lists.newArrayList();
    Object o = mysteryList.get(0);
}

@Test
public void shouldWildCardWork2() {
    ArrayList<?> mysteryList = Lists.newArrayList();
  // mysteryList.add(new Object());
   // List<Object> objects = new ArrayList<String>();
}

}
