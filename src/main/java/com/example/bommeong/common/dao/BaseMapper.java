package com.example.bommeong.common.dao;

import com.example.bommeong.common.dto.BaseEntity;
import com.example.bommeong.common.dto.PageEntity;

import java.util.List;

public interface BaseMapper<Entity extends BaseEntity, PkType> {

    int totalCnt(PageEntity<Entity> pageEntity);

    List<Entity> selectList(PageEntity<Entity> pageEntity);

    Entity selectDetail(PkType pk);

    int insert(Entity entity);

    int update(Entity entity);

    int delete(PkType pk);

}
