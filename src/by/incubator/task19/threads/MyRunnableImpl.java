package by.incubator.task19.threads;

import java.util.HashSet;
import java.util.Set;

public class MyRunnableImpl implements Runnable{
    private Thread thread;

    public MyRunnableImpl(String name) {
        thread = new Thread(this, name);
    }

    @Override
    public void run() {
        System.out.println(thread.getName() + " started");

        System.out.println(thread.getName() + " completed its work");
    }

    public Thread getThread() {
        return thread;
    }
}
