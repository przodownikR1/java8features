package pl.java.scalatech.referenceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Simple {

    private String name;
    private int value;
    private static String login = "Login X";
    
    public static String sayLogin(){
        return login ;
    }
    
}
