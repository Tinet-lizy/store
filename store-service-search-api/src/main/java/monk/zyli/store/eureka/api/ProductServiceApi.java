package monk.zyli.store.eureka.api;

import monk.zyli.store.eureka.model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

/**
 * 商品api
 *
 * @author lizy
 * @date 2018/07/11
 */
@FeignClient(name = "store-service-search")
public interface ProductServiceApi {


    @PostMapping("/ProductServiceApi/save")
    Integer save(@RequestBody Product product) throws IOException;
}
