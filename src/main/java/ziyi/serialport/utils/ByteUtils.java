package ziyi.serialport.utils;

import java.nio.ByteBuffer;
import java.util.Locale;

/**
 * Byte转换工具
 * 
 * @author yangle
 */
public class ByteUtils {

	/**
	 * 十六进制字符串转byte[]
	 * 
	 * @param hex
	 *            十六进制字符串
	 * @return byte[]
	 */
	public static byte[] hexStringToByte(String hex) {
		if (hex == null || hex.equals(""))
			return null;
		String[] arry = hex.split(" ");
		byte[] data = new byte[arry.length];
		try {
			for (int i = 0; i < arry.length; i++) {
				//这个地方在定协议
				if (arry[i].length() > 2)
					return null;
				int d = Integer.parseInt(arry[i], 16);
				data[i] = (byte) d;
			}

		} catch (Exception e) {
			return null;
		}
		return data;
	}

	public static byte[] hexStr2Byte(String hex) {
		if (hex == null) {
			return new byte[] {};
		}

		// 奇数位补0
//		if (hex.length() % 2 != 0) {
//			hex = "0" + hex;
//		}

		int length = hex.length();
		ByteBuffer buffer = ByteBuffer.allocate(length / 2);
		for (int i = 0; i < length; i++) {
			String hexStr = hex.charAt(i) + "";
			i++;
			hexStr += hex.charAt(i);
			byte b = (byte) Integer.parseInt(hexStr, 16);
			buffer.put(b);
		}
		return buffer.array();
	}

	public static byte[] hexToByte(String hex){
		if (hex == null) {
			return new byte[] {};
		}
		String[] str=hex.split(" ");
		ByteBuffer buffer = ByteBuffer.allocate(str.length);
		for (int i=0;i<str.length;i++){
			byte b = (byte) Integer.parseInt(str[i], 16);
			buffer.put(b);
		}
		return buffer.array();
	}
	/**
	 * byte[]转十六进制字符串
	 * 
	 * @param array
	 *            byte[]
	 * @return 十六进制字符串
	 */
	public static String byteArrayToHexString(byte[] array) {
		if (array == null) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			buffer.append(byteToHex(array[i]));
		}
		return buffer.toString();
	}

	/**
	 * byte转十六进制字符
	 * 
	 * @param b
	 *            byte
	 * @return 十六进制字符
	 */
	public static String byteToHex(byte b) {
		String hex = Integer.toHexString(b & 0xFF);
		if (hex.length() == 1) {
			hex = '0' + hex;
		}
		return hex.toUpperCase(Locale.getDefault());
	}
}
