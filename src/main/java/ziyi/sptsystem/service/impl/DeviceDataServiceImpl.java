package ziyi.sptsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziyi.sptsystem.service.DeviceDataService;

import java.util.Map;

@Service
public class DeviceDataServiceImpl  implements DeviceDataService {
     static Map<String, Object> resMap;
     @Autowired
     CommandServiceImpl commandService;
    @Override
    public Map<String, Object> getAllData(int id) {
        resMap=commandService.sendCmd3(id);
//        for (String str:resMap.keySet()){
//            System.out.println(str+":"+resMap.get(str));
//        }
        return resMap;

    }

    @Override
    public double getCurrent() {
        return 0;
    }

    @Override
    public String getCurrentUnit() {
        return null;
    }

    @Override
    public double getPressure() {
        return 0;
    }

    @Override
    public String getPressureUnit() {
        return null;
    }

    @Override
    public double getPercent() {
        return 0;
    }

    @Override
    public String getPercentUnit() {
        return null;
    }

    @Override
    public double getTemperature() {
        return 0;
    }

    @Override
    public String getTemperatureUnit() {
        return null;
    }

    @Override
    public float getAdValue() {
        float ad = (float) resMap.get("AD值");
        return ad;
    }

    public static void main(String[] args) {

        for (String str:resMap.keySet()){
            System.out.println(str+":"+resMap.get(str));
        }
    }
}
