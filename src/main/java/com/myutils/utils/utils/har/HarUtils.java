package com.myutils.utils.utils.har;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * @program: utils
 * @description: har相关工具方法
 * @author:
 * @create: 2019-11-05 13:09
 **/
public class HarUtils {

    private static final Logger logger = LoggerFactory.getLogger(HarUtils.class);

    //加载har文件
    public JSONArray loadHarFile(String harFile) throws Exception {

        //获取文件名
        String fileName = FilenameUtils.getName(harFile);

        //获取文件后缀
//        String file = FilenameUtils.getExtension(fileName);


        boolean b = FilenameUtils.isExtension(harFile,"har");
        if (!b){
            throw new Exception("该用例不是har文件");
        }
            String harCase = FileUtils.readFileToString(new File(harFile));
            JSONObject jsonObj = JSON.parseObject(harCase);
            JSONObject temp = (JSONObject) jsonObj.get("log");
            JSONArray entity = (JSONArray) temp.get("entries");
            logger.info("获取entity成功{}",entity.toJSONString());
            return entity;


    }

    //输出json用例
    void writeJson(String harFile,String testcase,String outputFile) throws IOException {
        //获取文件名
        String fileName = FilenameUtils.getName(harFile);

        //获取文件地址
        String file = FilenameUtils.getExtension(fileName);

        String filePath = "";
        FileUtils.write(new File(outputFile),testcase,"utf-8");
    }

    //输出yaml用例
    void writeYaml(String testcase,String outputFile) throws IOException {
        FileUtils.write(new File(outputFile),testcase,"utf-8");
    }

}
