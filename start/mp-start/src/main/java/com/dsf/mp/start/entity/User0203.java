package com.dsf.mp.start.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 从 User 拷贝, 不同点是 类名,remark
 */
@Data
@TableName("user")
public class User0203 {
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Long managerId;

    private LocalDateTime createTime;

    @TableField(exist = false)
    private String remark;
}
