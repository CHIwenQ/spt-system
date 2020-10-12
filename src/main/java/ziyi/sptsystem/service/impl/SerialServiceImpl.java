package ziyi.sptsystem.service.impl;

import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import org.springframework.stereotype.Service;
import ziyi.serialport.manager.SerialPortManager;
import ziyi.serialport.utils.ShowUtils;
import ziyi.sptsystem.service.SerialService;
import java.util.List;

@Service
public class SerialServiceImpl implements SerialService {
    // 串口列表
    private static List<String> mCommList;
    // 串口对象
    private static SerialPort mSerialport;
    // 串口名称
    private static String mSerialName = "";

    private static boolean findPort() { //寻找串口
        mCommList = SerialPortManager.findPorts();
        // 检查是否有可用串口，有则加入选项中
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (mCommList == null || mCommList.size() < 1) {
            System.out.println("没有搜索到有效串口！");
            return false;
        } else {
            System.out.println("找到有效串口！");
            for (String s : mCommList) {
                mSerialName += s;
            }
            return true;
        }
    }

    /**
     * 打开串口
     *
     * @return 打开成功，返回true，打开失败，返回false。原因：1.串口已被占用，2.串口未检测到
     */
    public static boolean openPort() { //打开串口
        if (findPort() == true && mSerialport == null) {
            // 获取串口名称
            String commName = mSerialName;
            // 获取波特率，默认为1200
            int baudrate = 1200;
            // 检查串口名称是否获取正确
            if (commName == null || commName.equals("")) {
                System.out.println("没有搜索到有效串口！");
                return false;
            } else {
                try {
                    mSerialport = SerialPortManager.openPort(commName, baudrate); //打开串口
                    Thread.sleep(300);
                    if (mSerialport != null) {
                        System.out.println("串口已打开");
                        return true;
                    }
                } catch (PortInUseException e) {
                    ShowUtils.warningMessage("串口已被占用！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return false;
            }
        } else {
            return false;
        }

    }

    /**
     * 关闭串口
     *
     * @return 关闭成功，返回true，关闭失败，返回false，原因：串口未打开
     */
    public static boolean closePort() {
        if (SerialPortManager.closePort(SerialServiceImpl.getmSerialport())) {
            try {
                SerialServiceImpl.setmSerialport(null);
                SerialServiceImpl.setmCommList(null);
                SerialServiceImpl.setmSerialName("");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;
    }

    public static List<String> getmCommList() {
        return mCommList;
    }

    public static void setmCommList(List<String> mCommList) {
        SerialServiceImpl.mCommList = mCommList;
    }

    public static SerialPort getmSerialport() {
        return mSerialport;
    }

    public static void setmSerialport(SerialPort mSerialport) {
        SerialServiceImpl.mSerialport = mSerialport;
    }

    public static String getmSerialName() {
        return mSerialName;
    }

    public static void setmSerialName(String mSerialName) {
        SerialServiceImpl.mSerialName = mSerialName;
    }

}
