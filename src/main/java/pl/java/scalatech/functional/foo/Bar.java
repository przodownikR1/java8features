package pl.java.scalatech.functional.foo;

public interface Bar {
    static Bar getFoo(){
        return new FooImpl();
    }
    
    default void print(){
        System.err.println("hello bar");
    }
    
    void showLog(Printer p);
}
