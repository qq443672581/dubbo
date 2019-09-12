package cn.dlj1.dubbo;

import cn.dlj1.common.interfaces.DemoService;
import org.springframework.beans.factory.annotation.Value;

public class DemoServiceImpl implements DemoService {

    @Value("${dubbo.application.name}")
    private String n;

    public String sayHello(String name) {
        return String.format("from application:%s, port:%s, hello %s", n, System.getProperty("dubbo.protocol.port"), name);
    }

    public String say(String word) {
        return word;
    }
}
