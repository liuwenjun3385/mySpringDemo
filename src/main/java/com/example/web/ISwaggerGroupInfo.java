package com.example.web;


/**
 * Swagger2分组模块信息配置接口
 */
public interface ISwaggerGroupInfo {


    /**
     * 分组是否启用
     *
     * @return
     */
    Boolean isEnable();

    /**
     * 分组显示排序号,不可以和已被使用的枚举重复！
     *
     * @return
     */
    SwaggerGroupSortEnum sortEnum();

    /**
     * 分组名称,支持中文
     *
     * @return String
     */
    String groupName();

    /**
     * 分组描述
     *
     * @return
     */
    String description();

    /**
     * 分组创建人
     *
     * @return
     */
    String creator();

    /**
     * 分组创建人email
     *
     * @return
     */
    String creatorEmail();
}
