package com.pxkj.dao;

import com.pxkj.entity.SysPermission;
import com.pxkj.entity.SysRole;
import com.pxkj.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Slf4j
@Repository
public class UserDao {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private SysRole admin = new SysRole("ADMIN", "管理员");
    private SysRole user = new SysRole("USER", "会员");

    {
        SysPermission p1 = new SysPermission();
        p1.setCode("UserIndex");
        p1.setName("个人中心");
        p1.setUrl("/user/index");
        SysPermission p2 = new SysPermission();
        p2.setCode("UserList");
        p2.setName("用户列表");
        p2.setUrl("/user/list");
        SysPermission p3 = new SysPermission();
        p3.setCode("UserAdd");
        p3.setName("用户添加");
        p3.setUrl("/user/add");
        SysPermission p4 = new SysPermission();
        p4.setCode("UserDetail");
        p4.setName("用户详情");
        p4.setUrl("/user/detail");
        admin.setPermissionList(Arrays.asList(p1, p2, p3, p4));
        user.setPermissionList(Arrays.asList(p1, p2));
    }

    public SysUser getUserByName(String username) {
        log.info("从数据库查询用户数据");
        if ("zhangsan".equals(username)) {
            SysUser sysUser = new SysUser("zhangsan", passwordEncoder.encode("123456"));
            sysUser.setRoleList(Arrays.asList(admin, user));
            return sysUser;
        } else if ("lisi".equals(username)) {
            SysUser sysUser = new SysUser("lisi", passwordEncoder.encode("123456"));
            sysUser.setRoleList(Arrays.asList(user));
            return sysUser;
        }
        return null;
    }

}
