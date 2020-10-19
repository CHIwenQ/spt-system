package ziyi.sptsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ziyi.sptsystem.entity.TmpData;
import ziyi.sptsystem.service.DeviceDataService;
import ziyi.sptsystem.service.impl.DeviceDataServiceImpl;
import ziyi.sptsystem.service.impl.SaveDataServiceImpl;

import java.util.Arrays;
import java.util.Map;

@Controller
public class ControllerDemo {
    @Autowired
    private SaveDataServiceImpl saveDataService;

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

    @GetMapping("/chart")
    public String chart(){
        DeviceDataService deviceData = new DeviceDataServiceImpl();

        return "chartDemo2";
    }

    @GetMapping("/batis")
    public String batis(){
        TmpData tmpData = new TmpData();
        tmpData.setAd_value(2323);
        saveDataService.saveAdValue(tmpData);
        return "chartDemo2";
    }


}
