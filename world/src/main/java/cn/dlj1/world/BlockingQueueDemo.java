package cn.dlj1.world;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {

    public static void main(String[] args) {
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

                synchronized (queue){
                    if(queue.size() == 0) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(queue.poll());
                }

            }
        }
    }
    static class Provider extends Thread {
        private ArrayBlockingQueue<String> queue;

        public Provider(ArrayBlockingQueue<String> queue){
            this.queue = queue;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (queue){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        queue.put("123");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    queue.notify();
                }
            }
        }
    }

}
