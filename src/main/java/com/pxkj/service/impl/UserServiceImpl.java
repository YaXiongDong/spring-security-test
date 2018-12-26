package com.pxkj.service.impl;

import com.pxkj.dao.UserDao;
import com.pxkj.entity.SysUser;
import com.pxkj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Cacheable(value = "authority", key = "#username")
    @Override
    public SysUser getUserByName(String username) {
        return userDao.getUserByName(username);
    }
}
