package ziyi.sptsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class ControllerDemo {
    @RequestMapping("/hello")
    public String hello(){
        //调用业务，接受前端参数
        return "hello,world";
    }

    //查出数据，在页面展示
//    @GetMapping("/success")
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","你好,sili");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "themeleafDemo";
    }

}
