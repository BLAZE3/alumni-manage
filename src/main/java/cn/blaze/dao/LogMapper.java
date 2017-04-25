package cn.blaze.dao;

import cn.blaze.domain.po.Log;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper {
    int deleteByPrimaryKey(String id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}