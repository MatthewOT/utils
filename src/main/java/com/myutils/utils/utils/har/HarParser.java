package com.myutils.utils.utils.har;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: utils
 * @description:
 * @author:
 * @create: 2019-11-04 17:26
 **/
public class HarParser {

    private static final Logger logger = LoggerFactory.getLogger(HarParser.class);
    String filePath;
    String filterStr;
    String excludeStr;
    private static final String[] INFO = {"host",
            "accept",
            "content-length",
            "connection",
            "accept-encoding",
            "accept-language",
            "origin",
            "referer",
            "cache-control",
            "pragma",
            "cookie",
            "upgrade-insecure-requests",
            ":authority",
            ":method",
            ":scheme",
            ":path"};

    void getRequestUrl(){}
    void getRequestHeaders(){}
    void getRequestMethod(){}
    void getRequestData(){}
    void getValidate(){}
    void getTeststep(){}
    void getConfig(){}
    void getTeststeps(){}
    //从har中提取参数并准备case文件
    void makeTestcase(){}
    //生成case文件
    void generateTestcase(){}
}
