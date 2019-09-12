package cn.dlj1.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderStart {

    public static void main(String[] args) throws Exception {

        System.setProperty("dubbo.protocol.port","20001");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();

        System.in.read();

    }

}
