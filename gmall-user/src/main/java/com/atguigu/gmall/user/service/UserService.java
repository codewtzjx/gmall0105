package com.atguigu.gmall.user.service;

import com.atguigu.gmall.user.bean.UmsMember;

import java.util.List;

public interface UserService {
    /**
     * 获取所有的用户
     *
     * @return UmsMember
     */
    List<UmsMember> getAllUser();
}
