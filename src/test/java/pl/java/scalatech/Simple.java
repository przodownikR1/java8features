package pl.java.scalatech;

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
    private boolean game;

    public Simple(String name){
        this.name = name;
    }
    public Simple(String name,int value){
        this.name = name;
        this.value = value;
    }
    
    
    public static String sayLogin(){
        return login ;
    }
    
}
