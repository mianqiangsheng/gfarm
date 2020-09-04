package org.gfarm.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.gfarm.entity.GfTest;
import org.gfarm.entity.GfTestExample;

public interface GfTestMapper extends BaseMapper<GfTest> {

    long countByExample(GfTestExample example);

    int deleteByExample(GfTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GfTest record);

    int insertSelective(GfTest record);

    List<GfTest> selectByExample(GfTestExample example);

    GfTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GfTest record, @Param("example") GfTestExample example);

    int updateByExample(@Param("record") GfTest record, @Param("example") GfTestExample example);

    int updateByPrimaryKeySelective(GfTest record);

    int updateByPrimaryKey(GfTest record);
}