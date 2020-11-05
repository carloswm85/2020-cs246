package src;

public class Main {

    public static void main(String[] args) {
        System.out.println("Executing program...");

        MyRunnableImplementation i = new MyRunnableImplementation();

        i.run();

        Thread thread1 = new Thread(i, "Thread A");
        thread1.start();

        Thread thread2 = new Thread(i, "Thread B");
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() +
                            "\t with Runnable: Inner class Runnable runs..." + i);
                }
            }
        }, "Thread C");
        thread3.start();
    }
}
