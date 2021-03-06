package com.dsf.mp.start.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 从 User 拷贝, 不同点是修改了 id, name, 类名
 */
@Data
@TableName("user")
public class User0202 {

    @TableId("id")
    private Long userId;

    @TableField("name")
    private String realName;

    private Integer age;

    private String email;

    private Long managerId;

    private LocalDateTime createTime;
}
