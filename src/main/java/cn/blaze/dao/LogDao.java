package cn.blaze.dao;

import cn.blaze.domain.po.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface LogDao {
    int deleteByPrimaryKey(String id);

    int insert(Log record);

    int insertSelective(Log record);

    Log selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);

    List<Log> selectByActorAndTime(@Param("actorid") String actorid, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<Log> selectByTime(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}