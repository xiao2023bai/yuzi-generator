package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;


public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        // 创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果11：");

        doGenerate(mainTemplateConfig);
    }
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String inputRootPath = "C:\\Users\\admin\\IdeaProjects\\yuzi-generator\\yuzi-generator-demo-projects\\acm-template-pro";
        String outputRootPath = "C:\\Users\\admin\\IdeaProjects\\yuzi-generator\\acm-template-pro";

        String inputPath;
        String outputPath;

        inputPath = new File(inputRootPath, "src/com/yupi/acm/MainTemplate.java.ftl").getAbsolutePath();
        outputPath = new File(outputRootPath, "src/com/yupi/acm/MainTemplate.java").getAbsolutePath();
        DynamicGenerator.doGenerate(inputPath, outputPath, model);

        inputPath = new File(inputRootPath, ".gitignore").getAbsolutePath();
        outputPath = new File(outputRootPath, ".gitignore").getAbsolutePath();
        StaticGenerator.copyFileByHuTool(inputPath, outputPath);

        inputPath = new File(inputRootPath, "README.md").getAbsolutePath();
        outputPath = new File(outputRootPath, "README.md").getAbsolutePath();
        StaticGenerator.copyFileByHuTool(inputPath, outputPath);
    }
}


