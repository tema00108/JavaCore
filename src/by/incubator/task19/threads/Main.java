package by.incubator.task19.threads;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        startMyThread();
        startThreadFromRunnable();
        startThreadFromRunnableLambda();
        startCallableThread();
    }

    private static void startCallableThread() {
        Callable<String> task = (() -> {
            System.out.println("Callable started");
            System.out.println("Callable ended");
            return "Callable";
        });
        FutureTask<String> future = new FutureTask<>(task);

        new Thread(future).start();
    }

    private static void startThreadFromRunnableLambda() {
        Thread threadFromRunnableLambda = new Thread(() -> {
            System.out.println("Thread from lambda runnable started");
            System.out.println("Thread from lambda runnable completed its work");
        });
        threadFromRunnableLambda.start();
    }

    private static void startThreadFromRunnable() {
        Thread threadFromRunnable = new Thread(new MyRunnableImpl("RunnableImpl"));
        threadFromRunnable.start();
    }

    private static void startMyThread() {
        Thread myThread = new MyThread("MyThread");
        myThread.setDaemon(true);

        myThread.start();
    }
}
