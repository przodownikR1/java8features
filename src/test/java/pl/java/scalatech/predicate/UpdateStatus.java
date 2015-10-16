package pl.java.scalatech.predicate;
@FunctionalInterface
public interface UpdateStatus {

     Factor updateStatus(Long id, Process process);
  
}
