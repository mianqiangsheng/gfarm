package org.gfarm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.gfarm.dto.request.GfComradeDto;

import java.util.List;

public interface GfComradeService {

    int add(GfComradeDto gfComradeDto);

    IPage<GfComradeDto> pageList(GfComradeDto gfComradeDto, Integer pageNum, Integer pageSize);

    int deleteByIds(List<Integer> ids);

    int updateByPrimaryKey(GfComradeDto gfComradeDto);
}
