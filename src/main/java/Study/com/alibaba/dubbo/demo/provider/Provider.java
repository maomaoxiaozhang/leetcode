package Study.com.alibaba.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "file:C:\\Users\\lenovo\\workspace\\LeetCode\\src\\main\\java\\META-INF\\spring\\dubbo-demo-provider.xml");
        context.start();
        // press any key to exit
        System.in.read();
    }
}
