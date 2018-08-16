package pl.java.scalatech.predicate;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import lombok.Data;

@Data
public class Db {

    private List<Factor> factors = newArrayList();

}
