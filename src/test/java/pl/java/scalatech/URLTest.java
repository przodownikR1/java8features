package pl.java.scalatech;

import static org.fest.assertions.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.google.common.base.Charsets;

@Slf4j
public class URLTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    private File fileTemp;

    @Before
    public void initStep() throws IOException {
        testFolder.newFolder("test_");
        fileTemp = testFolder.newFile("t.txt");
        log.info("file :  {}", file.getAbsolutePath());

    }

    private static File file;
    private URI fileLocation;

    @BeforeClass
    public static void init() {
        file = new File("src/test/resources/strings.txt");
    }

    @Test
    public void shouldFilelocationExists() {
        log.info("{}", fileLocation);
    }

    @Test
    public void shouldURLConnect() throws IOException {
        URL url = new URL("http://przewidywalna-java.blogspot.com/");
        StringBuilder fileContent;
        try (InputStream in = url.openStream(); BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, Charsets.UTF_8));) {
            fileContent = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                fileContent.append(line);
                line = bufferedReader.readLine();
            }
        }
        assertThat(fileContent.toString().contains("przewidywalna-java.blogspot.com/search/label")).isTrue();
    }
}
