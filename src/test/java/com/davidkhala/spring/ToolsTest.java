package com.davidkhala.spring;

import davidkhala.common.FileTool;
import org.junit.jupiter.api.Test;

class ToolsTest {

    @Test
    void contextLoads() {
        String name = FileTool.getExtensionName("github.com");
        assert name.equals("com");
    }

}
