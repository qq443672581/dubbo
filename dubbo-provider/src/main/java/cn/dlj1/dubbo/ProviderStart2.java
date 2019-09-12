package cn.dlj1.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderStart2 {

    public static void main(String[] args) throws Exception {

        System.setProperty("dubbo.protocol.port","20002");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();

        System.in.read();

    }

}
