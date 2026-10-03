// Q21: Inter-thread communication with synchronization (Producer - Consumer problem)
// The shared buffer holds ONE item. wait() and notifyAll() make the producer and the
// consumer take turns: the producer waits while the buffer is full, the consumer waits while it is empty.
class Buffer {
    private int item;
    private boolean available = false;          // true when the buffer holds an unconsumed item

    synchronized void put(int value) throws InterruptedException {
        while (available) wait();               // buffer full: wait for the consumer
        item = value;
        available = true;
        System.out.println("Produced: " + value);
        notifyAll();                            // wake the consumer
    }

    synchronized int get() throws InterruptedException {
        while (!available) wait();              // buffer empty: wait for the producer
        available = false;
        System.out.println("                Consumed: " + item);
        notifyAll();                            // wake the producer
        return item;
    }
}

class Producer extends Thread {
    private final Buffer buffer;
    Producer(Buffer buffer) { this.buffer = buffer; }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.put(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Producer interrupted");
        }
    }
}

class Consumer extends Thread {
    private final Buffer buffer;
    Consumer(Buffer buffer) { this.buffer = buffer; }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) buffer.get();
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted");
        }
    }
}

public class Q21_ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);
        p.start();
        c.start();
        p.join();
        c.join();
        System.out.println("Done");
    }
}
