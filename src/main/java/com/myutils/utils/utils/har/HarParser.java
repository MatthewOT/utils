package com.myutils.utils.utils.har;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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

    public void getRequestUrl(JSONObject entity){

        //获取url
        String url = (String) ((JSONObject)entity.get("request")).get("url");
        logger.info("请求url为：{}",url);
        //这里有问题
        Object requestParams = ((JSONObject)entity.get("request")).get("queryString");
    }

    public void getRequestHeaders(JSONObject entity){
        //获取headers,遍历时可能需要将其转换成map
        JSONArray headers = (JSONArray)((JSONObject)entity.get("request")).get("headers");

    }

    public void getRequestMethod(JSONObject entity){
        //获取method
        String method = (String) ((JSONObject)entity.get("request")).get("method");
        logger.info("该请求方法为{}",method);
    }

    public void getRequestData(JSONObject entity){

    }

    public void getValidate(JSONObject entity){}

    public void getTeststep(JSONObject entity){}

    public void getConfig(JSONObject entity){}

    public void getTeststeps(){}
    //从har中提取参数并准备case文件
    public void makeTestcase(){}
    //生成case文件
    public void generateTestcase(){}
}
