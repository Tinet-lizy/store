package monk.zyli.store.console;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = {"monk.zyli"})
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@ComponentScan(value = "monk.zyli.store")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
