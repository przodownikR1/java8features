package pl.java.scalatech.closeResource;

import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Resource {
  
  private Resource(){
      log.info("create resource");
  }
  public Resource operationOne(){
      log.info("operation one");
      return this;
  }
  public Resource operationTwo(){
      log.info("operation one");
      return this;
  }
  
  private void close(){
      log.info("close resource...");
  }
  
  public static void use(Consumer<Resource> cons){
      Resource resource = new Resource();
      try{
          cons.accept(resource );
      }finally{
          resource.close();
      }
  }
}
