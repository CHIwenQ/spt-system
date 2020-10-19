package ziyi.sptsystem.controller;


import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ziyi.sptsystem.entity.TmpData;
import ziyi.sptsystem.service.SaveDataService;
import ziyi.sptsystem.service.impl.DeviceDataServiceImpl;
import ziyi.sptsystem.service.impl.SaveDataServiceImpl;
import ziyi.sptsystem.service.impl.SerialServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class DashBoardController {
    @Autowired
     private SerialServiceImpl serialPort;
    @Autowired
    private DeviceDataServiceImpl deviceDataService;
    @Autowired
    private SaveDataServiceImpl saveDataService;
    public  static boolean switchBool = true;
    @RequestMapping("/dashboard")
    public String getDashBoard(Map<String,Object> map){
        map.put("sptid","spt-1");

        return "dashboard";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/dashboard/getData",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String updateData(){
        JSONObject result = new JSONObject();
        float adValue = 0;
        if (deviceDataService.getAllData()!=null){
            adValue = deviceDataService.getAdValue();
        }
        result.put("data",adValue);
        return result.toJSONString();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/dashboard/saveData",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String saveData(@RequestBody TmpData data){
        TmpData tmpData = new TmpData(data.getAd_value(),data.getDate());
        saveDataService.saveAdValue(tmpData);
        return "true";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/dashboard/switchBool",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String switchSerial(){
        JSONObject result = new JSONObject();
        if (switchBool==true){
            if (serialPort.openPort()){
                result.put("switchStatus","openSuccess");
                switchBool = !switchBool;
                return result.toJSONString();
            }
            result.put("switchStatus","openError");
        }else {
            if (serialPort.closePort()){
                result.put("switchStatus","closeSuccess");
                switchBool = !switchBool;
                return result.toJSONString();
            }
            result.put("switchStatus","closeError");
        }
        return result.toJSONString();
    }

    public static void main(String[] args) {
    }
}
