package org.gfarm.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.gfarm.entity.GfComrade;
import org.gfarm.entity.GfComradeExample;

public interface GfComradeMapper extends BaseMapper<GfComrade>{
    long countByExample(GfComradeExample example);

    int deleteByExample(GfComradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GfComrade record);

    int insertSelective(GfComrade record);

    List<GfComrade> selectByExample(GfComradeExample example);

    GfComrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GfComrade record, @Param("example") GfComradeExample example);

    int updateByExample(@Param("record") GfComrade record, @Param("example") GfComradeExample example);

    int updateByPrimaryKeySelective(GfComrade record);

    int updateByPrimaryKey(GfComrade record);
}