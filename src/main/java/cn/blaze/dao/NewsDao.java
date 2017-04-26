package cn.blaze.dao;

import cn.blaze.domain.po.News;
import org.springframework.stereotype.Repository;

public interface NewsDao {
    int deleteByPrimaryKey(String id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
}