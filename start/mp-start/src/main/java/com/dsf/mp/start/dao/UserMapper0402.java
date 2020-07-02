package com.dsf.mp.start.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dsf.mp.start.entity.User;
import com.dsf.mp.start.vo.UserVo;
import org.apache.ibatis.annotations.Param;

public interface UserMapper0402 extends BaseMapper<User> {

    IPage<User> selectUserPage0402(Page<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);

    IPage<User> selectUserPage0402Self(Page<User> page, @Param("vo") UserVo userVo);

}
