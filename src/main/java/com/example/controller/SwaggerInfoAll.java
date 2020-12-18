package com.example.controller;

import com.example.web.ISwaggerGroupInfo;
import com.example.web.SwaggerGroupSortEnum;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerInfoAll implements ISwaggerGroupInfo {
    @Override
    public Boolean isEnable() {
        return true;
    }

    @Override
    public SwaggerGroupSortEnum sortEnum() {
        return SwaggerGroupSortEnum.ALL;
    }

    @Override
    public String groupName() {
        return "全部分组";
    }

    @Override
    public String description() {
        return "Demo项目-全部分组";
    }

    @Override
    public String creator() {
        return "demoALL";
    }

    @Override
    public String creatorEmail() {
        return  "http://www.example.com";
    }
}
