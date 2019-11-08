package com.myutils.utils;

import com.alibaba.fastjson.JSONObject;
import com.myutils.utils.utils.har.HarParser;
import com.myutils.utils.utils.har.HarUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void harIoTest() throws Exception {
        HarUtils harUtils = new HarUtils();
        JSONObject entity = harUtils.loadHarFile("D:\\tools\\utils\\src\\main\\java\\com\\myutils\\utils\\utils\\har\\demo.har");
        HarParser harParser = new HarParser();
        harParser.getRequestMethod(entity);
        harParser.getRequestUrl(entity);
    }

}
