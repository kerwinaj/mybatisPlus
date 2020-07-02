package com.dsf.mp.start.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.dsf.mp.start.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper0401 extends BaseMapper<User> {
    /**
     * 自定义sql
     */
    @Select("select * from `user` aaa ${ew.customSqlSegment}")
    List<User> selectAll040101(@Param(Constants.WRAPPER) Wrapper wrapper);

    List<User> selectAll040102(@Param(Constants.WRAPPER) Wrapper wrapper);

}
