package pl.java.scalatech.guava;

import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileOperationTest {

    private static File file;

    @BeforeClass
    public static void init() {
        file = new File("src/test/resources/strings.txt");
    }

    @Test
    public void shouldReadFileFromFiles() throws IOException {
        ImmutableList<String> lines = Files.asCharSource(file, Charsets.UTF_8).readLines();
        assertThat(lines).hasSize(5);

    }

    @Test
    public void shouldCRCGenerate() throws IOException {
        HashCode hash = Files.asByteSource(file).hash(Hashing.sha1());
        log.info("hash : {}", hash);
    }
}
