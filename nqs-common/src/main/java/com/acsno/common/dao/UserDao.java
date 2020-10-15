package com.acsno.common.dao;


import com.acsno.common.entity.UserEntity;
import com.acsno.ext.dto.UserDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

    UserDto getInfoById(long id);

    UserDto getInfoByUserName(String userName);
}
