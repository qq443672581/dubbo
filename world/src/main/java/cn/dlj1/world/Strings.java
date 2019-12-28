package cn.dlj1.world;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Strings {

    public static void main(String[] args) {


        // 2*36*10000=720000
        int size = 10000 * 30;
        String[] arr = new String[size];
        int i = 0;
        int x = 1;

        while (true) {
            if(i >= size){
                break;
            }
            System.out.println(x++);
            for (int j = 0; j <  + 10000; j++,i++) {
                arr[i] = new String(UUID.randomUUID().toString());
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(arr[(size/2)]);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(arr[(size/2)]);

    }


}
