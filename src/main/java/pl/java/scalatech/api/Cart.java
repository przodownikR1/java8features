package pl.java.scalatech.api;

import java.util.List;

import org.assertj.core.util.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class Cart {
  List<Item> items =  Lists.newArrayList();
}
