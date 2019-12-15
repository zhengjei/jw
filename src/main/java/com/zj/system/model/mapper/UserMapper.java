package com.zj.system.model.mapper;

import com.zj.system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface UserMapper {

    /**
     * 直接获取所有的有效数据
     * @return list
     */
    List<User> selectUserList();
}
