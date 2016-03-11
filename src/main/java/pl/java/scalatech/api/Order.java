package pl.java.scalatech.api;
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
public class Order {
  private Cart cart;
}
