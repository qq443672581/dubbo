package cn.dlj1.world;

import java.lang.ref.SoftReference;
import java.util.SortedMap;
import java.util.TreeMap;

public class Tree {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        int c = a & b;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));
        System.out.println();
        System.out.println(c);
    }
}
