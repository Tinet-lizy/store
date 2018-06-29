package monk.zyli.store.auth.hystix;

import monk.zyli.store.auth.api.HelloApi;
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
