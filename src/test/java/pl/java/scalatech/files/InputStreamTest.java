package pl.java.scalatech.files;

import static java.util.stream.Collectors.collectingAndThen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.assertj.core.api.StrictAssertions;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputStreamTest {
    @Test
    public void shouldTryWithResourcesWork() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            StrictAssertions.assertThat(br.readLine()).isEqualTo("przodownik");
        }
    }

    @Test
    public void shouldLambaBuffered() throws IOException {
        StrictAssertions.assertThat(processFile(r -> r.readLine(), "data.txt")).isEqualTo("przodownik");
    }

   /* @Test
    public void shouldLambaBuffered2() throws IOException {

        String result = processFile(r -> r.lines().collect(Collectors.joining("\n ")), "data.txt");
        log.info("result {}", result);
        String reverse = processFile(r -> {
            List<String> lines = r.lines().collect(Collectors.toList());
            lines.stream().collect(collectingAndThen(Collectors.toList(), reverse));
            return null;
        }, "data.txt");

        log.info("reverse {}", reverse);

    }*/

    public Function<List<String>, List<String>> reverse = t -> {
        Collections.reverse(t);
        return t;
    };

    public <T> Collector<T, ?, List<T>> toListReversed() {
        return Collectors.collectingAndThen(Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        });
    }

    public String processFile(BufferedReaderProcessor p, String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return p.process(br);
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader r) throws IOException;
    }
}
