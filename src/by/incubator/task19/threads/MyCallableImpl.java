package by.incubator.task19.threads;

import java.util.concurrent.Callable;

public class MyCallableImpl implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() +  " started");

        System.out.println(Thread.currentThread().getName() + " completed its work");
        return Thread.currentThread().getName();
    }
}
