package com.yicj.study.hello.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName sys_permission
 */
@TableName(value ="sys_permission")
@Data
public class Permission implements Serializable {
    /**
     * 权限id
     */
    @TableId(type = IdType.AUTO)
    private Integer pid;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 请求的url, 可以填正则表达式
     */
    private String url;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}