package cn.dlj1.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Log {

    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);

        new Customer(queue).start();
        new Provider(queue).start();



    }

    static class Customer extends Thread{
        private ArrayBlockingQueue<String> queue;

        public Customer(ArrayBlockingQueue<String> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String take = queue.take();
                    System.out.println("from customer:" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Provider extends Thread{
        private ArrayBlockingQueue<String> queue;

        public Provider(ArrayBlockingQueue<String> queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(UUID.randomUUID().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
