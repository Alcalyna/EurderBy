package org.calinh.eurderbylinh;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EurderByLinhApplicationTests {

    @Test
    void contextLoads() {
        System.getProperties().put("server.port", 4040);
        EurderByLinhApplication.main(new String[]{});
    }

}
