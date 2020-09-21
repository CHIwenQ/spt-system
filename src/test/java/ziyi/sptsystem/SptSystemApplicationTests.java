package ziyi.sptsystem;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SptSystemApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void testLog(){  //测试日志
        Logger logger = LoggerFactory.getLogger(getClass()); //记录器
        //日志级别由低到高
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");

        //默认输出info以上的级别
        logger.info("这是info日志");
        logger.warn("这是warn日志");
        logger.error("这是error日志");
    }
}
