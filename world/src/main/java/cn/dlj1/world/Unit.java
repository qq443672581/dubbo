package cn.dlj1.world;

import java.util.*;

public class Unit {

    static class A {
        static int X = 1;

        public int a = 1;
        public A(){
            System.out.println("aa");
        }
        static {
            System.out.println("xx");
        }
         {
            System.out.println("a");
        }
    }

    static class B extends A{
        public int a = 2;
        public B(int a){
            System.out.println("b");
        }
        static {
            System.out.println("ff");
        }

    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
       Class a = A.class;

        System.out.println();

    }

}
