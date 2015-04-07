package pl.java.scalatech.guava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

/**
 * @author Sławomir Borowiec 
 * Module name : java8features
 * Creating time :  7 kwi 2015 21:56:35
 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {
  private String login;
}
