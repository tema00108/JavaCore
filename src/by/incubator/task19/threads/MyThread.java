package by.incubator.task19.threads;

public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " started");

        System.out.println(this.getName() + " completed its work");
    }
}
