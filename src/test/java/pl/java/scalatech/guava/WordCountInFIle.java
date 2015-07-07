package pl.java.scalatech.guava;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.io.Files;

@Slf4j
public class WordCountInFIle {

    private static File file;

    @BeforeClass
    public static void init() {
        file = new File("src/test/resources/strings2.txt");
    }

    @Test
    public void shouldCountDistinctWords() throws IOException {
        Stream<String> stream = java.nio.file.Files.lines(Paths.get(file.toURI()), Charset.defaultCharset());
        stream.flatMap(line -> Arrays.stream(line.trim().split(","))).distinct().forEach(t -> log.info("{}", t));

    }

    @Test
    public void shouldCountDistinctWorkGuava() throws IOException {
        Multiset<String> wordOccurrences = HashMultiset.create(Splitter.on(",").trimResults(CharMatcher.is('.')).omitEmptyStrings()
                .split(Files.asCharSource(file, Charsets.UTF_8).read()));
        log.info("+++1 : {}", wordOccurrences);

        Multiset<String> wordOccurrences2 = HashMultiset.create(Splitter.on(CharMatcher.WHITESPACE).trimResults().omitEmptyStrings()
                .split(Files.asCharSource(file, Charsets.UTF_8).read()));
        log.info("+++2:  {}", wordOccurrences2);
    }
}
