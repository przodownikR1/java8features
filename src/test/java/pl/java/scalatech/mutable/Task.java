package pl.java.scalatech.mutable;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(200);
        return Thread.currentThread().getName();
    }
}