package com.example.web;


import org.apache.commons.collections.MapUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
 import springfox.documentation.spring.web.plugins.Docket;

import java.util.Map;


/**
 * @author admin
 */
@Configuration
@Profile({"dev"})
public class SwaggerConfig implements BeanFactoryPostProcessor {




    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, ISwaggerGroupInfo> map = beanFactory.getBeansOfType(ISwaggerGroupInfo.class);
        if (MapUtils.isEmpty(map)) {
            Docket docket = createNewDocket("DDD", "com.example", "My SpringBoot Demo Swagger2", "demo", "http://www.baidu.com");
            beanFactory.registerSingleton("docket", docket);
        } else {
            System.out.println(map.size()+"------Size---------"+ map.values());
            //按包名分组
            for (ISwaggerGroupInfo groupInfo : map.values()) {
                if (groupInfo.isEnable()) {
                    Docket docket = createNewDocket(groupInfo.sortEnum().ordinal() + "-" + groupInfo.groupName(), groupInfo.getClass().getPackage().getName(),
                            groupInfo.description(), groupInfo.creator(), groupInfo.creatorEmail());
                    try {
                        beanFactory.registerSingleton("docket" + groupInfo.sortEnum().ordinal(), docket);
                    } catch (Exception e) {
                        beanFactory.registerSingleton("docket" + groupInfo.sortEnum().ordinal() + groupInfo.creator(), docket);
                        e.printStackTrace();
                        System.out.println("Swagger配置分组排序号有重复,请检查." + e.getMessage());
                    }
                }
            }
        }
    }

    /**
     * 创建分组Docket
     *
     * @param groupName    分组名称
     * @param packagePath  分组所在完整包路径
     * @param description  分组描述
     * @param creator      分组创建人
     * @param creatorEmail 分组创建人Email
     * @return Docket
     */
    private Docket createNewDocket(String groupName, String packagePath, String description, String creator, String creatorEmail) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(description, creator, creatorEmail))
                .groupName(groupName)
                .select()
                .apis(RequestHandlerSelectors.basePackage(packagePath))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建分组ApiInfo
     *
     * @param description  分组描述
     * @param creator      分组创建人
     * @param creatorEmail 分组创建人Email
     * @return ApiInfo
     */
    private ApiInfo apiInfo(String description, String creator, String creatorEmail) {
        return new ApiInfoBuilder()
                .title("MyDemo")
                .description(description)
                .termsOfServiceUrl("")
                .contact(new Contact(creator, "http://www.example.com", creatorEmail))
                .version("1.0.0")
                .build();
    }

}
