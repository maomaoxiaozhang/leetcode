package Study.ws.client;

import Study.ws.HelloService;
import Study.ws.HelloServiceService;
import Study.ws.User;

public class Client {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceService().getHelloServicePort();
//        User user = helloService.getUser();
//        System.out.println(user.getName() + "\t" + user.getPassword());
        helloService.helloService();
    }
}
