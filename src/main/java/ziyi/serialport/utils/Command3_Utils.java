package ziyi.serialport.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * 命令3数据处理
 */
public class Command3_Utils {

    public static String sendCommand3(){
        String cmd = "FF FF FF FF 82 38 6f ff fe 10 3 0 c7";
        return cmd;
    }
    public static Map<String,Object> explainData(String data){
        int index=0;
        while(index!=data.length()-1){
            if (data.charAt(index)=='0' && data.charAt(index+1) =='3') break;
            index++;
        }
        if (index ==data.length()-1)  return null;         //数据未找到，错误
        index+=2;//跳过 命令  1字节
        index+=2;//跳过 字节计数 1字节（1字节16位）
        index+=4;//跳过 状态码  2字节
        String data2 = data.substring(index,data.length()-1); //"39C22713E82041D50000FF4AFEF4C26EFFFF"
        index=0;
        Map<String,Object> res = new HashMap<>();
        res.put("电流值",Float.intBitsToFloat(new BigInteger(data2.substring(index,index+8), 16).intValue()));
        index+=8;
        res.put("电流值单位","mA"); //0C
        index+=2;
        res.put("压力值",Float.intBitsToFloat(new BigInteger(data2.substring(index,index+8), 16).intValue()));                //C185A98639C22713E82041D50000FF4AFEF4C26EFFFF
        index+=8;
        res.put("压力值单位","kPa");
        index+=2;
        res.put("百分比",Float.intBitsToFloat(new BigInteger(data2.substring(index,index+8), 16).intValue()));
        index+=8;
        res.put("百分比单位","%");
        index+=2;
        res.put("温度",Float.intBitsToFloat(new BigInteger(data2.substring(index,index+8), 16).intValue()));
        index+=8;
        res.put("温度单位","degC");
        index+=2;
        res.put("AD值",Float.intBitsToFloat(new BigInteger(data2.substring(index,index+8), 16).intValue()));
        index+=8;
//        for (String str:res.keySet()){
//            System.out.println(str+":"+res.get(str));
//        }


        return res;
    }

    public static void main(String[] args) {
        Command3_Utils.explainData("222");
    }
}
