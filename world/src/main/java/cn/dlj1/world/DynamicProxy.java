package cn.dlj1.world;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    interface S {
        void eat();
    }

    static class Handler implements InvocationHandler{

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return "123";
        }

    }

    public static void main(String[] args) {

        synchronized (S.class){

        }

        S s = (S) Proxy.newProxyInstance(S.class.getClassLoader(),new Class[]{S.class},new Handler());
        s.eat();
        System.out.println(s);

    }

}
