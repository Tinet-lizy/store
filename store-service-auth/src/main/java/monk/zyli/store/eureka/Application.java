package monk.zyli.store.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限模块
 *
 * @author lizy
 * @date: 2018/07/10
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
