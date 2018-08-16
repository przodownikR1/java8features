package pl.java.scalatech.language_feature.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class EffectivelyFinalTest {

    public static List<String> todo(List<String> input) {
        List<String> result = null;
        if (input != null) {
            result = new ArrayList<>(input.size());
            // input.forEach(e -> result.add(e)); // compile error here
        }

        return result;
    }

    public static List<String> todo2(List<String> input) {
        return Optional.ofNullable(input)
                .orElse(new ArrayList<String>())
                .stream().collect(Collectors.toList());
    }

    public static List<String> todo3(List<String> input) {
        if (input == null)
            return Lists.newArrayList();
        return input.stream().collect(Collectors.toList());
    }
}
