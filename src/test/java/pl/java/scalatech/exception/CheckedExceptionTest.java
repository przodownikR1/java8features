package pl.java.scalatech.exception;

import java.util.Arrays;

import org.junit.Test;

import lombok.Getter;

public class CheckedExceptionTest {
    @Getter
    public String name;
    @Getter
    private int age;

    @Test
    public void test() {
        printFields(this.getClass());
    }

    public void printFields(Class p) {
        System.out.println("+++");
        Arrays.asList(p.getClass().getFields()).forEach(
                f -> {
                    System.err.println(p.getName());
                    try {
                        System.out.println(f.get(p));
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                }
        );
    }

}


