package pl.java.scalatech.api;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {
    List<Item> items = newArrayList();
}
