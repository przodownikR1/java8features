package pl.java.scalatech.files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
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
    public void shouldContentFileFind() {
        Path path = FileSystems.getDefault().getPath("/home/przodownik/blog/java8features/src/main");
        findContentInFiles(path, "Class");
    }

    @Test
    @SneakyThrows
    public void shouldFilesFind() {
        Path start = FileSystems.getDefault().getPath("/home/przodownik/blog/java8features/src/main");
         Stream<Path> stream = Files.find(start, 10, (path,atrrs) -> (

                 path.endsWith(".java")));
         stream.forEach(l->log.info("{}",l.getFileName()));
    }

    @SneakyThrows(value = IOException.class)
    public static Stream<String> lines(Path path) {

        return Files.lines(path);

    }
    @SneakyThrows
    public static void findContentInFiles(Path dir,String content) {
    try (Stream<Path> stream = Files.walk(dir).parallel().filter(Files::isRegularFile).peek(l->log.info("{}",l))) {
     //  log.info("+++   {}",stream.count());
        stream.filter(entry -> {
            try (Stream<String> fileStream = Files.lines(entry)) {
                return fileStream.filter(s -> s.contains(content)).findFirst().isPresent();
            } catch (@SuppressWarnings("unused") IOException e) {
                return false;
            }
        }

         ).forEach(p->log.info("find : {}",p));
    }
    }

}
