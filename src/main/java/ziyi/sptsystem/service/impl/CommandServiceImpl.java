package ziyi.sptsystem.service.impl;

import gnu.io.SerialPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziyi.serialport.manager.SerialPortManager;
import ziyi.serialport.utils.ByteUtils;
import ziyi.serialport.utils.Command3_Utils;
import ziyi.sptsystem.service.CommandService;

import java.util.Map;
@Service
public class CommandServiceImpl implements CommandService {
    @Autowired
    SerialServiceImpl serialService;
    @Override
    public Map<String, Object> sendCmd0() {
        return null;
    }

    @Override
    public Map<String, Object> sendCmd1() {
        return null;
    }

    @Override
    public Map<String, Object> sendCmd2() {
        return null;
    }

    public  Map<String, Object> sendCmd3() {
        String cmd = "FF FF FF FF 82 38 6f ff fe 10 3 0 c7";
        byte[] bytes = ByteUtils.hexToByte(cmd);
//        SerialServiceImpl.openPort();// 打开串口
        SerialPort serialPort = serialService.getmSerialport();
        SerialPortManager.sendToPort(serialPort,bytes); //发送命令
//        System.out.println("命令3：数据已发送");
        Map<String, Object> res=null;
        try {
            Thread.sleep(500);
            byte[] data = SerialPortManager.readFromPort(serialService.getmSerialport()); //读取数据
//            System.out.println("接收数据："+ByteUtils.byteArrayToHexString(data));
            res = Command3_Utils.explainData(ByteUtils.byteArrayToHexString(data));//数据保存至map
            return res;
        }catch (Exception e){
            System.out.println("未读到数据");
            try {
                System.out.println(" 再读一次");
                byte[] data = SerialPortManager.readFromPort(SerialServiceImpl.getmSerialport()); //读取数据
                res = Command3_Utils.explainData(ByteUtils.byteArrayToHexString(data));//数据保存至map
                return res;
            }catch (Exception e2){
                System.out.println("二次未读到");
            }
        }
        finally {
//            SerialPortManager.closePort(SerialServiceImpl.getmSerialport());
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
