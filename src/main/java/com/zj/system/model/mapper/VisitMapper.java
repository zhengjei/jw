package com.zj.system.model.mapper;

import com.zj.system.entity.VisitEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface VisitMapper {
    /**
     * update对应行
     * @return Integer
     */
    Integer updateVisitEntity(String name);

    /**
     * 直接获取所有的有效数据
     * @return list
     */
    List<VisitEntity> selectVisitEntityList(VisitEntity visitEntity);
}
