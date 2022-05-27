package by.incubator.task20.multithreadingSingleton;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        for (Thread thread : initThreads()) {
            thread.start();
            thread.join();
        }
    }

    private static Thread[] initThreads() {
        Thread[] threads = new Thread[3];
        Runnable runnable = () -> System.out.println(SingletonClass.instance());

        threads[0] = new Thread(runnable);
        threads[1] = new Thread(runnable);
        threads[2] = new Thread(runnable);

        return threads;
    }
}
