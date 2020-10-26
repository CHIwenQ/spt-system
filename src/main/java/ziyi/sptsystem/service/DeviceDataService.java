package ziyi.sptsystem.service;

import java.util.Map;

public interface DeviceDataService {


    public Map<String, Object> getAllData(int id);//获取所有数据

    public double getCurrent();//获取电流值

    public String getCurrentUnit();//获取电流单位

    public double getPressure();//获取压力值

    public String getPressureUnit();//获取压力单位

    public double getPercent();//获取百分比

    public String getPercentUnit();//获取百分比单位

    public  double getTemperature(); //获取温度值

    public String getTemperatureUnit(); //获取温度单位

    public float getAdValue();//获取AD值

}
