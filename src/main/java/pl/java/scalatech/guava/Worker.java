package pl.java.scalatech.guava;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sławomir Borowiec
 *         Module name : java8features
 *         Creating time : 7 kwi 2015 21:56:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker {
    private String login;
}
