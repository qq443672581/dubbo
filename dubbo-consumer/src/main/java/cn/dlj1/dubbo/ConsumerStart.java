package cn.dlj1.dubbo;

import cn.dlj1.common.interfaces.DemoService;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

public class ConsumerStart {

    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"consumer.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理

        while (true) {
            String hello = demoService.sayHello("world"); // 执行远程方法
            System.out.println(hello); // 显示调用结果
            TimeUnit.MILLISECONDS.sleep(200);
        }


    }

}
