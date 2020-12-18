package com.example.controller;

import com.example.web.ISwaggerGroupInfo;
import com.example.web.SwaggerGroupSortEnum;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerInfoDemo implements ISwaggerGroupInfo {
    @Override
    public Boolean isEnable() {
        return true;
    }

    @Override
    public SwaggerGroupSortEnum sortEnum() {
        return SwaggerGroupSortEnum.DEMO1;
    }

    @Override
    public String groupName() {
        return "分组DEMO1";
    }

    @Override
    public String description() {
        return "Demo项目-分组1";
    }

    @Override
    public String creator() {
        return "Demo";
    }

    @Override
    public String creatorEmail() {
        return "example";
    }
}
