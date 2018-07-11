package monk.zyli.store.eureka.hystix;

import monk.zyli.store.eureka.api.HelloApi;
import org.springframework.stereotype.Component;

/**
 * 测试短路器
 */
@Component
public class HelloApiHystix implements HelloApi {
    @Override
    public String home(String name) {
        return "error";
    }
}
