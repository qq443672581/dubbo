package cn.dlj1.world;

public class SmallData {

    public static void main(String[] args) {
        long x = 1;

        for (long i = 0; i < 63; i++) {
            System.out.println((x << i) + " " + (String.valueOf(x << i).length()) + " "+ (Long.toBinaryString(x << i).length()));
        }




    }
}
