package ziyi.sptsystem.service;

import java.util.Map;

public interface CommandService {
    Map<String, Object> sendCmd0();

    Map<String, Object> sendCmd1();

    Map<String, Object> sendCmd2();

    static Map<String, Object> sendCmd3() {
        return null;
    }
}
