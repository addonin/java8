package _3_examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dimon
 * @since 16/11/15.
 */
public class Example_2 {
    public static void main(String[] args) {
        withLock(new ReentrantLock(false), () -> System.out.println("Hello"));
    }

    public static void withLock(Lock lock, Runnable action) {
        lock.lock();
        action.run();
        lock.unlock();
    }
}
