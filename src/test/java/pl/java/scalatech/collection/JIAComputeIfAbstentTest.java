package pl.java.scalatech.collection;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Range;

public class JIAComputeIfAbstentTest {
    final Map<Range, Integer> numberOfNodes = new HashMap<>();
    {

    }

    Integer computeNumberOfNodesUsingCacheOld(Range range) {
        Integer result = numberOfNodes.get(range);
        if (result != null) {
            return result;
        }
        result = computeNumberOfNodes(range);
        numberOfNodes.put(range, result);
        return result;
    }

    private Integer computeNumberOfNodes(Range range) {
        // TODO
        return 1;
    }

    Integer computeNumberOfNodesUsingCache(Range range) {
        return numberOfNodes.computeIfAbsent(range, this::computeNumberOfNodes);
    }
}
