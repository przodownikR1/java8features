package pl.java.scalatech.design_pattern.liskov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
class Rectangle {
    protected int width;
    protected int height;

    
    public int getArea(){
        log.info("h :{}  , w: {}",height,width);  
        return width * height;
    }   
}
