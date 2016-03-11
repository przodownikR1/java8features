package pl.java.scalatech.files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilesTest {
    @Test
    @SneakyThrows
    public void shouldFileSystemWork() {
        Path path = FileSystems.getDefault().getPath("/home/przodownik");
        Stream<Path> fstream = Files.walk(path).parallel().filter(Files::isRegularFile);
        fstream.forEach(l -> log.info("{}", l));

    }

    @Test
    @SneakyThrows
    public void shouldCountAllLinesInFileTest() {
        Path file = Paths.get("/home/przodownik/logs/springWebjavaCamp.log");
        log.info("{}", Files.lines(file).count());

        log.info("lines  : {}", countLines(file.toFile()));

    }
    @Test
    public void second(){
        Path file = Paths.get("/home/przodownik/logs/");
        
        log.info("{}",getlines(file, f -> f.toString().endsWith(".log")));
        
        
        log.info("maps {} ",returnFileWithLineCount(file, f -> f.toString().endsWith(".log")));
    }
    
    @SneakyThrows
    public List<Long> getlines(Path path , Predicate<Path> predicate) {
        List<Long> linesCounts = Files.list(path).filter(predicate).map(f -> lines(f).count())
                .collect(Collectors.toList());
        return linesCounts;
    }
    
    
    
    @SneakyThrows
    public Map<Path,Long> returnFileWithLineCount(Path path,Predicate<Path> predicate){    
    Map<Path, Long> mapFileLines = Files.list(path)
            .filter(predicate)
            .collect(Collectors.toMap(
                    Function.identity(), f -> lines(f).count()));
    return mapFileLines;
    }

    private static long calculateUniqueWords(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.flatMap(line -> Stream.of(line.split(" "))).distinct().count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    

    public static long countLines(File file) {
        try (Stream<String> lines = Files.lines(file.toPath(), Charset.defaultCharset())) {
            return lines.count();
        } catch (IOException e) {
            log.error("File not exists..");
            return 0;
        }
    }

    @Test
    public void shouldContentFileFind() {
        Path path = FileSystems.getDefault().getPath("/home/przodownik/blog/java8features/src/main");
        findContentInFiles(path, "Class");
    }

    @Test
    @SneakyThrows
    public void shouldFilesFind() {
        Path start = FileSystems.getDefault().getPath("/home/przodownik/blog/java8features/src/main");
        Stream<Path> stream = Files.find(start, 10, (path, atrrs) -> (

        path.endsWith(".java")));
        stream.forEach(l -> log.info("{}", l.getFileName()));
    }

    @SneakyThrows(value = IOException.class)
    public static Stream<String> lines(Path path) {

        return Files.lines(path);

    }

    @SneakyThrows
    public static void findContentInFiles(Path dir, String content) {
        try (Stream<Path> stream = Files.walk(dir).parallel().filter(Files::isRegularFile).peek(l -> log.info("{}", l))) {
            // log.info("+++ {}",stream.count());
            stream.filter(entry -> {
                try (Stream<String> fileStream = Files.lines(entry)) {
                    return fileStream.filter(s -> s.contains(content)).findFirst().isPresent();
                } catch (@SuppressWarnings("unused") IOException e) {
                    return false;
                }
            }

            ).forEach(p -> log.info("find : {}", p));
        }
    }
    @SneakyThrows
    @Test
    public void walkByCurrentPAth(){
        Path file = Paths.get("/home/przodownik/logs/");
        try (Stream<Path> files = Files.walk(file)) {
            log.info("{} ", files.mapToLong((path) -> {
                try (Stream lines = Files.lines(path)) {
                    return lines.count();
                } catch (Exception e) {
                    return 0l;
                }
            }).summaryStatistics());
        }
    }
    
    @Test
    public void shouldWordCount(){
        wordCount();
    }
    @SneakyThrows
    public void wordCount(){
        Path file = Paths.get("/home/przodownik/logs/springWebjavaCamp.log");
        Map<String, Long> counts = Files.lines(file)
                .flatMap(line -> Stream.of(line.split("\\s+"))).collect(Collectors.groupingBy(value -> value, Collectors.counting()));
        log.info("{}",counts);
    }
    
}
