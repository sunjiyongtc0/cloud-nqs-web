package com.acsno.common.service;

import com.acsno.common.entity.UserEntity;
import com.acsno.ext.dto.UserDto;
import com.baomidou.mybatisplus.extension.service.IService;



public interface UserService extends IService<UserEntity> {
    /**
     * 保存用户
     */
    boolean saveUser(UserEntity user);

    /**
     * 根据id获取用户信息
     * */
    UserDto getInfoById(long id);


    UserDto getInfoByUserName(String userName);
}
