package wujiangbo.codeGenerator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import wujiangbo.tools.MyUtils;
import java.util.*;

/**
 * @description: 代码生成工具类
 * @author 波波老师(weixin:javabobo0513)
 */
public class CodeGeneratorUtils {

    /**
     * 修改成自己的配置文件名称即可
     */
    static ResourceBundle rb = ResourceBundle.getBundle("MyBatisPlus-config-wujiangbo"); //不要加后缀.properties

    //代码存储的项目根目录
    private static String baseProjectPath = "";
    //存放：controller、service、mapper、mapper.xml、domain、query的模块目录
    private static final String projectServerPath = baseProjectPath + "SpringBoot";
    //存放：vue页面和js文件路径
    private static final String projectWebsitePath = baseProjectPath + "UI";
    //作者名称
    private static String author = "";
    //需要生成的表的前缀
    private static String tableNamePrefix = "";
    //数据库连接参数
    private static String db_url = "";
    //数据库驱动
    private static String db_driver_name = "";
    //数据库账号
    private static String db_username = "";
    //数据库密码
    private static String db_password = "";
    //根包名
    private static final String root_package = "cn.wujiangbo";
    //根包路径
    private static final String root_package_path = "/cn/wujiangbo";
    //表的归属模块名称，会生成该名称的包
    private static String module_name = "";

    static{
        baseProjectPath = rb.getString("baseProjectPath");
        author = rb.getString("author");
        module_name = rb.getString("moduleName");
        tableNamePrefix = rb.getString("tableNamePrefix");
        db_driver_name = rb.getString("jdbc.driver");
        db_url = rb.getString("jdbc.url");
        db_username = rb.getString("jdbc.user");
        db_password = rb.getString("jdbc.pwd");
    }

    //程序入口
    public static void main(String[] args) {
        String tableNames = rb.getString("tableNames");
        String[] tableArray = tableNames.split(",");
        for (int i = 0; i < tableArray.length; i++) {
            generatorCode(tableArray[i]);
        }
    }

    //生成代码方法
    public static void generatorCode(String tableNames) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        //实体类名称
        String entityName = MyUtils.convert(tableNamePrefix, tableNames);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectServerPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.AUTO);
        gc.setFileOverride(true);//是否覆盖（第二次生成代码是否要覆盖第一次生成的代码）
        gc.setSwagger2(true);//是否开启Swagger
        gc.setActiveRecord(false);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setOpen(false);//生成完成后是否打开文件夹
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(db_url);
        dsc.setDriverName(db_driver_name);
        dsc.setUsername(db_username);
        dsc.setPassword(db_password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(root_package);
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.basePath 【可无】
        String finalEntityName = entityName;
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("entityName", finalEntityName.toLowerCase());
                map.put("urlPrefix", "/EasyJava");
                map.put("basePath", root_package);
                map.put("moduleName", module_name);
                this.setMap(map);
            }
        };

        List<FileOutConfig> focList = new ArrayList<>();

        //配置controller
        focList.add(new FileOutConfig("/templates/controller.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectServerPath + "/src/main/java" + root_package_path + "/controller" + "/" + module_name + "/" + tableInfo.getEntityName() + "Controller" + StringPool.DOT_JAVA;
            }
        });

        //配置domain
        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectServerPath + "/src/main/java" + root_package_path + "/domain" + "/" + module_name + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });

        //配置query
        focList.add(new FileOutConfig("/templates/query.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectServerPath + "/src/main/java" + root_package_path + "/query" + "/" + module_name + "/" + tableInfo.getEntityName() + "Query" + StringPool.DOT_JAVA;
            }
        });

        //配置mapper
        focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectServerPath + "/src/main/java" + root_package_path + "/mapper" + "/" + module_name + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_JAVA;
            }
        });

        //配置xml
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectServerPath + "/src/main/resources" + root_package_path + "/mapper" + "/" + module_name + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        //配置前端vue页面
        focList.add(new FileOutConfig("/templates/easyVue.vue.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectWebsitePath + "/src/views/" + module_name + "/" + tableInfo.getEntityName() + ".vue";
            }
        });


        //配置serviceImpl
        focList.add(new FileOutConfig("/templates/serviceImpl.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectServerPath + "/src/main/java" + root_package_path + "/service" + "/" + module_name + "/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
            }
        });

        TemplateConfig tc = new TemplateConfig();
        tc.setEntity(null);
        tc.setXml(null);
        tc.setController(null);
        tc.setMapper(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplate(tc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[]{"t_"});//忽略的表头
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(tableNames);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
