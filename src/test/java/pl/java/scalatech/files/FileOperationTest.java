package pl.java.scalatech.files;

import static org.assertj.core.api.StrictAssertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.Files;

@Slf4j
public class FileOperationTest {
    //private FileWriter fileWriter = new FileWriter();
    private File output;
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() throws IOException {
        output = temporaryFolder.newFolder("temp").toPath().resolve("test.txt").toFile();
    }

    @Test
    public void shouldResolvePath() {
        log.info(" {}", resolvePath("test"));
    }

    private String resolvePath(String folder) {
        return temporaryFolder.getRoot().toPath().resolve(folder).toString();
    }

    @Test
    public void shouldWriteString2File() throws IOException {

        log.info("{}", output.getAbsolutePath());
        Files.write("przodownik", output, Charset.defaultCharset());
        ;
        String result = Files.readFirstLine(output, Charset.defaultCharset());
        assertThat(result).isEqualTo("przodownik");

    }

    @Test
    public void shouldWriteAsCharSink() throws IOException {
        String expectedValue = "slawek";
        CharSink sink = Files.asCharSink(output, Charsets.UTF_8);
        sink.write(expectedValue);
        String result = Files.toString(output, Charsets.UTF_8);
        assertThat(result).isEqualTo(expectedValue);
    }
}
