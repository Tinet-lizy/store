package monk.zyli.store.console.controller;

import monk.zyli.store.auth.api.HelloApi;
import monk.zyli.store.auth.api.ProductServiceApi;
import monk.zyli.store.auth.model.Product;
import monk.zyli.store.console.service.MqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api-console/hi")
public class HiController {

    @Autowired
    MqProducerService mqProducerService;


    @Autowired
    ProductServiceApi productServiceApi;

    @Autowired
    HelloApi helloApi;

    @GetMapping
    public String getHome(@RequestParam String name) throws IOException {
        //mqProducerService.sendMessage("hahah","test");
        Product product = new Product();
        product.setDescription("这就是一个测试");
        product.setName("名称随便起");

        String[] urls = {"aaaaa","adasdada"};
        product.setImageUrls(urls);
        productServiceApi.save(product);

       return "";
    }
}
