// Q20: Priorities among multiple threads
// Priority ranges from Thread.MIN_PRIORITY (1) to Thread.MAX_PRIORITY (10); default is NORM_PRIORITY (5).
// Priority is only a HINT to the scheduler: a higher priority thread tends to get more CPU time,
// but the exact output order can differ from run to run and from machine to machine.
class Worker extends Thread {
    Worker(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " (priority " + getPriority() + ") - step " + i);
            Thread.yield();                     // give other threads a chance
        }
    }
}

public class Q20_ThreadPriority {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread priority: " + Thread.currentThread().getPriority());
        System.out.println("MIN = " + Thread.MIN_PRIORITY + ", NORM = " + Thread.NORM_PRIORITY
                + ", MAX = " + Thread.MAX_PRIORITY + "\n");

        Worker low = new Worker("LowThread", Thread.MIN_PRIORITY);
        Worker normal = new Worker("NormalThread", Thread.NORM_PRIORITY);
        Worker high = new Worker("HighThread", Thread.MAX_PRIORITY);

        low.start();
        normal.start();
        high.start();

        low.join();                             // wait for all threads to finish
        normal.join();
        high.join();
        System.out.println("\nAll threads finished");
    }
}
