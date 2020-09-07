package org.gfarm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.gfarm.dto.request.GfTestDto;
import org.gfarm.entity.GfTest;
import org.gfarm.entity.GfTestExample;
import org.gfarm.mapper.GfTestMapper;
import org.gfarm.service.GfTestService;
import org.gfarm.util.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GfTestServiceImpl implements GfTestService {

    @Resource
    private GfTestMapper gfTestMapper;

    @Override
    public int insert(GfTestDto gfTestDto) {
        GfTest gfTest = new GfTest();
        BeanUtils.copyPropertiesIgnoreNull(gfTestDto,gfTest);
        int i = gfTestMapper.insert(gfTest);
        return i;
    }

    @Override
    public IPage<GfTestDto> pageList(GfTestDto gfTestDto, Integer pageNum, Integer pageSize) {

        IPage<GfTest> page = new Page<>(pageNum == null ? 1 : pageNum, pageSize == null ? 10 : pageSize);
        LambdaQueryWrapper<GfTest> queryWrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(gfTestDto.getName()))
            queryWrapper.like(GfTest::getName,gfTestDto.getName());
        if (StringUtils.isNotBlank(gfTestDto.getCareer()))
            queryWrapper.like(GfTest::getCareer,gfTestDto.getCareer());
        if (gfTestDto.getAge() != null)
            queryWrapper.eq(GfTest::getAge,gfTestDto.getAge());

        IPage<GfTest> gfTestIPage = gfTestMapper.selectPage(page, queryWrapper);

        IPage<GfTestDto> gfTestDtoIPage = gfTestIPage.convert(gfTest -> {
            GfTestDto gfTestDto1 = new GfTestDto();
            BeanUtils.copyPropertiesIgnoreNull(gfTest, gfTestDto1);
            return gfTestDto1;
        });

        return gfTestDtoIPage;

    }

    @Override
    public int deleteByExample(GfTestExample example) {
        int i = gfTestMapper.deleteByExample(example);
        return i;
    }

    @Override
    public int updateByExampleSelective(GfTestDto gfTestDto, GfTestExample example) {
        GfTest gfTest = new GfTest();
        BeanUtils.copyPropertiesIgnoreNull(gfTestDto,gfTest);
        int i = gfTestMapper.updateByExampleSelective(gfTest, example);
        return i;
    }
}
