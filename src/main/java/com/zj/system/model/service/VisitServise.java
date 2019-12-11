package com.zj.system.model.service;

import com.zj.system.entity.VisitEntity;
import com.zj.system.model.mapper.VisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service("visit")
public class VisitServise {
    @Autowired
    private VisitMapper visitMapper;

    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public Integer updateTest(String name){
        return visitMapper.updateVisitEntity(name);
    }

    /**
     * 直接获取所有的数据
     *
     * @return list
     */
    @Transactional(readOnly = false, rollbackFor = SQLException.class)
    public List<VisitEntity> selectVisitEntityList(VisitEntity visitEntity) {
        return visitMapper.selectVisitEntityList(visitEntity);
    }
}
