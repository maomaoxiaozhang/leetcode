package Study.com.alibaba.dubbo.demo;

import lombok.Data;

@Data
public class WrapClass {
    private DemoService demoService;

    public void wrap() {
//        String str = demoService.sayHello("world");
        System.out.println(System.currentTimeMillis());
    }

//    public void setDemoService(DemoService demoService) {
//        demoService = demoService;
//    }
}
