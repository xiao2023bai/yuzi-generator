package com.yupi.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {
    public static void main(String[] args){
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        copyFileByHuTool(inputPath,outputPath);
    }

    /**
     *
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    public static void copyFileByHuTool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }
}
