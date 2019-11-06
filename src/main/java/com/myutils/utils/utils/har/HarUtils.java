package com.myutils.utils.utils.har;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.IOException;

/**
 * @program: utils
 * @description: har相关工具方法
 * @author:
 * @create: 2019-11-05 13:09
 **/
public class HarUtils {

    //加载har文件
    String loadHarFile(String harFile) throws IOException {
        //获取文件名
        String fileName = FilenameUtils.getName(harFile);
        //获取文件地址
        String file = FilenameUtils.getExtension(fileName);
        boolean b = FilenameUtils.isExtension(harFile,"har");
        if (b){
            String harCase = FileUtils.readFileToString(new File(harFile));
            return harCase;
        }else {
            return null;
        }
    }

    //输出json用例
    void writeJson(String testcase,String outputFile) throws IOException {
        FileUtils.write(new File(outputFile),testcase,"utf-8");
    }

    //输出yaml用例
    void writeYaml(String testcase,String outputFile) throws IOException {
        FileUtils.write(new File(outputFile),testcase,"utf-8");
    }

}
