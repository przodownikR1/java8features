package pl.java.scalatech.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class FileOper1 {
       
    @Test
    public void shouldConvertWork()
    {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        log.info("+++ {}",converted);
    }
    
    public int sumFile(final Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            return lines.flatMap(Pattern.compile(",")::splitAsStream) //
                    .mapToInt(Integer::parseInt) //
                    .sum();
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
