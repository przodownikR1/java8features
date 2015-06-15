package pl.java.scalatech.functional.foo;

public class FooImpl implements Foo,Bar{
  @Override
public  void print() {
    Bar.super.print();
    
}

@Override
public void showLog(Printer p) {
 
    
}
}
