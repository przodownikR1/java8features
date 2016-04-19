package pl.java.scalatech.collection;

import static com.google.common.collect.Sets.newHashSet;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
class InnerContent{
    private int count;
    private  int totalCount;
    private  Set<Integer> relatedIds = newHashSet();

}