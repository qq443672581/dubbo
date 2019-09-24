package cn.dlj1.world;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(50);

        AtomicInteger integer = new AtomicInteger();
        Integer integer1 = new Integer(0);
        for (int i = 0; i < 50; i++) {
            new A(integer,integer1,countDownLatch).start();
        }

        countDownLatch.await();
        System.out.println(integer);
        System.out.println(integer1);

    }

    public static String a(){
        try {
            return "1";
        }catch (Exception e){
            return "2";
        }finally {
        }
    }

    static class A  extends Thread{
        AtomicInteger integer;
        Integer integer1;
        CountDownLatch countDownLatch;

        public A(AtomicInteger integer,Integer integer1,CountDownLatch countDownLatch ){
            this.integer = integer;
            this.integer1 = integer1;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                integer.incrementAndGet();
                integer1+=1;
            }
            countDownLatch.countDown();
        }
    }

}
