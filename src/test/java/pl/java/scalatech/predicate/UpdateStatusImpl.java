package pl.java.scalatech.predicate;

import java.util.function.Predicate;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class UpdateStatusImpl implements UpdateStatus{
    
    private final @NonNull Db db ;
    
    
    
    @Override
    public Factor updateStatus(Long id, Process process) {
       Predicate<Factor>  p = o -> process==o.getState();
       db.getFactors().stream().findFirst().get().setState(process);
       return db.getFactors().stream().filter(p.and(a->a.getId()==id)).findFirst().orElseThrow(IllegalArgumentException::new);
       
    }

}
