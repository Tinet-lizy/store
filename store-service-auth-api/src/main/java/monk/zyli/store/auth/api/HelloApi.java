package monk.zyli.store.auth.api;


import monk.zyli.store.auth.hystix.HelloApiHystix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 测试Api
 *
 * @author lizy
 * @date 2018/06/13
 */
@FeignClient(name = "store-service-auth",fallback = HelloApiHystix.class)
public interface HelloApi {

    @GetMapping("/api-auth/hi")
    String home(@RequestParam("name") String name);
}
