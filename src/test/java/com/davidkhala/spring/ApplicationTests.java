package com.davidkhala.spring;

import davidkhala.common.FileTool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        String name = FileTool.getExtensionName("github.com");
        assert name.equals("com");
    }

}
