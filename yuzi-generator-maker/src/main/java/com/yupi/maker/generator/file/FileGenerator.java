package com.yupi.maker.generator.file;

import com.yupi.maker.model.DataModel;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;


public class FileGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        // 创建数据模型
        DataModel dataModel = new DataModel();
        dataModel.setAuthor("yupi");
        dataModel.setLoop(false);
        dataModel.setOutputText("求和结果11：");

        doGenerate(dataModel);
    }

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();

        //输入路径
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();

        //1.静态文件生成
        StaticFileGenerator.copyFileByHuTool(inputPath, projectPath);

        //2.动态文件生成
        String dynamicInputPath = projectPath + File.separator + "src/main/resources/template/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";

        DynamicFileGenerator.doGenerate(dynamicInputPath,dynamicOutputPath,model);
    }
}
