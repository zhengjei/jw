package com.zj.system.model.service;

import com.zj.system.entity.User;
import com.zj.system.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Service("user")
public class UserServise {
    @Autowired
    private UserMapper userMapper;

    /**
     * 直接获取所有的数据
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<User> selectList() {
        return userMapper.selectUserList();
    }

}
