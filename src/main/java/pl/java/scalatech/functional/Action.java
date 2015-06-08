package pl.java.scalatech.functional;


@FunctionalInterface
public interface Action {
    void print();

    default void defaultMethod() {
        System.err.println("default action");
    }
}
