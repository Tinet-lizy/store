package monk.zyli.store.eureka.service;

import monk.zyli.store.eureka.api.HelloApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloApi{


    @Value("${server.port}")
    String port;

    @Override
    public String home( String name) {
        return "hi "+name+",i am from port:" +port;
    }

}
