package me.junhua.system;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisPlusGenerate {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir") + "/junhua-system";
        System.out.println("projectPath = " + projectPath);
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/junhua-cloud?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC", "root", "root")
                .globalConfig(builder -> {
                    builder.author("ljhua") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("me.junhua.system") // 设置父包名
//                            .moduleName("uc") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper/")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_user_role", "sys_role_resource", "sys_org_user", "sys_org_role") // 设置需要生成的表名
                            .addTablePrefix("s_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
