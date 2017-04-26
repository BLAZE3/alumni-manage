package cn.blaze.dao;

import cn.blaze.domain.po.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface NewsDao {
    int deleteByPrimaryKey(String id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);

    List<News> selectByTimeSize(@Param("size") int size, @Param("date") Date date);

    int updateValid(String id);
}