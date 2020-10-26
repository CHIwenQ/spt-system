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
    static int missNum = 1;
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

    public Map<String, Object> sendCmd3(int id) {
        String cmd = "";
        if (id == 0) {
            cmd = "FF FF FF FF 82 38 6f ff fe 10 3 0 c7";
        } else if (id == 1) {
            cmd = "FF FF FF FF 82 38 6f ff fe 11 3 0 c6";
        } else if (id == 2) {
            cmd = "FF FF FF FF 82 38 6f ff fe 12 3 0 c5";
        }
        byte[] bytes = ByteUtils.hexToByte(cmd);
//        SerialServiceImpl.openPort();// 打开串口
        SerialPort serialPort = serialService.getmSerialport();
        Map<String, Object> res = null;
        try {
            SerialPortManager.sendToPort(serialPort, bytes); //发送命令
            Thread.sleep(100);
            System.out.println("发送：" + 1 + " 次！" + ",id:" + id);
            byte[] data = SerialPortManager.readFromPort(serialService.getmSerialport()); //读取数据
//            System.out.println("接收数据："+ByteUtils.byteArrayToHexString(data));
            res = Command3_Utils.explainData(ByteUtils.byteArrayToHexString(data));//数据保存至map
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } catch (Exception e) {
            int i = 2;
            while (res == null && i <= 5) {
                SerialPortManager.sendToPort(serialPort, bytes); //发送命令
                System.out.println("开启连发模式");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println("发送：" + i + " 次！" + ",id:" + id);
                i++;
            }
            byte[] data = SerialPortManager.readFromPort(serialService.getmSerialport()); //读取数据
            res = Command3_Utils.explainData(ByteUtils.byteArrayToHexString(data));//数据保存至map
            if (res == null) {
                System.out.println("连发模式未读到数据");
            }
        } finally {
//            SerialPortManager.closePort(SerialServiceImpl.getmSerialport());
            return res;

        }
    }

    public static void main(String[] args) {
    }
}
