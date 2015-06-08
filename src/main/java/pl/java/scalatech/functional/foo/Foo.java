package pl.java.scalatech.functional.foo;

public interface Foo {

    static Foo getFoo(){
        return new FooImpl();
    }
    
    default void print(){
        System.err.println("hello foo");
    }

}
