package com.figo.generator;

import com.figo.generator.config.*;
import com.figo.generator.config.rules.DateType;
import com.figo.generator.config.rules.NamingStrategy;
import com.figo.generator.engine.AbstractTemplateEngine;
import com.figo.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.Scanner;

/**
 * 抽象代码生成器
 *
 * @author hubin
 * @since 2021-02-08
 */
public class SimpleAutoGenerator {
    /**
     * 读取控制台输入内容
     */
    private final Scanner scanner = new Scanner(System.in);

    //private static final String JDBC_URL = "jdbc:mysql://localhost:3306/battery_swap?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
    private static final String JDBC_URL = "jdbc:mysql://rm-uf6hx49w1f7b6p380co.mysql.rds.aliyuncs.com:3306/battery_swap?characterEncoding=utf8&serverTimezone=UTC";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_USERNAME = "rnm_root";
    private static final String JDBC_PASSWORD = "wX32!m3s";


    /**
     * 执行代码生成
     */
    public void execute() {
        // 执行开始
        this.start();

        // 初始化配置数据源
        new AutoGenerator(this.configBuilder(dataSourceConfigBuilder()))
                // 全局配置
                .global(this.configBuilder(globalConfigBuilder()))
                // 模板配置
                .template(this.configBuilder(templateConfigBuilder()))
                // 包配置
                .packageInfo(this.configBuilder(packageConfigBuilder()))
                // 策略配置
                .strategy(this.configBuilder(strategyConfigBuilder()))
                // 注入配置
                .injection(this.configBuilder(injectionConfigBuilder()))
                // 执行
                .execute(this.templateEngine());
    }

    protected <T> T configBuilder(IConfigBuilder<T> configBuilder) {
        return null == configBuilder ? null : configBuilder.build();
    }

    /**
     * 执行开始
     */
    public void start() {
        System.out.println("！！！执行代码自动生成开始！！！");
    }

    /**
     * 数据源配置 Builder
     */
    public IConfigBuilder<DataSourceConfig> dataSourceConfigBuilder() {

        return new DataSourceConfig.Builder(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);


    }

    /**
     * 全局配置 Builder
     */
    public IConfigBuilder<GlobalConfig> globalConfigBuilder() {
        String outputDir = new File(System.getProperty("user.dir")) + File.separator + "build" + File.separator + "code";
        System.out.println("\n输出文件目录：" + outputDir);
        return new GlobalConfig.Builder().fileOverride().enableSwagger().outputDir(outputDir)
                .author("shefei").dateType(DateType.TIME_PACK);
    }

    /**
     * 生成文件包名配置 Builder
     */
    public IConfigBuilder<PackageConfig> packageConfigBuilder() {
        return new PackageConfig.Builder().parent("com.figo").moduleName("common");
    }

    /**
     * 自定义模板配置 Builder
     */
    public IConfigBuilder<TemplateConfig> templateConfigBuilder() {
        return new TemplateConfig.Builder();
    }

    /**
     * 代码生成策略配置 Builder
     */
    public IConfigBuilder<StrategyConfig> strategyConfigBuilder() {

        return new StrategyConfig.Builder().addInclude("t_operation".split(",")).addTablePrefix("t_")
                .entityBuilder().naming(NamingStrategy.underline_to_camel)
                .controllerBuilder().enableRestStyle().enableHyphenStyle().entityBuilder().enableLombok();
    }

    /**
     * 注入配置 Builder
     */
    public IConfigBuilder<InjectionConfig> injectionConfigBuilder() {

        return new InjectionConfig.Builder();
    }

    /**
     * 代码生成，模板引擎
     */
    public AbstractTemplateEngine templateEngine() {
        return new FreemarkerTemplateEngine();
    }

    public static void main(String[] args) {
        new SimpleAutoGenerator().execute();
    }
}
