package com.xzq.curd.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.config.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*  使用XML配置文件从Java运行MBG
*   自动是生成dao、bean、mapper
* */
public class MBGtest {
    public static void main(String[] args)  throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);


    }
}
