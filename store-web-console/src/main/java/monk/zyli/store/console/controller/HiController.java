package monk.zyli.store.console.controller;

import monk.zyli.store.auth.api.HelloApi;
import monk.zyli.store.console.service.MqProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-console/hi")
public class HiController {

    @Autowired
    MqProducerService mqProducerService;

    @Autowired
    HelloApi helloApi;

    @GetMapping
    public String getHome(@RequestParam String name){
        mqProducerService.sendMessage("hahah","test");
       return "";
    }
}
