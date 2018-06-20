package Study.com.alibaba.dubbo.demo.consumer;

import Study.com.alibaba.dubbo.demo.DemoService;
import Study.com.alibaba.dubbo.demo.WrapClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "file:C:\\Users\\lenovo\\workspace\\LeetCode\\src\\main\\java\\META-INF\\spring\\dubbo-demo-consumer.xml");
        context.start();
        // obtain proxy object for remote invocation
        DemoService demoService = (DemoService) context.getBean("demoService");
        // execute remote invocation
//        String hello = demoService.sayHello("lalalalalalllllllllllll");
        // show the result
//        System.out.println(hello);
        WrapClass wrapClass = (WrapClass) context.getBean("bean");
        wrapClass.setDemoService(demoService);
        wrapClass.wrap();

    }
}
