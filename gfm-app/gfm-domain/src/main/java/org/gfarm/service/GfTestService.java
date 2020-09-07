package org.gfarm.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.gfarm.dto.request.GfTestDto;
import org.gfarm.entity.GfTestExample;


public interface GfTestService {

    int insert(GfTestDto gfTestDto);

    IPage<GfTestDto> pageList(GfTestDto gfTestDto, Integer pageNum, Integer pageSize);

    int deleteByExample(GfTestExample example);

    int updateByExampleSelective(GfTestDto gfTestDto, GfTestExample example);
}
